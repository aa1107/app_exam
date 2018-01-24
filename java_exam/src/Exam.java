import java.util.Scanner;
public class Exam{
    public static void main(String[] args){
        //숫자를 저장하는 변수
        int num=1;
        //숫자를 1씩 증가 시키면서 6의 배수이고 14의 배수인지 반복하여 무한루프로 검사
        while(true) {
            //숫자를 6으로 나누어서 값이 0이고 숫자를 14로 나누어서 값이 0이어야 if부분이 참
            if (num % 6 == 0&&num%14==0) {
                //무한루프를 탈출
                break;
            }
            //숫자를 1 증가시킴
            num++;
        }
        // 6과 14의 공배수를 출력
        System.out.println(num);
    }
}