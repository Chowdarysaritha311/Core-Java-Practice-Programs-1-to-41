import java.sql.*;

public class TransactionHandling {
    private Connection conn;

    public TransactionHandling(String url) throws SQLException {
        conn = DriverManager.getConnection(url);
        conn.setAutoCommit(false);
    }

    public void transferMoney(int fromAccount, int toAccount, double amount) {
        try (PreparedStatement debit = conn.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
             PreparedStatement credit = conn.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?")) {

            debit.setDouble(1, amount);
            debit.setInt(2, fromAccount);
            debit.executeUpdate();

            credit.setDouble(1, amount);
            credit.setInt(2, toAccount);
            credit.executeUpdate();

            conn.commit();
            System.out.println("Transaction successful");

        } catch (SQLException e) {
            try {
                conn.rollback();
                System.out.println("Transaction failed, rolled back");
            } catch (SQLException ex) {
                System.out.println("Rollback failed");
            }
            System.out.println(e.getMessage());
        }
    }

    public void close() throws SQLException {
        if (conn != null) conn.close();
    }

    public static void main(String[] args) {
        String url = "jdbc:sqlite:bank.db";
        try {
            TransactionHandling th = new TransactionHandling(url);
            th.transferMoney(1, 2, 500);
            th.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
