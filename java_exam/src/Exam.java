import java.util.Scanner;
public class Exam{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        Scanner keyboard2 = new Scanner(System.in);
        System.out.println("프로그램의 시작");
        System.out.println("안녕하세요 반갑습니다");
        System.out.println("이름을 입력해 주세요");
        String myname1 = keyboard.nextLine();
        System.out.println("나이를 입력해 주세요");
        int myage1 = keyboard.nextInt();
        hiEveryone(myname1, myage1);
        System.out.println("이름을 입력해 주세요");
        String myname2 = keyboard2.nextLine();
        System.out.println("나이를 입력해 주세요");
        int myage2 = keyboard2.nextInt();
        hiEveryone(myname2, myage2);
        System.out.println("프로그램의 끝");
    }
    public static void hiEveryone(String myname, int age)
    {
        System.out.println("좋은 아침입니다");
        System.out.println("제 이름은 "+ myname + "입니다");
        System.out.println("제 나이는 " + age + "세 입니다");
    }

}