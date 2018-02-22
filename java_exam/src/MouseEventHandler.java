import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventHandler implements MouseListener {
    public void mouseClicked(MouseEvent me)
    {
        JButton button = (JButton) me.getComponent();
        button.setText("Clicked");
        System.out.println("Clicked Button" + me.getButton());
        System.out.println("마우스 버튼 눌렸다 풀림");
    }

    //마우스 커서가 버튼 위에 올라가면 호출됩니다.
    public void mouseEntered(MouseEvent we)
    {
        System.out.println("커서 버튼 위 진입");
    }

    // 마우스 커서가 버튼을 빠져나가면 호출됩니다.
    public void mouseExited(MouseEvent we)
    {
        System.out.println("커서 버튼 위 탈출");
    }

    //마우스 버튼이 눌리는 순간 호출됩니다.
    public void mousePressed(MouseEvent we)
    {
        System.out.println("마우스 버튼 눌림");
    }

    //마우스 버튼이 풀리는 순간 호출됩니다.
    public void mouseReleased(MouseEvent e)
    {
        System.out.println("마우스 버튼 풀림");
    }
}
