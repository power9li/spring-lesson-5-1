package com.power.spring.lesson5_1.test;

import com.power.lesson5.components.MyCoursesService;
import com.power.lesson5.config.BaseConfig;
import com.power.lesson5.domain.Course;
import com.power.lesson5.utils.Printer;
import com.power.spring.lesson5_1.listeners.CourseTestExecutionListener;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by shenli on 2017/1/21.
 */
@RunWith(SpringRunner.class)
@ComponentScan(basePackages = "com.power.lesson5")
@ContextConfiguration(classes = BaseConfig.class)
@ActiveProfiles("profile_prod")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners(listeners = CourseTestExecutionListener.class,
        mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS)
@Transactional
public class CourseTestWithProdProfile {

    @Autowired
    private MyCoursesService myCoursesService;

    @Test
    @Sql("classpath:test/add_course.sql")
    public void test_001_addCourse(){
        Printer.print("CourseTestWithTestProfile.test_001_addCourse");
        List<Course> allCourse = myCoursesService.getAllCourse();
        Printer.print("allCourse = " + allCourse);
        Assert.assertEquals(allCourse.size(), 2);
    }

    @Test
    @Sql("classpath:test/getall_course.sql")
    public void test_002_GetAllCourse(){
        List<Course> allCourse = myCoursesService.getAllCourse();
        Printer.print("allCourse = " + allCourse);
    }

    @Test
    @Sql("classpath:test/update_course.sql")
    public void test_003_updateCourse(){
        Course course = new Course();
        course.setId(1L);
        course.setName("天文");
        course.setMark("100");
        boolean updated = myCoursesService.updateCourse(course);
        Assert.assertTrue(updated);
    }

    @Test
    @Sql("classpath:test/delete_course.sql")
    public void test_004_deleteCourse(){
        Course zhengzhi = myCoursesService.getById(1L);
        System.out.println("zhengzhi = " + zhengzhi);
        myCoursesService.deleteCourse(1L);
        List<Course> allCourse = myCoursesService.getAllCourse();
        System.out.println("allCourse.size() = " + allCourse.size());
    }

}
