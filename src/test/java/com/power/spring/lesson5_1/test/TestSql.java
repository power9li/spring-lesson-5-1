package com.power.spring.lesson5_1.test;

import com.power.lesson5.config.BaseConfig;
import com.power.spring.lesson5_1.bean.HelloWorldBean3;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by shenli on 2017/1/21.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BaseConfig.class)
@ActiveProfiles(value = "profile_mock")
public class TestSql {

    @Autowired
    HelloWorldBean3 helloWorldBean3;

    @Test
    @Sql("classpath:test/test.sql")
    public void test(){
        System.out.println("helloWorldBean3 = " + helloWorldBean3);
        System.out.println("TestSql.test");
        helloWorldBean3.hello();
    }

}
