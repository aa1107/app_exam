package myjavatestpakage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterEx1 {
    public static void main(String[] args){
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        try{
            fw = new FileWriter("printWriter1.txt");
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw,true);
            pw.println("안녕하세요");
            pw.println("반갑습니다");
            pw.println("Hello World");
            pw.println(100);
            pw.println(new Integer(20000));

            fw.close();
            bw.close();
            pw.close();
        }catch (IOException ie){
            System.out.println("IOException 발생");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
