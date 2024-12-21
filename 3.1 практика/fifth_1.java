import java.util.InputMismatchException;
import java.util.Scanner;

public class fifth_1 {

    public static double calculateAverage(double a, double b, double c) {
        return (a + b + c) / 3;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter three numbers to calculate the arithmetic mean: ");

            double num1 = scanner.nextDouble();
            double num2 = scanner.nextDouble();
            double num3 = scanner.nextDouble();

            double average = calculateAverage(num1, num2, num3);
            System.out.println("Arithmetic mean: " + average);

        } catch (InputMismatchException e) {
            System.out.println("Error: The entered number is not a number. Please enter valid numbers.");
        }
    }
}
