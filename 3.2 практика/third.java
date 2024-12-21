import java.util.InputMismatchException;
import java.util.Scanner;

public class third {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = 0;
        int n = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Введите число (a):");
                a = scanner.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: необходимо ввести число.");
                scanner.next(); 
            }
        }

        validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter an integer for the degree (n):");
                n = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: You must enter an integer.");
                scanner.next(); 
            }
        }

        System.out.println(a + " to a degree " + n + " = " + power(a, n));
    }

    public static double power(double a, int n) {
        if (n == 0) {
            return 1; 
        }
        if (n > 0) {
            return a * power(a, n - 1); 
        } else {
            return 1 / power(a, -n); 
        }
    }
}
