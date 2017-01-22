package com.power.lesson5.components;

import com.power.lesson5.domain.Course;

import java.util.List;

/**
 * Created by shenli on 2017/1/21.
 */
public interface MyCoursesService {

    List<Course> getAllCourse();

    boolean addCourse(Course course);

    boolean updateCourse(Course course);

    boolean deleteCourse(Long id);

    Course getById(Long id);
}
