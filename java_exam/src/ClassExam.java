import java.util.Scanner;

public class ClassExam {
    public static void main(String[] args)
    {
        double num1;
        double num2;
        Scanner kb = new Scanner(System.in);
        num1 = kb.nextDouble();
        num2 = kb.nextDouble();
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
