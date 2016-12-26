package it.polito.yutengfei.RIIF2.initializer;


import it.polito.yutengfei.RIIF2.util.utilityWrapper.Row;

import java.util.LinkedList;

public class TableInitializer implements Initializer {
    private LinkedList<Row> tableInitializer = new LinkedList<>();

    public void addRow(Row row ){
        this.tableInitializer.add( row );
    }

}
