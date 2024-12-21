import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите целое число: ");
        int integerNumber = scanner.nextInt();
        
        if (integerNumber % 2 == 0){
            System.out.print ("Введите дробное число: ");
            double decimalNumber = scanner.nextDouble();
            double product = integerNumber * decimalNumber;
            System.out.println("Произведение: " + product);
        }
        else{
            System.out.print ("Введите другое число: ");
            int anotherInteger = scanner.nextInt();
            int sum = integerNumber + anotherInteger;
            System.out.println ("Сумма: " + sum);
        }
        scanner.close();
    }
}