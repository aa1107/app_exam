package ch15;

import java.awt.*;

public class ActionTest {
    private Frame frame;
    private Button btn1,btn2,btn3,btn4,btn5;

    public ActionTest(){
        frame=new Frame("이벤트 핸들러 예제");
        btn1=new Button("btn1");
        btn2=new Button("btn2");
        btn3=new Button("btn3");
        btn4=new Button("btn4");
        btn5=new Button("btn5");
    }

    public void startFrame(){
        ActionHandler aa=new ActionHandler();
        btn1.addActionListener(aa);
        btn2.addActionListener(aa);
        btn3.addActionListener(aa);
        btn4.addActionListener(aa);
        btn5.addActionListener(aa);

        frame.add(btn1,"North");
        frame.add(btn2,"South");
        frame.add(btn3,"West");
        frame.add(btn4,"East");
        frame.add(btn5,"Center");

        frame.setSize(200,200);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        ActionTest a=new ActionTest();
        a.startFrame();
    }
}
