package ch16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogTest extends JFrame implements ActionListener {
    JLabel label=new JLabel("다이얼로그 테스트");
    JButton jbt=new JButton("첫 번째 다이얼로그 띄우기");
    JButton jbt2=new JButton("두 번째 다이얼로그 띄우기");
    Dialog1 tf2;

    public DialogTest(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new GridLayout(3,0));
        getContentPane().add(label);
        getContentPane().add(jbt);
        getContentPane().add(jbt2);
        this.setBounds(200,200,300,300);
        this.setVisible(true);

        jbt.addActionListener(this);
        jbt2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jbt){
            new Dialog1(e.getActionCommand() + " 버튼을 누르셨군요!");
        }else if(e.getSource()==jbt2){
            new Dialog2(this,label,"두 번째 다이얼로그 창입니다");
        }
    }

    public static void main(String[] args){
        new DialogTest();
    }
}
