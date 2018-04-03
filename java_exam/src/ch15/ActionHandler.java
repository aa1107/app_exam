package ch15;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("btn1")) System.out.println("버튼1 클릭");
        if(e.getActionCommand().equals("btn2")) System.out.println("버튼2 클릭");
        if(e.getActionCommand().equals("btn3")) System.out.println("버튼3 클릭");
        if(e.getActionCommand().equals("btn4")) System.out.println("버튼4 클릭");
        if(e.getActionCommand().equals("btn5")) System.out.println("버튼5 클릭");
    }
}
