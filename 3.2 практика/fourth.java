import java.util.InputMismatchException;
import java.util.Scanner;

public class fourth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter a non-negative integer (n):");
                n = scanner.nextInt();

                if (n < 0) {
                    System.out.println("Error: The number must be non-negative.");
                } else {
                    validInput = true; 
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: You must enter an integer.");
                scanner.next(); 
            }
        }

        System.out.println(n + "-th Fibonacci number: " + fibonacci(n));
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0; 
        }
        if (n == 1) {
            return 1; 
        }
        return fibonacci(n - 1) + fibonacci(n - 2); 
    }
}

