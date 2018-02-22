import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Exam0220{
    public static void main(String[] args)
    {
        // jframe 객체 생성
        JFrame frame = new JFrame("title");
        //frame 크기 설정
        // (x좌표, y좌표, 가로, 세로)
        frame.setBounds(120, 120, 250, 270);
        // 프레임 안에 배치될 버튼들의 배치 방식 설정
        frame.setLayout(new FlowLayout());

        JCheckBox cb1 = new JCheckBox("수박");
        JCheckBox cb2 = new JCheckBox("딸기");
        JCheckBox cb3 = new JCheckBox("사과");

        CheckBoxHandler cbHandler1 = new CheckBoxHandler(cb1);
        CheckBoxHandler cbHandler2 = new CheckBoxHandler(cb2);
        CheckBoxHandler cbHandler3 = new CheckBoxHandler(cb3);
        cb1.addItemListener(cbHandler1);
        cb2.addItemListener(cbHandler2);
        cb3.addItemListener(cbHandler3);

        /*ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(cb1);
        buttonGroup.add(cb2);
        buttonGroup.add(cb3);*/

        frame.add(cb1);
        frame.add(cb2);
        frame.add(cb3);

        JRadioButton rb1 = new JRadioButton("미국");
        JRadioButton rb2 = new JRadioButton("한국");
        JRadioButton rb3 = new JRadioButton("중국");

        RadioHandler radioHandler1 = new RadioHandler(rb1);
        RadioHandler radioHandler2 = new RadioHandler(rb2);
        RadioHandler radioHandler3 = new RadioHandler(rb3);
        rb1.addItemListener(radioHandler1);
        rb2.addItemListener(radioHandler2);
        rb3.addItemListener(radioHandler3);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);

        frame.add(rb1);
        frame.add(rb2);
        frame.add(rb3);

        /*JTextArea textArea = new JTextArea(10,20);
        textArea.setText("");
        // 커서의 위치설정
        textArea.setCaretPosition(textArea.getText().length());
        // 자동개행 활성화
        textArea.setLineWrap(true);
        // 단어 자동 개행 활성화
        textArea.setWrapStyleWord(true);

        JButton btn = new JButton("Clear");

        ButtonTextHandler btHandler = new ButtonTextHandler(textArea);
        btn.addActionListener(btHandler);

        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane);
        //frame.add(textArea);
        frame.add(btn);*/

        /*JLabel label1 = new JLabel("ID");
        JLabel label2 = new JLabel("Password");
        JLabel label3 = new JLabel("Email");
        JTextField textField1 = new JTextField();
        JPasswordField textField2 = new JPasswordField();
        JTextField textField3 = new JTextField();

        PWHandler pwHandler = new PWHandler(textField1, textField2);
        textField1.addActionListener(pwHandler);
        textField2.addActionListener(pwHandler);

        frame.add(label1);
        frame.add(textField1);
        frame.add(label2);
        frame.add(textField2);
        frame.add(label3);
        frame.add(textField3);*/

        // 프레임을 화면에 보여줌
        frame.setVisible(true);
    }
}