import java.util.Scanner;
public class Exam{
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        System.out.println("음수라면 양수로 바꾸는 함수\n숫자를 입력하세요");
        double input1 = kb.nextDouble();
        System.out.println(toPositive(input1));
        System.out.println("분모 '0'인 경우 메시지 출력해주는 함수\n분자를 입력하세요");
        double input2 = kb.nextDouble();
        System.out.println("분모를 입력하세요");
        double input3 = kb.nextDouble();
        System.out.println(divideFilter(input2,input3));
    }

    public static double toPositive(double num)
    {
        if(num<0){
            num= -num;
            return num;
        }
        return num;
    }

    public static double divideFilter(double num1, double num2)
    {
        if(num2==0){
            System.out.println("나눗셈을 할 수 없습니다.");
            return 0;
        }
        return num1/num2;
    }
}