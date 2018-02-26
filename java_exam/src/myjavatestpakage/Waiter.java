package myjavatestpakage;

public class Waiter extends Thread{
    String Waiter;
    Food food;

    public Waiter(String Waiter, Food food){
        this.Waiter = Waiter;
        this.food = food;
    }

    public void run(){
        while (true){
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }
            food.receiveOrder(Waiter);
        }
    }
}
