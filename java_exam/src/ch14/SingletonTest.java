package ch14;

public class SingletonTest {
    public static void main(String[] args){
        System.out.println("첫 번째 getInstance() 호출");
        MySingleton a = MySingleton.getInstance();

        System.out.println("두 번째 getInstance() 호출");
        MySingleton b = MySingleton.getInstance();

        if(a==b){
            System.out.println("두 싱글톤은 동일한 객체입니다.");
        }
        b.setAa(20);
        System.out.println(b.getAa());
        System.out.println(a.getAa());
    }
}
