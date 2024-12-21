import java.util.InputMismatchException;
import java.util.Scanner;

public class third_1 {
    public static int findMax(int[] numbers) {
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the number of elements in the array:");
            int size = scanner.nextInt();

            if (size <= 0) {
                throw new IllegalArgumentException("The array size must be greater than 0.");
            }

            int[] numbers = new int[size];
            System.out.println("Enter " + size + " integers");
            for (int i = 0; i < size; i++) {
                numbers[i] = scanner.nextInt();
            }

            int max = findMax(numbers);
            System.out.println("Maximum array element: " + max);

        } catch (InputMismatchException e) {
            System.out.println("Error: The entered number is not an integer. Please enter correct information.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
