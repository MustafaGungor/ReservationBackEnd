package com.mustafa.samples.reservation.web.controller.report;

import org.springframework.stereotype.Service;

import javax.swing.table.AbstractTableModel;

/**
 * Created by SECKİN on 22.05.2017.
 */
@Service
public class SpringDemoData extends AbstractTableModel {

    private static String[] COLUMN_NAMES ;

    private static String[][] DATA;

    public SpringDemoData(String[] COLUMN_NAMES,String[][] DATA) {
        super();
        SpringDemoData.COLUMN_NAMES = COLUMN_NAMES;
        SpringDemoData.DATA = DATA;
    }

    public SpringDemoData(){

    }


    public static String[] getColumnNames() {
        return COLUMN_NAMES;
    }

    public static void setColumnNames(String[] columnNames) {
        COLUMN_NAMES = columnNames;
    }

    public static String[][] getDATA() {
        return DATA;
    }

    public static void setDATA(String[][] DATA) {
        SpringDemoData.DATA = DATA;
    }

    public int getRowCount() {
        return DATA.length;
    }

    public int getColumnCount() {
        return DATA[0].length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex >= 0 && rowIndex < DATA.length) {
            if (columnIndex >= 0 && columnIndex < DATA[rowIndex].length) {
                return DATA[rowIndex][columnIndex];
            }
        }
        return null;
    }

    public String getColumnName(final int column) {
        if (column >= 0 && column < COLUMN_NAMES.length) {
            return COLUMN_NAMES[column];
        }
        return null;
    }
}
