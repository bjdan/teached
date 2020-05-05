package com.teachedapp.dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "administrator")
@Data
public class Administrator {

    @Id
    private Integer id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "administrator_account_id", referencedColumnName = "account_id")
    private Account account;

    private PersonalData personalData;

}
