package com.teachedapp.respository;

import com.teachedapp.dao.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    @PostAuthorize("returnObject.get().course.teacher.account.login == authentication.name " +
            "|| returnObject.get().course.student.account.login == authentication.name" +
            "|| hasRole('ROLE_ADMIN')")
    @Override
    Optional<Lesson> findById(Integer id);
}
