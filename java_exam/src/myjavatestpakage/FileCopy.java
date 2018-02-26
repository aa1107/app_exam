package myjavatestpakage;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {
    public static void main(String[] args){
        try{
            FileInputStream input = new FileInputStream("gallery.jpg");
            FileOutputStream output = new FileOutputStream("gallery1.jpg");
            int data;
            while((data = input.read())!=-1){
                output.write(data);
            }
            input.close();
            output.close();
            System.out.println("이미지를 복사했습니다.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
