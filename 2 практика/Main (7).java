import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print ("Введите целое положительное число x: ");
        int x= scanner.nextInt();
        
        if(x <= 0){
            System.out.print ("Ошибка");
        }
        else{
            for(int i =-(x-1); i<=(x-1); i++){
                System.out.print (i + " ");
            }
        }
        scanner.close();
    }
}