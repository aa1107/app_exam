package ch16;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class Client implements ActionListener, Runnable {
    private static final String SERVER_IP="서버 아이피 주소";

    private Socket socket;
    private JFrame jFrame;
    private JTextField jtf;
    private JTextArea jta;
    private JLabel jlb1,jlb2;
    private JPanel jp1, jp2;
    private String ip;
    private String chatName;
    private JButton jbtn;
    InputStream is;
    OutputStream os;
    BufferedReader br_in;
    BufferedWriter bw=null;
    PrintWriter pw=null;

    public Client(){
        chatName=JOptionPane.showInputDialog(jFrame,"대화명을 입력하세요!!","대화명 입력 다이얼로그",JOptionPane.YES_NO_OPTION);
        if(chatName.length()==0||chatName==null){
            System.exit(0);
        }
    }

    /*public void init(){
        try{
            socket=new Socket(ip,5000);
        }
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {

    }
}
