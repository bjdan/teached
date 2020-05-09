package com.teachedapp.service;

import com.teachedapp.dao.Subject;

import java.util.List;

public interface SubjectService {

    List<Subject> getAllSubjects();
    List<Subject> getAllSubjectsByNameContaining(String name);

}
