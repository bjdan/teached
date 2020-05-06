package com.teachedapp.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="account")
@SequenceGenerator(name = "account_generator", sequenceName = "account_sequence", allocationSize = 1)
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_generator")
    @Column(name = "account_id", nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String email;

    @Column(length = 40, nullable = false)
    private String login;

    @Column(length = 40, nullable = false)
    private String password;

    @Column(name = "created_date", columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private final Date createdDate = new Date();

    @Enumerated(EnumType.ORDINAL)
    private AccountStatus status;

    private PersonalData personalData;

    private Address address;

}
