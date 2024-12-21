import java.util.InputMismatchException;
import java.util.Scanner;

public class first {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter an integer:");
                number = scanner.nextInt();
                validInput = true; 
            } catch (InputMismatchException e) {
                System.out.println("Error: You must enter an integer.");
                scanner.next();
            }
        }

        System.out.println("Sum " + number + ": " + sumDigits(number));
    }

    public static int sumDigits(int number) {
        number = Math.abs(number);
        if (number == 0) {
            return 0;
        }
        return (number % 10) + sumDigits(number / 10);
    }
}
