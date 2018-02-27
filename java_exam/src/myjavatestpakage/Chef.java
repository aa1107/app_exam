package myjavatestpakage;

public class Chef extends Thread {
    String Chef;
    Food food;

    public Chef(String Chef, Food food){
        this.Chef = Chef;
        this.food = food;
    }

    public void run(){
        while(true){
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }
            food.makeFood(Chef);
        }
    }
}
