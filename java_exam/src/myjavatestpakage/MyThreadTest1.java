package myjavatestpakage;

public class MyThreadTest1 {
    public static void main(String[] args){

        MyThread1 mth1 = new MyThread1(1);
        MyThread1 mth2 = new MyThread1(2);
        Thread th1 = new Thread(mth1);
        Thread th2 = new Thread(mth2);

        th1.start();
        th2.start();
    }
}
