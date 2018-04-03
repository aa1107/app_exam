package ch15;

import java.awt.*;

public class GridTest {
    private Frame frame;
    private Button b1,b2,b3;
    private TextField tf1,tf2,tf3;

    public GridTest(){
        frame=new Frame("GridLayout 예제");
        b1=new Button("버튼1");
        b2=new Button("버튼2");
        b3=new Button("버튼3");
        tf1=new TextField("입력창1 입니다.");
        tf2=new TextField("입력창2 입니다.");
        tf3=new TextField("입력창3 입니다.");
    }

    private void startFrame(){
        frame.setLayout(new GridLayout(0,5));
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(tf1);
        frame.add(tf2);
        frame.add(tf3);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        GridTest g=new GridTest();
        g.startFrame();
    }
}
