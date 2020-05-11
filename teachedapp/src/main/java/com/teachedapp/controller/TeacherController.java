package com.teachedapp.controller;

import com.teachedapp.dao.Account;
import com.teachedapp.dao.Subject;
import com.teachedapp.dao.Teacher;
import com.teachedapp.respository.AccountRepository;
import com.teachedapp.respository.SubjectRepository;
import com.teachedapp.respository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/teachers", produces = {MediaType.APPLICATION_JSON_VALUE})
public class TeacherController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        Account teacherAccount = teacher.getAccount();
        accountRepository.save(teacherAccount);
        teacher.setAccount(teacherAccount);

        List<Subject> subjectList = new ArrayList<>();
        for(Subject subject : teacher.getSubjects()){
            Optional<Subject> foundSubject = subjectRepository.findById(subject.getId());
            foundSubject.ifPresent(subjectList::add);
        }
        teacher.setSubjects(subjectList);
        teacherRepository.save(teacher);

        return teacher;
    }

}
