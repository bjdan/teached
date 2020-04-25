package com.teachedapp.dao;

import javax.persistence.*;

@Entity
@Table(name="teacher")
public class Teacher {

    @Id
    private int id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "teacher_account_id", referencedColumnName = "account_id")
    private Account account;

    private PersonalData personalData;

    private Address address;

    private String description;

}
