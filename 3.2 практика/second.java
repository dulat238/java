import java.util.InputMismatchException;
import java.util.Scanner;

public class second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter a non-negative integer (n):");
                number = scanner.nextInt();
                
                if (number < 0) {
                    System.out.println("Error: Factorial is defined only for non-negative numbers.");
                } else {
                    validInput = true; 
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: You must enter an integer.");
                scanner.next(); 
            }
        }

        System.out.println("Factorial of a number " + number + ": " + factorial(number));
    }

    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1; 
        }
        return n * factorial(n - 1); 
    }
}
