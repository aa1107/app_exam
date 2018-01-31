import java.util.Scanner;
public class Exam{
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int a = kb.nextInt();
        repeat_10(a);
    }

    public static void repeat_10(int num){
        int num2=1;
        while(num2<=10){
            System.out.print(num2*num+" ");
            num2++;
        }
    }
}