import java.util.Scanner;
public class Exam{
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        System.out.println("1000이하의 자연수를 입력받아 1부터 차례대로 입력받은 숫자까지 더한 결과를 출력하는 프로그램\n숫자를 입력하세요");
        int input1 = kb.nextInt();
        System.out.println("결과 : "+addOrder(input1));
    }

    public static int addOrder(int num){
        if(num>1000||num<0){
            System.out.println("1000이하의 자연수를 입력하세요");
            return 0;
        }
        int result=0;
        for(int st=1;st<=num;st++){
            result+=st;
        }
        return result;
    }

    public static double circleCal(double num1){
        double result;
        result = num1 * num1 * 3.14;
        return result;
    }
}