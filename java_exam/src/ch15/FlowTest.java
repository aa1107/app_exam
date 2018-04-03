package ch15;

import java.awt.*;

public class FlowTest {
    private Frame frame;
    private Button button1;
    private Button button2;
    private Button button3;

    public FlowTest(){
        frame = new Frame("FlowLayout 예제");
        button1=new Button("확인");
        button2=new Button("열기");
        button3=new Button("닫기");
    }

    public void startFrame(){
        frame.setLayout(new FlowLayout());
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.setVisible(true);
        frame.setSize(300,300);
    }

    public static void main(String[] args){
        FlowTest flow=new FlowTest();
        flow.startFrame();
    }
}
