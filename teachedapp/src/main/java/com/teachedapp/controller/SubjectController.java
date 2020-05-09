package com.teachedapp.controller;

import com.teachedapp.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/subjects", produces = {MediaType.APPLICATION_JSON_VALUE})
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public String getSubjects(Model model, String name) {
        if (name != null) {
            model.addAttribute("subjects", subjectService.getAllSubjectsByNameContaining(name));

        } else {
            model.addAttribute("subjects", subjectService.getAllSubjects());

        }
        return "subjects";
    }

}
