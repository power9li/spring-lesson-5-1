package com.power.lesson5.config;

import com.power.lesson5.trans.MyTraceTransactionManager;
import com.power.lesson5.utils.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by shenli on 2017/1/21.
 */
@Configuration
@ComponentScan(basePackages = "com.power.lesson5")
public class BaseConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager()
    {
        Printer.print("get PlatformTransactionManager ");
        MyTraceTransactionManager transMan=new MyTraceTransactionManager();
        transMan.setDataSource(dataSource);
        return transMan;
    }
}
