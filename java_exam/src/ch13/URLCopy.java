package ch13;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class URLCopy {
    public static void main(String[] args){
        try{
            URL url=new URL("http://image.yes24.com/momo/TopCate562/MidCate001/56108824.jpg");
            InputStream in=url.openStream();
            FileOutputStream out=new FileOutputStream("C:\\Users\\for\\Desktop\\mytempfile/book_image.png");

            long begin=System.currentTimeMillis();
            byte  [] buffer=new byte[102400];

            while(true){
                int count=in.read(buffer);

                if(count==-1){
                    break;
                }

                out.write(buffer,0,count);
            }
            in.close();
            out.close();
            System.out.println("이미지를 다운로드했습니다..");
            long end=System.currentTimeMillis();
            System.out.println("복사 시간은 :"+(end-begin)+"ms입니다.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
