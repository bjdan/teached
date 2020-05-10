package com.teachedapp.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teacher")
@Data
public class Teacher {

    @Id
    private Integer id;

    @MapsId
    @OneToOne(optional=false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "teacher_account_id", referencedColumnName = "account_id")
    private Account account;

    private String description;

    @OneToMany(mappedBy = "teacher")
    List<Course> courses;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "teacher_subject_assignment",
            joinColumns = {@JoinColumn(name = "teacher_account_id")},
            inverseJoinColumns = {@JoinColumn(name = "subject_id")})
    private List<Subject> subjects;

}
