package com.teachedapp.respository;

import com.teachedapp.dao.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    @PostAuthorize("returnObject.get().teacher.account.login == authentication.name " +
            "|| returnObject.get().student.account.login == authentication.name" +
            "|| hasRole('ROLE_ADMIN')")
    @Override
    Optional<Course> findById(Integer id);
}