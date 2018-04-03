package ch15;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventTest implements ActionListener{
    private Frame frame;
    private Button btn1,btn2,btn3,btn4,btn5;

    public EventTest(){
        frame=new Frame("이벤트 핸들러 예제");

        //이벤트 소스 설정
        btn1=new Button("btn1");
        btn2=new Button("btn2");
        btn3=new Button("btn3");
        btn4=new Button("btn4");
        btn5=new Button("btn5");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("btn1")) System.out.println("버튼1 클릭");
        if(e.getActionCommand().equals("btn2")) System.out.println("버튼2 클릭");
        if(e.getActionCommand().equals("btn3")) System.out.println("버튼3 클릭");
        if(e.getActionCommand().equals("btn4")) System.out.println("버튼4 클릭");
        if(e.getSource()==btn5) System.out.println("버튼5 클릭");
    }

    public void startFrame(){
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);

        frame.add(btn1,"North");
        frame.add(btn2,"South");
        frame.add(btn3,"West");
        frame.add(btn4,"East");
        frame.add(btn5,"Center");

        frame.setSize(200,200);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        EventTest border=new EventTest();
        border.startFrame();
    }
}
