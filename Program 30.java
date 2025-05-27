import java.util.Scanner;

public class SumNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();
        int sum = n * (n + 1) / 2;
        System.out.println("Sum of first " + n + " natural numbers is: " + sum);
        sc.close();
    }
}
