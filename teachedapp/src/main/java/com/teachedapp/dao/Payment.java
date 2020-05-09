package com.teachedapp.dao;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="payment")
@SequenceGenerator(name = "payment_generator", sequenceName = "payment_sequence", allocationSize = 1)
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_generator")
    @Column(name = "payment_id", nullable = false)
    private Integer id;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus status;

    private BigDecimal amount;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    Account sender;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "recipient_id")
    Account recipient;

}
