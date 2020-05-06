package com.teachedapp.dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
@Data
public class Teacher {

    @Id
    private Integer id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "teacher_account_id", referencedColumnName = "account_id")
    private Account account;

    private String description;

}
