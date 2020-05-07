package com.teachedapp;

import com.teachedapp.respository.CourseRepository;
import com.teachedapp.respository.SubjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TeachedappApplicationTests {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void contextLoads() {
        assertThat(subjectRepository).isNotNull();
        assertThat(courseRepository).isNotNull();
    }

}
