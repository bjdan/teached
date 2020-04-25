package com.teachedapp.dao;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="account")
@SequenceGenerator(name = "account_generator", sequenceName = "account_sequence", allocationSize = 1)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_generator")
    @Column(name="account_id", nullable=false)
    private int id;

    @Column(nullable = false)
    private String email;

    @Column(length = 40, nullable = false)
    private String login;

    @Column(length = 40, nullable = false)
    private String password;

    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private final Date created_date = new Date();

    @Enumerated(EnumType.ORDINAL)
    private AccountStatus status;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    Teacher teacher;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    Student student;

}
