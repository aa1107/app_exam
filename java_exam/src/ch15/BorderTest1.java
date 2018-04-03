package ch15;

import java.awt.*;

public class BorderTest1 {
    private Frame frame;
    private Button center,west,east,north,south;
    private TextField tf1;

    public BorderTest1(){
        frame=new Frame("BorderLayout 예제");
        south=new Button("버튼1");
        west=new Button("버튼2");
        east=new Button("버튼3");
        center=new Button("aaa4");
        tf1=new TextField();
        tf1.setText("입력창입니다.");
    }

    private void startFrame(){
        frame.add(tf1,"North");
        //frame.add(south,"South");
        //frame.add(west,"West");
        frame.add(east,"East");
        frame.add(center,"Center");

        frame.setSize(400,400);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        BorderTest1 border=new BorderTest1();
        border.startFrame();
    }
}
