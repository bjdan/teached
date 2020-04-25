package com.teachedapp.dao;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id
    private int id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "student_account_id", referencedColumnName = "account_id")
    private Account account;

    private PersonalData personalData;

    private Address address;

}

