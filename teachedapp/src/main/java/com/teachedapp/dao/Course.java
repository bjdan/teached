package com.teachedapp.dao;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="course")
@SequenceGenerator(name = "course_generator", sequenceName = "course_sequence", allocationSize = 1)
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_generator")
    @Column(name = "course_id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;

    @Column(name = "hours_per_week")
    private Double hoursPerWeek;

    @Column(name = "lessons_schedule", columnDefinition = "text")
    private String lessonsSchedule;

    @Column(name = "student_price_per_hour")
    private BigDecimal studentPricePerHour;

    @Column(name = "teacher_pay_rate_per_hour")
    private BigDecimal teacherPayRatePerHour;

    @OneToMany(mappedBy = "course")
    List<Lesson> lessons;

    @Enumerated(EnumType.ORDINAL)
    private CourseStatus status;

}
