import java.util.Scanner;
public class Exam{
    public static void main(String[] args){
        int num=2;
        while(num<10) {
            num++;
            if (num % 5 == 0) {
                continue;
            }
            System.out.println(num);
        }
    }
}