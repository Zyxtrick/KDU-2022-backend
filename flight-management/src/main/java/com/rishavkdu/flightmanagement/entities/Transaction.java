package com.rishavkdu.flightmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Builder
public class Transaction {

    @Id
    @Column(name = "order_id")
    @SequenceGenerator(name="transaction_sequence", sequenceName = "transaction_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "transaction_sequence" )
    private Long transactionId;
    private Double amount;
    private String gateway;
    private String status;

    @Column(name = "payment_mode")
    private String paymentMode;

    @Column(name = "response_message")
    private String responseMessage;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="user_id", referencedColumnName = "user_id")
    private User user;

}
