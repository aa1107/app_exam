package ch16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JOptionPaneTest extends JFrame implements ActionListener {
    JButton btn1,btn2,btn3,btn4;
    String[] str={"카드결제","게좌이체"};

    public JOptionPaneTest(){
        super("팝업창 테스트");
        setLayout(new FlowLayout());

        btn1=new JButton("메시지 다이얼로그");
        btn2=new JButton("컨펌 다이얼로그");
        btn3=new JButton("입력 다이얼로그");
        btn4=new JButton("옵션 다이얼로그");

        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);

        pack();
        setLocation(300,300);
        setVisible(true);

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1){
            JOptionPane.showMessageDialog(this,"메시지 다이얼로그 박스","메시지",JOptionPane.INFORMATION_MESSAGE);
        }else if(e.getSource()==btn2){
            JOptionPane.showMessageDialog(this,"확인 다이얼로그 박스","확인",JOptionPane.YES_NO_CANCEL_OPTION);
        }else if(e.getSource()==btn3){
            String answer=JOptionPane.showInputDialog(this,"입력 다이얼로그 박스","입력",JOptionPane.YES_NO_OPTION);
            System.out.println("입력한 값은:"+answer);
        }else if(e.getSource()==btn4){
            JOptionPane.showOptionDialog(this,"옵션 다이얼로그 박스","옵션",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,null,str,str[0]);
        }
    }

    public static void main(String[] args){
        new JOptionPaneTest();
    }
}
