import java.util.Scanner;

public class MyTest0212 {
    public static void main(String[] args) throws MyException {
        MyTest0212 temp = new MyTest0212();
        System.out.println(temp.Math1(1,20));
    }
    public int Math1(int a, int b) throws MyException{
        int sum=0;

        sum = a+b;
        if(a+b>10){
            throw new MyException("에러발생");
        }

        return sum;
    }
}

