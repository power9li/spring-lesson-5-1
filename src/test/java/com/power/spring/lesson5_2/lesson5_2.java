package com.power.spring.lesson5_2;

import com.power.lesson5.config.BaseConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by shenli on 2017/1/23.
 */
public class lesson5_2 {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.default","profile_prod");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.power.lesson5");
        ctx.register(BaseConfig.class);

    }
}
