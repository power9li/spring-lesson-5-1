package com.power.lesson5.components;

import com.power.lesson5.domain.Course;
import com.power.lesson5.trans.CourseRowMapper;
import com.power.lesson5.utils.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by shenli on 2017/1/21.
 */
@Component
public class MyCoursesServiceImpl implements MyCoursesService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Course> getAllCourse() {
        Printer.print("MyCoursesServiceImpl.getAllCourse");
        List<Course> courseList = jdbcTemplate.query("select id, name, mark from course", new CourseRowMapper());
        return courseList;
    }

    @Override
    public boolean addCourse(Course course) {
        Printer.print("MyCoursesServiceImpl.addCourse");
        jdbcTemplate.execute("insert into course (name,mark) values(" + course.getName() + "," + course.getMark() + ")");
        return true;
    }

    @Override
    public boolean updateCourse(Course course) {
        if (course.getId() == null) {
            return false;
        }
        int update = jdbcTemplate.update("update course set name = '" + course.getName() + "' , mark = '" + course.getMark() + "' where id = " + course.getId());
        return update > 0;
    }

    @Override
    public boolean deleteCourse(Long id) {
        int deleted = jdbcTemplate.update("delete from course where id =" + id);
        return deleted > 0;
    }

    @Override
    public Course getById(Long id) {
        Course course = jdbcTemplate.queryForObject("select * from course where id = " + id, new CourseRowMapper());
        return course;
    }

}
