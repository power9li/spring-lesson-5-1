package com.power.lesson5.trans;

import com.power.lesson5.utils.Printer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionStatus;

import javax.sql.DataSource;

/**
 * Created by shenli on 2017/1/21.
 */
public class MyTraceTransactionManager extends DataSourceTransactionManager {

    @Override
    public DataSource getDataSource() {
        Printer.print("MyTraceTransactionManager.getDataSource\n");
        return super.getDataSource();
    }

    @Override
    protected Object doGetTransaction() {
        Printer.print("MyTraceTransactionManager.doGetTransaction");
        return super.doGetTransaction();
    }

    @Override
    protected boolean isExistingTransaction(Object transaction) {
        Printer.print("MyTraceTransactionManager.isExistingTransaction");
        return super.isExistingTransaction(transaction);
    }

    @Override
    protected void doBegin(Object transaction, TransactionDefinition definition) {
        System.out.println("MyTraceTransactionManager.doBegin");
        super.doBegin(transaction, definition);
    }

    @Override
    protected void doCommit(DefaultTransactionStatus status) {
        Printer.print("MyTraceTransactionManager.doCommit");
        super.doCommit(status);
    }

    @Override
    protected void doRollback(DefaultTransactionStatus status) {
        Printer.print("MyTraceTransactionManager.doRollback");
        super.doRollback(status);
    }

    @Override
    protected void doSetRollbackOnly(DefaultTransactionStatus status) {
        Printer.print("MyTraceTransactionManager.doSetRollbackOnly");
        super.doSetRollbackOnly(status);
    }


}
