package com.power.spring.lesson5_1.test;

import com.power.lesson5.config.ProdConfiguration;
import com.power.lesson5.utils.Printer;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by shenli on 2017/1/21.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ProdConfiguration.class)
@TestExecutionListeners(listeners = MyTestListener.class,
        mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS)
public class ListenerTest {

    @BeforeClass
    public static void init(){
        Printer.print("ListenerTest.init");
    }

    @Before
    public void before(){
        Printer.print("ListenerTest.before");
    }

    @Test
    public void test(){
        Printer.print("ListenerTest.test");
    }

    @After
    public void after(){
        Printer.print("ListenerTest.after");
    }

    @AfterClass
    public static void destroy(){
        Printer.print("ListenerTest.destroy");
    }

}
