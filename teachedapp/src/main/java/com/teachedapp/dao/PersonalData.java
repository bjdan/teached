package com.teachedapp.dao;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PersonalData {

    @Column(length = 40)
    private String first_name;

    @Column(length = 40)
    private String last_name;

    private short age;

    private char sex;

}
