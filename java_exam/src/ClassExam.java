import java.util.Scanner;

public class ClassExam {
    public static void main(String[] args)
    {
        String operator;
        double num1;
        double num2;
        Scanner kb = new Scanner(System.in);
        System.out.println("첫번째 숫자를 입력하세요");
        num1 = kb.nextDouble();
        kb.nextLine();
        System.out.println("연산을 선택하세요(덧셈:a, 뺄셈:b, 곱셈:c, 나눗셈:d, 나머지:e)");
        operator = kb.nextLine();
        System.out.println("두번째 숫자를 입력하세요.");
        num2 = kb.nextDouble();

        switch(operator){
            case "a":
                System.out.println("덧셈한 결과는 다음과 같습니다.");
                System.out.println(adder(num1,num2));
                break;
            case "b":
                System.out.println("뺄셈한 결과는 다음과 같습니다.");
                System.out.println(minus(num1,num2));
                break;
            case "c":
                System.out.println("곱셈한 결과는 다음과 같습니다.");
                System.out.println(multi(num1,num2));
                break;
            case "d":
                System.out.println("나눗셈한 결과는 다음과 같습니다.");
                System.out.println(divide(num1,num2));
                break;
            case "e":
                System.out.println("나머지한 결과는 다음과 같습니다.");
                System.out.println(modular(num1,num2));
                break;
                default:
                    System.out.println("지정된 값이 없습니다");
        }
    }

    public static double adder(double num1, double num2)
    {
        double result;
        result = num1 + num2;
        return result;
    }

    public static double multi(double num1, double num2)
    {
        double result;
        result = num1*num2;
        return result;
    }

    public static double divide(double num1, double num2)
    {
        double result;
        result = num1/num2;
        return result;
    }

    public static double minus(double num1, double num2)
    {
        double result;
        result = num1-num2;
        return result;
    }

    public static double modular(double num1, double num2)
    {
        double result;
        result = num1%num2;
        return result;
    }
}
