package ch14;

public class MySingleton {
    private  static MySingleton mySingleton = null;
    private int aa=1;

    public int getAa() {
        return aa;
    }

    public void setAa(int aa) {
        this.aa = aa;
    }

    private MySingleton(){
        System.out.println("MySingleton 인스턴스 생성");
    }

    public static MySingleton getInstance(){
        if(mySingleton==null){
            mySingleton = new MySingleton();
        }
        return mySingleton;
    }
}
