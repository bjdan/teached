package com.teachedapp.respository;

import com.teachedapp.dao.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    List<Teacher> findByAccount_LoginContainingIgnoreCase(String login);
    List<Teacher> findByAccount_PersonalData_FirstNameContainingIgnoreCaseAndAccount_PersonalData_LastNameContainingIgnoreCase(String firstName, String lastName);
    List<Teacher> findByAccount_PersonalData_Sex(Character sex);
    List<Teacher> findByAccount_PersonalData_AgeBetween(Integer from, Integer to);
}