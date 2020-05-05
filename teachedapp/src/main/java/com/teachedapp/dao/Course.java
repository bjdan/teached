package com.teachedapp.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
@SequenceGenerator(name = "course_generator", sequenceName = "course_sequence", allocationSize = 1)
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_generator")
    @Column(name = "course_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    private Integer gross_price; // per hour

    @OneToMany(mappedBy = "course")
    List<Lesson> lessons;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;

    @Enumerated(EnumType.ORDINAL)
    private CourseStatus status;

}
