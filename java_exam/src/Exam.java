import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Exam{
    public static void main(String[] args)
    {
       // jframe 객체 생성
        JFrame frame = new JFrame("title");
        //frame 크기 설정
        // (x좌표, y좌표, 가로, 세로)
        frame.setBounds(120, 120, 800, 500);
        // 프레임 안에 배치될 버튼들의 배치 방식 설정
        frame.setLayout(new FlowLayout());
        WindowListener listener = new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
            public void windowOpened(WindowEvent we) {
                System.out.println("프로그램이 수행 되었습니다.");
            }
        };
        frame.addWindowListener(listener);

        // 버튼 객체를 생성
        JButton btn1 = new JButton("My Button");
        MouseListener listener1 = new MouseEventHandler();
        btn1.addMouseListener(listener1);
        JButton btn2 = new JButton("Your Button");
        btn2.addMouseListener(listener1);
        JButton btn3 = new JButton("Our Button");
        btn3.addMouseListener(listener1);

        // 버튼을 프레임 안에 추가
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);

        // 프레임을 화면에 보여줌
        frame.setVisible(true);
    }
}