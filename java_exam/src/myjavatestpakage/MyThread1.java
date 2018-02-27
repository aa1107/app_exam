package myjavatestpakage;

public class MyThread1 implements Runnable {

    private int threadnum = 0;

    public MyThread1(int threadnum) {
        this.threadnum = threadnum;
    }

    @Override
    public void run() {
        synchronized (this){
            try{
               while(true) {
                   System.out.println("스레드 넘버: " + threadnum);
                   notify();
                   wait();
               }

            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public int GetThreadnum(int threadnum){
        return threadnum;
    }
}
