import java.util.Scanner;

public class MyTest0212 {
    public static void main(String[] args) {
        Math1 k = new Math1();
        k.adder1(3,4);
        k.adder1(3,4,5);
    }
    public static class Math1{

        public void adder1(int num1, int num2){
            System.out.println(num1+num2);
        }

        public void adder1(int num1, int num2, int num3){
            System.out.println(num1+num2+num3);
        }
    }
}

