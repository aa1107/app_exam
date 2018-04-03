package ch13;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer4 {
    public static void main(String[] args){
        InputStream is;
        PrintWriter pw=null;
        ServerSocket serverSocket;
        Socket s1=null;
        String data;
        BufferedReader br_in;

        try{
            FileWriter writer=new FileWriter("test/out.txt");
            serverSocket=new ServerSocket(5435);
            System.out.println("서버 실행 중...");
            s1=serverSocket.accept();

            is=s1.getInputStream();
            br_in=new BufferedReader(new InputStreamReader(is));
            pw=new PrintWriter(writer,true);
            while ((data=br_in.readLine())!=null){
                System.out.println(data);
                pw.println(data);
            }
            writer.close();
            pw.close();
            s1.close();
        }catch (IOException ie){
            ie.printStackTrace();
        }
    }
}
