package com.teachedapp.controller;

import com.teachedapp.dao.*;
import com.teachedapp.respository.AccountRepository;
import com.teachedapp.respository.SubjectRepository;
import com.teachedapp.respository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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


    @GetMapping(value = "/{id}/salary", produces = "application/json")
    public Double getSalary(@PathVariable("id") Integer id,
                             @RequestParam(value="calculateDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date calculateDate) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        double salary = 0.0;

        if(teacher.isPresent()){
            List<Course> courses = teacher.get().getCourses();

            if(calculateDate != null){

                Calendar chosenDate = Calendar.getInstance();
                chosenDate.setTime(calculateDate);
                Calendar lessonDate = Calendar.getInstance();

                for(Course course : courses) {
                    Double coursePayRatePerHour = course.getTeacherPayRatePerHour().doubleValue();
                    for (Lesson lesson : course.getLessons()) {
                        if(lesson.getStatus() == LessonStatus.ENDED){

                            lessonDate.setTime(lesson.getDate());

                            if (chosenDate.get(Calendar.YEAR) == lessonDate.get(Calendar.YEAR)
                                    && chosenDate.get(Calendar.MONTH) == lessonDate.get(Calendar.MONTH)) {
                                    salary += (coursePayRatePerHour * lesson.getDuration());
                            }
                        }
                    }
                }
            } else {
                for(Course course : courses) {
                    Double coursePayRatePerHour = course.getTeacherPayRatePerHour().doubleValue();

                    for (Lesson lesson : course.getLessons()) {
                        if(lesson.getStatus() == LessonStatus.ENDED
                                && (lesson.getTeacherWasPaid() == null || !lesson.getTeacherWasPaid())) {
                            salary += (coursePayRatePerHour * lesson.getDuration());
                        }
                    }
                }
            }

        }
        return salary;
    }
}
