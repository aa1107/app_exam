package ch14;

import java.math.BigInteger;

public class BigIntegerTest1 {
    public static void main(String[] args){
        System.out.println("최대 정수: "+Long.MAX_VALUE);
        System.out.println("최소 정수: "+ Long.MIN_VALUE);

        BigInteger bValue1=new BigInteger("1000000000000000000000000000000000000000000");
        BigInteger bValue2=new BigInteger("-999999999999999999999999999999999999999999");

        BigInteger addResult=bValue1.add(bValue2);

        BigInteger mulResult=bValue1.multiply(bValue2);

        System.out.println(addResult);
        System.out.println(mulResult);
    }
}
