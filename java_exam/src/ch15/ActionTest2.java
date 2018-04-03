package ch15;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionTest2 {
    private Frame frame;
    private Button btn1,btn2,btn3,btn4,btn5;

    public ActionTest2(){
        frame=new Frame("이벤트 핸들러 예제");
        btn1=new Button("btn1");
        btn2=new Button("btn2");
        btn3=new Button("btn3");
        btn4=new Button("btn4");
        btn5=new Button("btn5");
    }

    public void startFrame(){
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("버튼1 클릭");
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("버튼2 클릭");
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("버튼3 클릭");
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("버튼4 클릭");
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("버튼5 클릭");
            }
        });

        frame.add(btn1,"North");
        frame.add(btn2,"South");
        frame.add(btn3,"West");
        frame.add(btn4,"East");
        frame.add(btn5,"Center");

        frame.setSize(200,200);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        ActionTest2 a=new ActionTest2();
        a.startFrame();
    }


}
