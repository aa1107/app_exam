import java.util.Scanner;
public class Exam{
    public static void main(String[] args){
        simplefunc(0);
    }
    public static void simplefunc(int num){
        System.out.println(num);
        num++;
        if(num==100){
            return;
        }
        simplefunc(num);
    }
}