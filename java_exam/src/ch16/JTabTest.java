package ch16;

import javax.swing.*;

public class JTabTest extends JFrame {
    ImageIcon icon1,tabicon;
    JButton btn1, btn2;
    JTabbedPane jp;
    JLabel jlab;
    JPanel jpan;
    JTextField tf1;
    JTextArea tArea;
    public JTabTest(){
        super("탭 테스트");

        icon1=new ImageIcon("london.jpg");
        jlab=new JLabel(icon1);
        tabicon=new ImageIcon("gallery.jpg");

        jpan=new JPanel();
        tf1=new JTextField("테스트입니다");
        btn1=new JButton("전송");
        jpan.add(tf1);
        jpan.add(btn1);

        tArea=new JTextArea(7,20);
        tArea.setText("내용을 입력하세요");
        jp=new JTabbedPane();

        jp.addTab("탭1",jlab);
        jp.addTab("탭2",new JPanel().add(tArea));

        jp.addTab("탭3",tabicon,jpan,"세 번째 탭입니다");

        add(jp);

        setBounds(0,0,1400,1400);
        setVisible(true);
    }
    public static void main(String[] args){
        new JTabTest();
    }
}
