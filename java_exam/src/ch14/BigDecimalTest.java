package ch14;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args){
        System.out.println(3.00-2.10);

        BigDecimal b1 = new BigDecimal("3.00");
        BigDecimal b2 = new BigDecimal("2.10");
        System.out.println(b1.subtract(b2));
    }
}
