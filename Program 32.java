import java.sql.*;

public class StudentDAO {
    private Connection conn;

    public StudentDAO(String url) throws SQLException {
        conn = DriverManager.getConnection(url);
    }

    public void insertStudent(int id, String name) throws SQLException {
        String sql = "INSERT INTO students(id, name) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
            System.out.println("Student inserted");
        }
    }

    public void updateStudentName(int id, String newName) throws SQLException {
        String sql = "UPDATE students SET name = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newName);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("Student updated");
        }
    }

    public void close() throws SQLException {
        if (conn != null) conn.close();
    }

    public static void main(String[] args) {
        String url = "jdbc:sqlite:students.db";
        try {
            StudentDAO dao = new StudentDAO(url);
            dao.insertStudent(1, "Alice");
            dao.updateStudentName(1, "Alice Smith");
            dao.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
