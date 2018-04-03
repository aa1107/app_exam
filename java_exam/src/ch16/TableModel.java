package ch16;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
    String[] columnNames={"사번","이름","근무부서"};
    Object[][] data=null;

    boolean[] columnEditables=new boolean[]{
            false,true,true
    };

    public TableModel(Object[][] data){
        this.data=data;
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    public String getColumnName(int arg0){
        return columnNames[arg0];
    }

    public boolean isCellEditable(int row, int column){
        return columnEditables[column];
    }

    public void setValueAt(Object value,int row, int col){
        data[row][col]=value;
        fireTableCellUpdated(row,col);
    }
}
