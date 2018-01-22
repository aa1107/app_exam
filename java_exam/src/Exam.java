public class Exam{
    public static void main(String[] args){
        int num1=2;
        while(num1<10){
            int  num2=1;
            System.out.println("----");
            System.out.println(num1+"단 출력");
            System.out.println("----");
            while(num2<10)
            {
                System.out.println(num1 + "x" + num2 + "=" + (num1 * num2));
                num2++;
            }
            num1++;
        }
    }
}