package com.power.spring.lesson5_1.test;

import com.power.lesson5.utils.Printer;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

/**
 * Created by shenli on 2017/1/21.
 */
public class MyTestListener implements TestExecutionListener {

    @Override
    public void beforeTestClass(TestContext testContext) throws Exception {
        Printer.print("MyTestListener.beforeTestClass");
    }

    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {
        Printer.print("MyTestListener.prepareTestInstance");
        Class<?> testClass = testContext.getTestClass();
        Printer.print("testClass = " + testClass);
        Object testInstance = testContext.getTestInstance();
        Printer.print("testInstance = " + testInstance+"\n");
    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        Printer.print("MyTestListener.beforeTestMethod");
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        Printer.print("MyTestListener.afterTestMethod");
    }

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {
        Printer.print("MyTestListener.afterTestClass");
    }

}
