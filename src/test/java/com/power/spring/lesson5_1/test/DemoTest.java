package com.power.spring.lesson5_1.test;

import org.junit.*;
import org.junit.runners.MethodSorters;

/**
 * Created by shenli on 2017/1/21.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DemoTest {

    @BeforeClass
    public static void init(){
        System.out.println(System.currentTimeMillis()+" DemoTest.init\n");
    }

    @Before
    public void before(){
        System.out.println(System.currentTimeMillis()+" DemoTest.before");
    }

    @Test
    public void test3(){
        System.out.println(System.currentTimeMillis()+" DemoTest.test3");
    }

    @Test
    public void test1(){
        System.out.println(System.currentTimeMillis()+" DemoTest.test1");
    }

    @Test
    public void test2(){
        System.out.println(System.currentTimeMillis()+" DemoTest.test2");
    }

    @After
    public void after(){
        System.out.println(System.currentTimeMillis()+" DemoTest.after\n");
    }

    @AfterClass
    public static void destroy(){
        System.out.println(System.currentTimeMillis()+" DemoTest.destroy\n");
    }
}
