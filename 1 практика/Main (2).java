import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Исходная цена: ");
        double originalPrice = scanner.nextDouble();
        
        System.out.print("Процент скидки: ");
        double discountPersentage = scanner.nextDouble();
        
        double discountedPrice = originalPrice * (1 - discountPersentage / 100);
        
        System.out.printf("Новая цена: %.2f%n", discountedPrice);
       
        scanner.close();
    }
}