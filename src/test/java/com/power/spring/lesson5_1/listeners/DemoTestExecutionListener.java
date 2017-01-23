package com.power.spring.lesson5_1.listeners;

import com.power.lesson5.utils.Printer;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

/**
 * Created by shenli on 2017/1/22.
 */
public class DemoTestExecutionListener implements TestExecutionListener {

    @Override
    public void beforeTestClass(TestContext testContext) throws Exception {
        Printer.print("DemoTestExecutionListener.beforeTestClass");
    }

    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {
        Printer.print("DemoTestExecutionListener.prepareTestInstance");
    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        Printer.print("DemoTestExecutionListener.beforeTestMethod");
        System.out.println("==============[[[ "+testContext.getTestMethod().getName()+" ]]]===============");
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        Printer.print("DemoTestExecutionListener.afterTestMethod");
        System.out.println("==========================================");
    }

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {
        Printer.print("DemoTestExecutionListener.afterTestClass");
    }
}
