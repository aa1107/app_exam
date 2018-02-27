package myjavatestpakage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class my0222Test1 {
    public static void main(String[] args) {

            Thread t2=new Thread(new Blue(2));

            Thread t3=new Thread(new Blue(3));

            Thread t4=new Thread(new Blue(4));

            Thread t5=new Thread(new Blue(5));

            Thread t6=new Thread(new Blue(6));

            Thread t7=new Thread(new Blue(7));

            Thread t8=new Thread(new Blue(8));

            Thread t9=new Thread(new Blue(9));

// Main 스레드

           /* t2.setPriority(1);

            t3.setPriority(2);

            t4.setPriority(4);

            t5.setPriority(4);

            t6.setPriority(4);

            t7.setPriority(4);

            t8.setPriority(9);
            t9.setPriority(9);*/

            t2.start();

            t3.start();

            t4.start();

            t5.start();

            t6.start();

            t7.start();

            t8.start();

            t9.start();

            System.out.println("main() 종료....");
    }
}

