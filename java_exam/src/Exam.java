import java.util.Scanner;

public class Exam{
    static int apple = 20;
    static int orange = 10;
    static int mymoney = 0;

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        System.out.println("과일장수는 과일을 팝니다.\n과일장수는 사과 20개, 오렌지 10개를 보유하고 있습니다.");
        System.out.println("판매한 사과의 갯수를 입력하시오: ");
        int inputnum = kb.nextInt();
        saleApple(inputnum);
        System.out.println("보유하고 있는 사과의 수: " + apple);
        System.out.println("판매 수익: " + mymoney);
    }

    public static void saleApple(int num){
        if(num>apple||num<0){
            System.out.println("유효한 값이 아닙니다.");
            return;
        }
        mymoney += num*1000;
        apple = apple - num;
    }
}