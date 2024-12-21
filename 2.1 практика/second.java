import java.util.Scanner;

public class second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String previousWord = ""; 
        String currentWord;
        int playerTurn = 1; 
        boolean gameOver = false; 
        
        System.out.println("Welcome to the game 'Cities'!");
        System.out.println("Rules: Enter a word starting with the last letter of the previous one.");
        System.out.println("To end the game, enter 'stop'.");

        while (!gameOver) {
            System.out.println("Player's turn " + playerTurn + ":");
            currentWord = scanner.nextLine().trim().toLowerCase();

            if (currentWord.equals("stop")) {
                System.out.println("Game over.");
                gameOver = true;
                break;
            }

            if (previousWord.isEmpty()) {
                previousWord = currentWord;
            } else {
                char lastChar = previousWord.charAt(previousWord.length() - 1);
                if (currentWord.charAt(0) != lastChar) {
                    System.out.println("Error! The word must begin with a letter'" + lastChar + "'. Player " + playerTurn + " lost");
                    gameOver = true;
                    break;
                }
            }

            playerTurn = playerTurn == 1 ? 2 : 1;
            previousWord = currentWord; 
        }

        scanner.close();
    }
}
