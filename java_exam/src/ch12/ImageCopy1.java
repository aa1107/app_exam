package ch12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImageCopy1 {
    public static void main(String[] args){
        try{
            File file = new File("C:\\Users\\for\\Desktop\\london.jpg");
            FileInputStream input = new FileInputStream(file);
            FileOutputStream output = new FileOutputStream("C:\\Users\\for\\Desktop\\london_copy.jpg");
            int data;
            System.out.println("파일 크기는: "+file.length()+"바이트");

            long begin = System.currentTimeMillis();

            byte[] buffer = new byte[100000];

            while(true){
                int count = input.read(buffer);
                if(count==-1) break;
                output.write(buffer,0,count);
            }

            input.close();
            output.close();
            System.out.println("이미지를 복사했습니다.");
            long end = System.currentTimeMillis();
            System.out.println("복사시간은 :" +(end-begin)+"ms입니다.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
