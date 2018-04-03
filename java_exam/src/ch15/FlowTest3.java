package ch15;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FlowTest3 extends WindowAdapter{
    private Frame frame;
    private Button btn1,btn2,btn3;

    public FlowTest3(){
        frame=new Frame("Flow 예제");
        btn1=new Button("OK");
        btn2=new Button("Open");
        btn3=new Button("Close");
    }

    public void startFrame(){
        frame.addWindowListener(this);

        frame.setLayout(new FlowLayout());
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.setSize(100,100);
        frame.setVisible(true);
    }

    @Override
    public void windowClosing (WindowEvent e) {
        System.exit(0);
    }

    public static void main(String[] args){
        FlowTest3 flow=new FlowTest3();
        flow.startFrame();
    }
}
