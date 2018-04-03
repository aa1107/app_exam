package ch16;

import javax.swing.*;

public class JTableTest1 extends JFrame {
    JTable table;

    String[][] data={{"150000","홍길동","총무부"},{"150000","홍길동","총무부"},{"150000","홍길동","총무부"},
            {"150000","홍길동","총무부"},{"150000","홍길동","총무부"},{"150000","홍길동","총무부"},
            {"150000","홍길동","총무부"},{"150000","홍길동","총무부"},{"150000","홍길동","총무부"},
            {"150000","홍길동","총무부"},{"150000","홍길동","총무부"},{"150000","홍길동","총무부"},
            {"150000","홍길동","총무부"},{"150000","홍길동","총무부"}};

    String[] columnNames={"사번","이름","근무부서"};
    public JTableTest1(){
        table=new JTable(data,columnNames);
        table.setAutoResizeMode(table.AUTO_RESIZE_ALL_COLUMNS);
    }

    public void startFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle("사원 정보 테이블");

        add(new JScrollPane(table));
        pack();
        setVisible(true);
    }

    public static void main(String[] args){
        JTableTest1 t=new JTableTest1();
        t.startFrame();
    }
}
