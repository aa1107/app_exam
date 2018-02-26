package myjavatestpakage;

public class Food {
    public synchronized void receiveOrder(String Waiter){
        for(int i=0;i<5;i++){
            System.out.println(Waiter+ " 이 주문을 받습니다.");
        }

        System.out.println(Waiter+" 가 주문을 주방에 전달합니다.");
        System.out.println();
    }

    public synchronized void makeFood(String Chef){
        for(int i=0;i<5;i++){
            System.out.println(Chef + " 음식을 만듭니다.");
        }

        System.out.println(Chef+"가 음식을 다 만들었습니다.");
        System.out.println();
    }
}
