package myjavatestpakage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args){
        File file = new File("write1.txt");
        FileReader fr = null;
        try{
            fr = new FileReader(file);
            int readChar;
            while ((readChar = fr.read())!=-1){
                System.out.print((char)readChar);
            }
        }catch (IOException ie){
            ie.printStackTrace();
        }finally {
            try{
                if(fr!=null)fr.close();
            }catch (IOException ie){
                ie.printStackTrace();
            }
        }
    }
}
