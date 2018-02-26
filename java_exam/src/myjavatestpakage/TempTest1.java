package myjavatestpakage;

import java.io.*;
import java.util.Scanner;

public class TempTest1 {
    public static void main(String[] args){
        File file = new File("./myjavatestpakage","TempTest1");
        System.out.println("파일 경로 "+file.getPath());
        System.out.println("파일 이름 "+file.getName());
        System.out.println("파일의 상위디렉터리 "+file.getParent());
        System.out.println("파일의 절대경로 "+file.getAbsolutePath());
        System.out.println("파일이 절대경로인가 "+file.isAbsolute());
        System.out.println("파일이 존재하는가 "+file.exists());
        System.out.println("디렉터리인가 "+file.isDirectory());
        System.out.println("파일을 읽을 수 있나 "+file.canRead());
        System.out.println("파일을 쓸 수 있나 "+file.canWrite());
        System.out.println("파일의 바이트 크기는? "+file.length());
        boolean b = new File("./myjavatestpakage"+File.separator+"hello").mkdir();
        String[] listing = new File(".").list();
        System.out.println("현재 디렉터리 내용은?");
        for(int i=0;i<listing.length;i++){
            System.out.println(listing[i]);
        }
    }
}
