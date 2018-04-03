package ch12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularTest {
    public static void main(String[] args){
        String numeral = "";
        String s="112233 4545";
        //String s="112223aa";

        String[] strArr={"012a","123","123ab","ab123"};
        String patternStr = "^[0-9]*$";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher=null;

        matcher = pattern.matcher(s);
        while(matcher.find()){
            numeral += matcher.group(0);
        }

        if(numeral != null&&!(numeral.length()==0)){
            System.out.println(s+"는 숫자입니다.");
        }else{
            System.out.println("숫자가 아닙니다");
        }

        numeral = "";
    }
}
