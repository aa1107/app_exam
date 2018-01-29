import java.util.Scanner;
public class Exam{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        int inputnum1 = keyboard.nextInt();
        int result = Fibonacci(inputnum1);
        System.out.println(result);
    }
    public static int Fibonacci(int num)
    {
        if(num<=0){
            System.out.println("1이상의 정수를 입력해 주십시오.");
            return 0;
        }
        else if(num==1&num==2)
        {
            num=1;
            return num;
        }else if(num>=3) {
            return (Fibonacci(num - 1) + Fibonacci(num - 2));
        }
        return ;
    }
}