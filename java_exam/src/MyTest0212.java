import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyTest0212 {
    public static void main(String[] args) {
        int i=0;
        for(i=0;i<5;i++){

        }
        System.out.println(i);
    }

    static public String myTempFunc(int temp){
        return Integer.toString(temp);
    }

    static class MyTempClass{
        int one;
        int two;

        /*@Override
        public String toString() {
            return (one+", "+two);
        }*/

        public MyTempClass(int one, int two) {
            this.one = one;
            this.two = two;
        }
    }
}

