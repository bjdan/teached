package com.teachedapp.dao;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    private Integer id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "student_account_id", referencedColumnName = "account_id")
    private Account account;

    private BigDecimal budget;

}

