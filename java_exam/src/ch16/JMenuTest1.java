package ch16;

import javax.swing.*;
import java.awt.*;

public class JMenuTest1 extends JFrame{
    JFrame f;
    JMenuBar menuBar;
    JMenu carMenu, memberMunu, rentMenu, helpMenu;
    JMenuItem carMenu11,carMenu12,carMenu13,carMenu14;
    JMenuItem memMenu21,memMenu22,memMenu23,memMenu24;
    JMenuItem helpMenu41;
    JPanel jPanel;
    JLabel lCarName;
    JTextField tf;
    JButton searchBtn;

    public JMenuTest1(){
        f=new JFrame("렌터카 예약 시스템");
        menuBar = new JMenuBar();
        carMenu = new JMenu("차량 관리");
        memberMunu = new JMenu("회원관리");
        rentMenu = new JMenu("예약관리");
        helpMenu = new JMenu("도움말");
    }

    protected void startFrame(){
        f.setJMenuBar(menuBar);
        menuBar.add(carMenu);

        carMenu.add(carMenu11=new JMenuItem("차량등록"));
        carMenu.add(carMenu12=new JMenuItem("차량조회"));
        carMenu.addSeparator();
        carMenu.add(carMenu13=new JMenuItem("차량수정"));
        carMenu.add(carMenu14=new JMenuItem("차량삭제"));

        menuBar.add(memberMunu);
        memberMunu.add(memMenu21=new JMenuItem("회원등록"));
        memberMunu.add(memMenu22=new JMenuItem("회원조회"));
        memberMunu.addSeparator();
        memberMunu.add(memMenu23=new JMenuItem("회원수정"));
        memberMunu.add(memMenu24=new JMenuItem("회원삭제"));

        menuBar.add(helpMenu);
        helpMenu.add(helpMenu41=new JMenuItem("버전"));

        jPanel = new JPanel();
        lCarName=new JLabel("차량명");
        tf=new JTextField(10);
        searchBtn=new JButton("차량 조회하기");

        jPanel.add(lCarName);
        jPanel.add(tf);
        jPanel.add(searchBtn);

        Container con=f.getContentPane();
        con.add(jPanel,"North");

        f.setLocation(200,100);
        f.setSize(800,600);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args){
        JMenuTest1 test=new JMenuTest1();
        test.startFrame();
    }
}
