import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите температуру в градусах Цельсия: ");
        int celsius = scanner.nextInt();
        
        double farenheit = (celsius * 9.0 / 5) + 32;
        
        System.out.println("Температура в градусах Фаренгейта: " + farenheit);
       
        scanner.close();
    }
}