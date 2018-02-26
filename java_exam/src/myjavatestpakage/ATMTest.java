package myjavatestpakage;

public class ATMTest {
    public static void main(String[] args){
        ATM atm = new ATM();
        Thread hong = new Thread(atm,"홍길동");
        Thread lee = new Thread(atm, "이순신");

        hong.start();
        lee.start();
    }
}
