package com.teachedapp.dao;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(length = 40)
    private String country;

    @Column(length = 40)
    private String state;

    @Column(length = 40)
    private String city;

}
