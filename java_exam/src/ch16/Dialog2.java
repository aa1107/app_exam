package ch16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dialog2 extends JDialog {
    JTextField tf=new JTextField(10);
    JButton okButton=new JButton("OK");

    public Dialog2(JFrame frame,JLabel label, String title){
        super(frame,title);
        setLayout(new FlowLayout());
        add(tf);
        add(okButton);
        setSize(200,100);
        setVisible(true);
        setModal(true);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text=tf.getText();
                label.setText(text);
                dispose();
            }
        });
    }
}
