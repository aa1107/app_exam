import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonTextHandler implements ActionListener{
       JTextArea textArea;

       public ButtonTextHandler(JTextArea textArea) {
           this.textArea = textArea;
       }

       @Override
       public void actionPerformed(ActionEvent e) {
           textArea.setText("모든 내용을 지웠습니다. \n");
           textArea.append("원하는 내용을 입력하세요. \n");
       }
}
