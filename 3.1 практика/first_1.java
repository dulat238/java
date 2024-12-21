import java.util.InputMismatchException;
import java.util.Scanner;

public class first_1 {

    public static int sum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the first integer:");
            int num1 = scanner.nextInt();

            System.out.println("Enter the second integer:");
            int num2 = scanner.nextInt();

            int result = sum(num1, num2);
            System.out.println("Sum: " + result);

        } catch (InputMismatchException e) {
            System.out.println("Error");
        }
    }
}
