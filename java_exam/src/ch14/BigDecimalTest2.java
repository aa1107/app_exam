package ch14;

import java.math.BigDecimal;

public class BigDecimalTest2 {
    public static void main(String[] args){
        System.out.println(3.00-2.10);
        BigDecimal d1 = new BigDecimal("3.00");
        BigDecimal d2 = new BigDecimal("2.10");

        BigDecimal result = d1.subtract(d2);
        double d = result.doubleValue();
        System.out.println(result+":"+d);
        result = d1.divide(d2,4,BigDecimal.ROUND_CEILING);
        System.out.println("나눈 결과:"+result);
    }
}
