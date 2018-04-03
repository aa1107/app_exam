package ch16;

import javax.swing.*;

public class Dialog1 extends JDialog {
    ImageIcon icon1;

    JLabel jlb=new JLabel("");
    public Dialog1(String str){
        getContentPane().add(jlb);
        icon1=new ImageIcon("london.jpg");
        jlb.setIcon(icon1);
        setTitle(str);
        setBounds(200,200,400,400);
        setModal(true);
        setVisible(true);
    }
}
