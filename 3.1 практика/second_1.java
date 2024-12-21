import java.util.Scanner;

public class second_1 {

    public static void printGreeting(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter your name:");
            String name = scanner.nextLine();

            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("Error: Name cannot be empty.");
            }

            printGreeting(name);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

