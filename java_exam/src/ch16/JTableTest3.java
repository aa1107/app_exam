package ch16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTableTest3 extends JFrame {
    JPanel searchPanel;
    JPanel btnPanel;

    JList memberJList;
    JLabel lCondition;
    JTextField tCondition;
    JButton searchBtn;
    JComboBox combo;
    JTable memTable;

    JButton updateBtn, deleteBtn;
    Object[][] arrMember = new Object[0][4];

    public JTableTest3(){
        initInstance();
        setTitle("테이블 실습");
        setLayout(new BorderLayout());
        Container c= getContentPane();
        c.add(searchPanel,"North");
        c.add(new JScrollPane(memTable),"Center");
        c.add(btnPanel,"South");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200,200);
        pack();
        setVisible(true);
    }

    private void initInstance(){
        searchPanel=new JPanel();

        tCondition=new JTextField(10);
        lCondition=new JLabel("입력창");

        memberJList=new JList();
        memberJList.setBackground(Color.green);
        memTable=new JTable();
        memTable.setModel(new TableModel(arrMember));

        searchBtn=new JButton("조회하기");
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arrMember=new Object[6][3];
                arrMember[0][0]="150000";
                arrMember[0][1]="홍길동";
                arrMember[0][2]="관리부";
                arrMember[1][0]="150001";
                arrMember[1][1]="이순신";
                arrMember[1][2]="회계부";
                arrMember[2][0]="150002";
                arrMember[2][1]="박지성";
                arrMember[2][2]="개발부";
                arrMember[3][0]="150003";
                arrMember[3][1]="차범근";
                arrMember[3][2]="개발부";
                arrMember[4][0]="150004";
                arrMember[4][1]="차두리";
                arrMember[4][2]="총무부";
                arrMember[5][0]="150005";
                arrMember[5][1]="히딩크";
                arrMember[5][2]="영업부";

                memTable.setModel(new TableModel(arrMember));
            }
        });

        searchPanel.add(lCondition);
        searchPanel.add(tCondition);
        searchPanel.add(searchBtn);

        btnPanel=new JPanel();
        updateBtn=new JButton("수정하기");
        deleteBtn=new JButton("삭제하기");
        btnPanel.add(updateBtn);
        btnPanel.add(deleteBtn);
    }
    public static void main(String[] args){
        new JTableTest3();
    }
}
