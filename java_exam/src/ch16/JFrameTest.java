package ch16;

import javax.swing.*;
import java.awt.*;

public class JFrameTest extends JFrame {
    public JFrameTest(){
        super("Jframe 테스트");

        JButton btn1=new JButton("추가");
        JTextField tf1=new JTextField("Jframe 테스트");
        JButton btn2=new JButton("삭제");

        Container con=getContentPane();
        con.add(tf1,"North");
        con.add(btn1,"Center");
        con.add(btn2,"South");

        setSize(200,300);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        new JFrameTest();
    }
}
