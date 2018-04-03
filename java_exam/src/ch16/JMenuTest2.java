package ch16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JMenuTest2 extends JFrame {
    JFrame f;
    JMenuBar menuBar;
    JMenu carMenu, memberMunu, rentMenu, helpMenu;
    JMenuItem carMenu11,carMenu12,carMenu13,carMenu14;
    JMenuItem memMenu21,memMenu22,memMenu23,memMenu24;
    JMenuItem helpMenu41;
    JPanel jPanel;
    JLabel lCarName;
    JTextField tf;
    JButton searchBtn;

    public JMenuTest2(){
        f=new JFrame("렌터카 예약 시스템");
        menuBar = new JMenuBar();
        carMenu = new JMenu("차량 관리");
        memberMunu = new JMenu("회원관리");
        rentMenu = new JMenu("예약관리");
        helpMenu = new JMenu("도움말");
    }
    protected void startFrame(){
        f.setJMenuBar(menuBar);
        menuBar.add(carMenu);

        carMenu.add(carMenu11=new JMenuItem("차량등록"));
        carMenu.add(carMenu12=new JMenuItem("차량조회"));
        carMenu.addSeparator();
        carMenu.add(carMenu13=new JMenuItem("차량수정"));
        carMenu.add(carMenu14=new JMenuItem("차량삭제"));

        menuBar.add(memberMunu);
        memberMunu.add(memMenu21=new JMenuItem("회원등록"));
        memberMunu.add(memMenu22=new JMenuItem("회원조회"));
        memberMunu.addSeparator();
        memberMunu.add(memMenu23=new JMenuItem("회원수정"));
        memberMunu.add(memMenu24=new JMenuItem("회원삭제"));

        menuBar.add(helpMenu);
        helpMenu.add(helpMenu41=new JMenuItem("버전"));

        jPanel = new JPanel();
        lCarName=new JLabel("차량명");
        tf=new JTextField(10);
        searchBtn=new JButton("차량 조회하기");

        jPanel.add(lCarName);
        jPanel.add(tf);
        jPanel.add(searchBtn);

        Container con=f.getContentPane();
        con.add(jPanel,"North");

        f.setLocation(200,100);
        f.setSize(800,600);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);

        carMenu11.addActionListener(new CarHandler());
        carMenu12.addActionListener(new CarHandler());
        carMenu13.addActionListener(new CarHandler());
        carMenu14.addActionListener(new CarHandler());

        memMenu21.addActionListener(new MemberHandler());
        memMenu22.addActionListener(new MemberHandler());
        memMenu23.addActionListener(new MemberHandler());
        memMenu24.addActionListener(new MemberHandler());

        helpMenu41.addActionListener(new HelpHandler());
    }

    private class CarHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
            if(e.getSource()==carMenu11){
                new RegCarDialog("차량등록 창");
            }else if(e.getSource()==carMenu12){
                openFile();
            }else if(e.getSource()==carMenu13){
                try{
                    saveFile();
                }catch (IOException ex){
                    ex.printStackTrace();
                }
                System.out.println("test.txt 파일을 저장했습니다.");
            }
        }
    }

    private void openFile(){
        String msg=null;
        FileDialog d=new FileDialog(f,"파일을 선택하세요",FileDialog.LOAD);
        d.setSize(200,200);
        d.setVisible(true);
        msg=d.getDirectory()+" "+d.getFile()+" 을 선택";
        System.out.println(msg);
    }

    public void saveFile() throws IOException{
        String msg=null;
        FileDialog d=new FileDialog(f,"파일 저장",FileDialog.SAVE);
        d.setSize(200,200);
        d.setVisible(true);

        msg=d.getDirectory()+" "+d.getFile()+" 을 선택했군요.";
        String path=d.getDirectory();
        String fileName=d.getFile();
        System.out.println(msg);
        File file= new File(path,fileName);

        FileWriter writer=new FileWriter(file,true);
        writer.write("파일에 메시지를 저장합니다.");
        writer.close();
    }

    private class MemberHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class HelpHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            version();
        }
    }

    private void version(){
        final JDialog d=new JDialog(this, "버전관리");
        JLabel jbver=new JLabel("버전1.0");
        JLabel jbdate=new JLabel("2015.03.11");
        JLabel jbauthor=new JLabel("제작:idea java");

        d.setLayout(new FlowLayout());
        d.add(jbver);
        d.add(jbdate);
        d.add(jbauthor);

        d.setBounds(250,230,200,100);
        d.setVisible(true);

        d.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                d.dispose();
                d.setVisible(false);
            }
        });
    }

    public static void main(String[] args){
        JMenuTest2 test=new JMenuTest2();
        test.startFrame();
    }
}
