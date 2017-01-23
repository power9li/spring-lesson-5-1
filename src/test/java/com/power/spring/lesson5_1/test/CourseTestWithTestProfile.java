package com.power.spring.lesson5_1.test;

import com.power.lesson5.components.MyCoursesService;
import com.power.lesson5.config.BaseConfig;
import com.power.lesson5.domain.Course;
import com.power.lesson5.utils.Printer;
import com.power.spring.lesson5_1.listeners.MockCourseExecutionListener;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by shenli on 2017/1/21.
 */
@RunWith(SpringRunner.class)
@ComponentScan(basePackages = "com.power.lesson5")
@ContextConfiguration(classes = BaseConfig.class)
@ActiveProfiles(value = "profile_test")
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@TestExecutionListeners(listeners = MockCourseExecutionListener.class,mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS)
public class CourseTestWithTestProfile {

    @Autowired
    private MyCoursesService myCoursesService;


    @Test
    public void test_02_GetAllCourse(){
        List<Course> allCourse = myCoursesService.getAllCourse();
        Printer.print("allCourse = " + allCourse);
    }

    @Test
    public void test_01_addCourse(){
        Course course = new Course();
        course.setName("语文");
        course.setMark("80");
        course.setId(1L);
        boolean b = myCoursesService.addCourse(course);
        System.out.println("b = " + b);
    }

    @Test
    public void test_03_getById(){
        Course course = myCoursesService.getById(1L);
        Printer.print(course);
    }

    @Test
    public void test_04_update(){
        Course course = new Course();
        course.setId(2L);
        course.setName("英语");
        course.setMark("85");
        boolean b = myCoursesService.updateCourse(course);
        Printer.print("b = " + b);
    }

}
