package com.teachedapp.dao;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class Address {

    @Column(length = 40)
    private String country;

    @Column(length = 40)
    private String state;

    @Column(length = 40)
    private String city;

}
