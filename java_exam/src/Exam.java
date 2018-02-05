import java.util.Scanner;

public class Exam{
    static int apple = 20;
    static int orange = 10;
    static int mymoney = 0;

    public static void main(String[] args){
        Car myCar = new Car();
        String myCarColor = myCar.color;
        System.out.println(myCar.color);
        myCar.goForward(10);
        System.out.println(myCar.x_pos);
        myCar.goForward(10);
        System.out.println(myCar.x_pos);
    }

    /*public static void fruit(){
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
    }*/

}

class FruitSeller{
    int numOfapple=20;
    int myMoney1=0;

    public int SaleApple(int money){
        int num = money/1000;
        numOfapple -=num;
        myMoney1 += money;
        return num;
    }
}

class FruitBuyer{
    int myMoney1 = 5000;
    int numOfApple=0;

    public void buyApple(FruitSeller seller, int money){
        numOfApple+=seller.SaleApple(money);
        myMoney1-=money;
    }

    public void showBuyResult(){
        System.out.println("현재 잔액 : " + myMoney1);
        System.out.println("사과 개수 : " + numOfApple);
    }
}

class Car {
    String color = "black";
    String name = "k5";
    int x_pos = 0;

    public void goForward(int forward){
        int x_pos;
        x_pos = this.x_pos;
    }
    public int getCarPosition(){
        return x_pos;
    }
    public String getCarColor(){
        return color;
    }
    public String getCarName(){
        return name;
    }
}
