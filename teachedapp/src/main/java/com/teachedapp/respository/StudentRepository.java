package com.teachedapp.respository;

import com.teachedapp.dao.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByAccount_EmailContainingIgnoreCase(String email);
    List<Student> findByAccount_LoginContainingIgnoreCase(String login);
    List<Student> findByAccount_PersonalData_FirstNameContainingIgnoreCaseAndAccount_PersonalData_LastNameContainingIgnoreCase(String firstName, String lastName);
    List<Student> findByAccount_PersonalData_Sex(Character sex);
}