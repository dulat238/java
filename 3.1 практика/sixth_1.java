import java.util.InputMismatchException;
import java.util.Scanner;

public class sixth_1 {

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int multiply(int a, int b, int c) {
        return a * b * c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter two numbers to multiply: ");
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            int result1 = multiply(num1, num2);
            System.out.println("The result of multiplying two numbers: " + result1);

            System.out.println("Enter three numbers to multiply: ");
            int num3 = scanner.nextInt();
            int num4 = scanner.nextInt();
            int num5 = scanner.nextInt();
            int result2 = multiply(num3, num4, num5);
            System.out.println("The result of multiplying three numbers: " + result2);

        } catch (InputMismatchException e) {
            System.out.println("Error");
        }
    }
}
