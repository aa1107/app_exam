class Coffee
{
    boolean isInMilk;
    boolean isInCream;
    Coffee(boolean isInmilk, boolean isInCream){
             this.isInMilk = isInmilk;
             this.isInCream = isInCream;
    }

    Coffee(boolean isInCream){
        this.isInCream = isInCream;
        this.isInMilk = false;
    }

    public void showMenu(){
        if(this.isInCream){
            System.out.println("크림이 들어 있음");
        }else{
            System.out.println("크림이 안 들어 있음");
        }
        if(this.isInMilk){
            System.out.println("우유가 들어 있음");
        }else{
            System.out.println("우유가 안 들어 있음");
        }
    }
}
