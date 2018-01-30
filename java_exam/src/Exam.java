import java.util.Scanner;
public class Exam{
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        double input1;
        System.out.println("원의 넓이를 구하는 함수입니다\n반지름을 입력하세요");
        input1 = kb.nextDouble();
        System.out.println("원의 넓이는 " + circleCal(input1) + "입니다.");
    }

    public static double circleCal(double num1){
        double result;
        result = num1 * num1 * 3.14;
        return result;
    }
}