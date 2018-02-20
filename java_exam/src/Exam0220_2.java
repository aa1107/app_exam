import java.util.Random;

public class Exam0220_2 {
    public static void main(String[] args){
        int num1 = 3;
        Integer integer = new Integer(num1);

        double num2 = integer.doubleValue();
        Random random = new Random();
        System.out.println(num2);
        System.out.println(Integer.toString(44));
        System.out.println(Integer.max(5,6));
        int k=0;
        while(k<10) {
            System.out.println(random.nextInt(10));
            k++;
        }

        switch (random.nextInt(3)){
            case 0:
                System.out.println("가위");
                break;
            case 1:
                System.out.println("바위");
                break;
            case 2:
                System.out.println("보");
        }
    }
}
