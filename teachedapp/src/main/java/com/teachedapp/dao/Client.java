package com.teachedapp.dao;

import javax.persistence.*;

@Entity
@Table(name="client")
@SequenceGenerator(name = "client_generator", sequenceName = "client_sequence", allocationSize = 1)
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_generator")
    @Column(name="client_id", nullable=false)
    private int id;

    private String name;

}

