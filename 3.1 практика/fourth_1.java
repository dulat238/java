import java.util.InputMismatchException;
import java.util.Scanner;

public class fourth_1 {

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter an integer to check for parity: ");
            int num = scanner.nextInt();

            if (isEven(num)) {
                System.out.println("Number " + num + " is even");
            } else {
                System.out.println("Number " + num + " is not even.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Error");
        }
    }
}
