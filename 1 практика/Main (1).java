import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Число: ");
        int number = scanner.nextInt();
        
        if ( number <=0){
            System.out.println("Введите положительное число больше нуля");
            return;
        }
        System.out.println("Простые множители" + number + ":");
        
        for (int i=2; i<=number; i++){
            while (number %i == 0){
                System.out.println(i + "");
                number /= i;
            }
        }
        scanner.close();
    }
}