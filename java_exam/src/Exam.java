import java.util.Scanner;
public class Exam{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        int a=keyboard.nextInt();
        for(int num=1;num<=10;num++){
            System.out.println(a*num);
        }
        int num=1;
        do{
            System.out.println(a*num);
            num++;
        }while (num<=10);
        num=1;
        while(num<=10){
            System.out.println(a*num);
            num++;
        }
    }
}