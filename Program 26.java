import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();
        String[] words = sentence.trim().split("\\s+");
        System.out.println("Number of words: " + words.length);
        sc.close();
    }
}
