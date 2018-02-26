package myjavatestpakage;

import java.io.*;

public class TempTest2 {
    public static void main(String[] args){
        File file = new File("write1.txt");
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            PrintWriter out = new PrintWriter(new FileWriter("aaa.txt",true));
            String s;
            System.out.println("Exit : Ctrl + Z");
            while((s = in.readLine()) !=null){
                out.println(s);
            }
            in.close();
            out.close();
        }catch(IOException e){
            System.out.println("IOExcption");
        }
    }
}
