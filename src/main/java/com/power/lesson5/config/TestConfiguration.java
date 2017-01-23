package com.power.lesson5.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;


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
        return mockDatasource;
    }

}


