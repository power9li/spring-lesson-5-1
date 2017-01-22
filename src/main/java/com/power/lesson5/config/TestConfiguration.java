package com.power.lesson5.config;

import com.power.lesson5.utils.Printer;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.DoesNothing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Created by shenli on 2017/1/21.
 */
@Configuration
@Profile("profile_test")
@Component
public class TestConfiguration {

    @Bean
    public DataSource dataSource(){
        DataSource mockDatasource = Mockito.mock(DataSource.class);
        Connection conn = Mockito.mock(Connection.class);
        Statement stmt = Mockito.mock(Statement.class);
        ResultSet rstst = Mockito.mock(ResultSet.class);

        try {
            Mockito.when(mockDatasource.getConnection()).then(t->{Printer.print("mockDS: getConn "); return conn;});
            Mockito.doAnswer(t->{Printer.print("mockConn: set auto false  ");return new DoesNothing();}).when(conn).setAutoCommit(false);
            Mockito.doAnswer(t->{Printer.print("mockConn: set auto true  ");return new DoesNothing();}).when(conn).setAutoCommit(true);
            Mockito.doAnswer(t->{Printer.print("mockConn: commit  ");return new DoesNothing();}).when(conn).commit();
            Mockito.doAnswer(t->{Printer.print("mockConn: rollback   ");return new DoesNothing();}).when(conn).rollback();
            Mockito.doAnswer(t->{Printer.print("mockConn: close conn  ");return new DoesNothing();}).when(conn).close();
            Mockito.when(conn.createStatement()).thenReturn(stmt);

            Mockito.when(stmt.executeQuery(Mockito.anyString())).then(t->{
                Printer.print("stmt.executeQuery");
                return rstst;
            });
            Mockito.when(rstst.next()).thenReturn(true).thenReturn(true).thenReturn(false);
            Mockito.when(rstst.getLong("id")).thenReturn(1L).thenReturn(2L);
            Mockito.when(rstst.getString("name")).thenReturn("地理").thenReturn("政治");
            Mockito.when(rstst.getString("mark")).thenReturn("90").thenReturn("82");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mockDatasource;
    }

}
