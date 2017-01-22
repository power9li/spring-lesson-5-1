package com.power.spring.lesson5_1.test;

import com.power.lesson5.components.MyCoursesService;
import com.power.lesson5.config.BaseConfig;
import com.power.lesson5.domain.Course;
import com.power.lesson5.utils.Printer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by shenli on 2017/1/21.
 */
@RunWith(SpringRunner.class)
@ComponentScan(basePackages = "com.power.lesson5")
@ContextConfiguration(classes = BaseConfig.class)
@ActiveProfiles(value = "profile_test")
public class CourseTestWithTestProfile {

    @Autowired
    private MyCoursesService myCoursesService;


    @Test
    public void test_02_GetAllCourse(){
        List<Course> allCourse = myCoursesService.getAllCourse();
        Printer.print("allCourse = " + allCourse);
    }




}
