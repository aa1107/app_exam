package ch16;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JTableTest2 extends JFrame {
    JTable table;

    String[][] data={{"1500001","홍길동1","총무부1"},{"1500002","홍길동2","총무부2"},{"1500003","홍길동3","총무부3"},
            {"1500004","홍길동4","총무부4"},{"1500005","홍길동5","총무부5"},{"1500006","홍길동6","총무부6"},
            {"1500007","홍길동7","총무부7"},{"1500008","홍길동8","총무부8"},{"1500009","홍길동9","총무부9"},
            {"15000010","홍길동10","총무부10"},{"15000011","홍길동11","총무부11"},{"15000012","홍길동12","총무부12"},
            {"15000013","홍길동13","총무부13"},{"15000014","홍길동14","총무부14"}};

    String[] columnNames={"사번","이름","근무부서"};

    int rowIdx=0,colIdx=0;

    public JTableTest2(){
        table=new JTable(data,columnNames);

        ListSelectionModel rowSel=table.getSelectionModel();

        rowSel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        rowSel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    ListSelectionModel lsm=(ListSelectionModel)e.getSource();
                    rowIdx=lsm.getMinSelectionIndex();
                    System.out.println(lsm.getMinSelectionIndex()+" 번째 행이 선택됨...");
                    System.out.println(data[rowIdx][colIdx]);
                }
            }
        });

        table.setAutoResizeMode(table.AUTO_RESIZE_ALL_COLUMNS);

        ListSelectionModel colSel=table.getColumnModel().getSelectionModel();
        colSel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        colSel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel lsm=(ListSelectionModel)e.getSource();
                colIdx=lsm.getMinSelectionIndex();
                if(!e.getValueIsAdjusting()){
                    System.out.println(lsm.getMinSelectionIndex()+" 번째 열이 선택됨...");

                    System.out.println(data[rowIdx][colIdx]);
                }
            }
        });
    }

    public void startFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle("테이블 테스트");
        add(new JScrollPane(table));
        pack();
        setVisible(true);
    }

    public static void main(String[] args){
        JTableTest2 t=new JTableTest2();
        t.startFrame();
    }
}
