package myjavatestpakage;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterEx2 {
    public static void main(String[] args){
        PrintWriter pw = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        try{
            fos = new FileOutputStream("printWriter2.txt");
            bos = new BufferedOutputStream(fos);
            pw = new PrintWriter(bos, true);
            pw.println("안녕하세요");
            pw.println("또 만났네요");
            pw.println("Hello World");
            pw.println(100.0);
            pw.println(new Boolean(true));

            fos.close();
            bos.close();
            pw.close();
        }catch (IOException ie){
            System.out.println("IOException 발생");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
