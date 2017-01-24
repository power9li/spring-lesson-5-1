package com.power.lesson5.components;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Closeable;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.concurrent.Callable;

/**
 * Created by shenli on 2017/1/24.
 */
@Component
public class TestBean implements Runnable, Callable<String>,Closeable,InitializingBean,PostConstruct {
    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    @Override
    public String call() throws Exception {
        return null;
    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void run() {

    }
}
