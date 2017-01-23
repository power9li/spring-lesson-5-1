package com.power.spring.lesson5_1.listeners;

import com.power.lesson5.utils.Printer;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.DoesNothing;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

import javax.sql.DataSource;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by shenli on 2017/1/23.
 */
public class MockExecutionListener implements TestExecutionListener {


    private Statement stmt = null;

    @Override
    public void beforeTestClass(TestContext testContext) throws Exception {
        Connection conn = Mockito.mock(Connection.class);
        stmt = Mockito.mock(Statement.class);
        DataSource ds = testContext.getApplicationContext().getBean(DataSource.class);
        Mockito.when(ds.getConnection()).then(t->{Printer.print("mockDS: getConn "); return conn;});
        Mockito.doAnswer(t->{Printer.print("mockConn: set auto false  ");return new DoesNothing();}).when(conn).setAutoCommit(false);
        Mockito.doAnswer(t->{Printer.print("mockConn: set auto true  ");return new DoesNothing();}).when(conn).setAutoCommit(true);
        Mockito.doAnswer(t->{Printer.print("mockConn: commit  ");return new DoesNothing();}).when(conn).commit();
        Mockito.doAnswer(t->{Printer.print("mockConn: rollback   ");return new DoesNothing();}).when(conn).rollback();
        Mockito.doAnswer(t->{Printer.print("mockConn: close conn  ");return new DoesNothing();}).when(conn).close();
        Mockito.when(conn.createStatement()).then(t->{
            Printer.print("createStatement");
            return stmt;
        });
    }

    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {

    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        Method testMethod = testContext.getTestMethod();
        ApplicationContext applicationContext = testContext.getApplicationContext();
        String name = testMethod.getName();
        Printer.print("\n =============[[[ " + name + "]]]============");
        if (name.equals("test_01_addCourse")) {

        } else if (name.equals("test_03_getById")) {
            Mockito.doAnswer(rt->{
                Printer.print("return ResultSet.");
                ResultSet resultSet = Mockito.mock(ResultSet.class);
                Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
                Mockito.when(resultSet.getLong("id")).thenReturn(1L);
                Mockito.when(resultSet.getString("name")).thenReturn("书法");
                Mockito.when(resultSet.getString("mark")).thenReturn("100");
                return resultSet;
            }).when(stmt).executeQuery(Mockito.anyString());

        } else if (name.equals("test_02_GetAllCourse")) {
            Mockito.doAnswer(rt->{
                Printer.print("return ResultSet.");
                ResultSet rstst = Mockito.mock(ResultSet.class);
                Mockito.when(rstst.next()).thenReturn(true).thenReturn(true).thenReturn(false);
                Mockito.when(rstst.getLong("id")).thenReturn(1L).thenReturn(2L);
                Mockito.when(rstst.getString("name")).thenReturn("地理").thenReturn("政治");
                Mockito.when(rstst.getString("mark")).thenReturn("90").thenReturn("82");
                return rstst;
            }).when(stmt).executeQuery(Mockito.anyString());
        }
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        Printer.print("MockExecutionListener.afterTestMethod");
//        Mockito.reset(Statement.class);
    }

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {

    }
}
