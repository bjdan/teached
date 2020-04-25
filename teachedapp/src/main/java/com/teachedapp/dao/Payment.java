package com.teachedapp.dao;

import javax.persistence.*;

@Entity
@Table(name="payment")
@SequenceGenerator(name = "payment_generator", sequenceName = "payment_sequence", allocationSize = 1)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_generator")
    @Column(name="payment_id", nullable=false)
    private int id;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus status;

    private Float amount;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    Account sender;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    Account recipient;

    @OneToOne(mappedBy = "payment", cascade = CascadeType.ALL)
    Lesson lesson;

}
