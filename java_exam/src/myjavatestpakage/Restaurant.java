package myjavatestpakage;

public class Restaurant {
    public static void main(String[] args){
        Food food = new Food();

        Waiter Waiter = new Waiter("웨이터", food);
        Chef Chef = new Chef("주방장",food);
        System.out.println("시작!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Waiter.start();
        Chef.start();
    }
}
