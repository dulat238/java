import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите трехзначное положительное число: ");
        int number = scanner.nextInt();
        
        if(number >=100 && number <=999){
            int hundreds = number /100;
            int units = number %10;
            
            if(hundreds == units){
                System.out.println("Число " + number + " является симметричным");
            }
            else{
                 System.out.println("Число " + number + " не является симметричным");
            }
        }
        else {
            System.out.println("Ошибка");
        }
        scanner.close();
    }
}