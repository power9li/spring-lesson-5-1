package com.power.lesson5.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;


/**
 * Created by shenli on 2017/1/21.
 */
@Configuration
@Component
@PropertySource("classpath:test.properties")
@Profile("profile_prod")
public class ProdConfiguration {

    @Value(value = "${conn.url}")
    private String connectionUrl;

    @Value(value = "${conn.username}")
    private String username;

    @Value(value = "${conn.password}")
    private String password;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource(connectionUrl,username,password);
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }



}
