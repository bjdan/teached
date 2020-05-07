package com.teachedapp.repository;

import com.teachedapp.dao.Course;
import com.teachedapp.respository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepositoryTests {

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void testCreateReadDelete() {
        Course course = new Course();
        course.setId(0);

        courseRepository.save(course);

        Optional<Course> foundCourse = courseRepository.findById(0);
        assertThat(foundCourse.isPresent());
        foundCourse.ifPresent(value -> assertThat(value).isEqualTo(course));

        courseRepository.delete(course);
        assertThat(courseRepository.findById(0).isPresent()).isFalse();
    }
}
