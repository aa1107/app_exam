package ch15;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FlowTest2 implements WindowListener{
    private Frame frame;
    private Button button1,button2,button3;

    public FlowTest2(){
        frame=new Frame("Adapter 사용 전 예제");
        button1=new Button("Ok");
        button2=new Button("Open");
        button3=new Button("Close");
    }

    public void startFrame(){
        frame.addWindowListener(this);

        frame.setLayout(new FlowLayout());
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.setSize(100,100);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        FlowTest2 flow=new FlowTest2();
        flow.startFrame();
    }

    @Override
    public void windowOpened(WindowEvent e) {


    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
