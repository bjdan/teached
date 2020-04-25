package com.teachedapp.dao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="subject_id", nullable=false)
    private int id;

    @Column(length = 40, nullable = false)
    private String name;

    @OneToMany(mappedBy = "subject")
    List<Course> courses;

}
