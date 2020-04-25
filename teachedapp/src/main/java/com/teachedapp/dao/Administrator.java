package com.teachedapp.dao;

import javax.persistence.*;

@Entity
@Table(name="administrator")
public class Administrator {

    @Id
    private int id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "administrator_account_id", referencedColumnName = "account_id")
    private Account account;

    private PersonalData personalData;

}
