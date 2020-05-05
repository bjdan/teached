package com.teachedapp.dao;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="lesson")
@SequenceGenerator(name = "lesson_generator", sequenceName = "lesson_sequence", allocationSize = 1)
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lesson_generator")
    @Column(name="lesson_id", nullable=false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Enumerated(EnumType.ORDINAL)
    private LessonStatus status;

    private String notes;

    @Column(nullable = true)
    private short duration; // in hours

    private Date start_date;

    private Date end_date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "payment_id")
    private Payment payment;

    @Column(name = "student_paid")
    private Boolean studentPaid;

    @Column(name = "teacher_was_paid")
    private Boolean teacherWasPaid;

}