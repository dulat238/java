import java.util.Scanner;

public class first {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = scanner.nextLine();

        String[] words = text.split(" ");
        System.out.println("Word count: " + words.length);

        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        System.out.println("Longest word: " + longestWord);

        int[] charCounts = new int[256]; 
        for (char c : text.toCharArray()) {
            charCounts[c]++;
        }

        System.out.println("Number of each symbol:");
        for (int i = 0; i < charCounts.length; i++) {
            if (charCounts[i] > 0) {
                System.out.println((char) i + " - " + charCounts[i]);
            }
        }

        System.out.println("Text in reserve order: " + new StringBuilder(text).reverse().toString());

        scanner.close();
    }
}
