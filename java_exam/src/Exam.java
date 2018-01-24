import java.util.Scanner;
public class Exam{
    public static void main(String[] args){
        int num=2;
        while(num<10) {
            if (num % 5 == 0) {
                break;
            }
            System.out.println(num);
            num++;
        }
    }
}