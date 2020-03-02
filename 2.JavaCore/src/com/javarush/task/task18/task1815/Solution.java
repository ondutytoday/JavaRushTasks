package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface{
        String headerText;
        List rows;
        TableInterface anInterface;

        public TableInterfaceWrapper(TableInterface anInterface) {
            this.anInterface = anInterface;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            this.anInterface.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            String s = this.anInterface.getHeaderText().toUpperCase();

            return s;
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            this.anInterface.setHeaderText(newHeaderText);
        }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}