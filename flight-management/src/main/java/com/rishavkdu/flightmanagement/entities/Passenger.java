package com.rishavkdu.flightmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Builder
public class Passenger {

    @Id
    @Column(name = "passanger_id")
    @SequenceGenerator(name="passanger_sequence", sequenceName = "passanger_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passanger_sequence" )
    private Long passengerId;

    @Column(name = "passanger_name")
    private String passangerName;
    private String type;

    @Column(name = "seat_no")
    private Integer seatNumber;

    @Column(name = "email_id")
    private String emailId;
    private Long phone;
    private Integer age;
    private String sex;
    private Boolean confirmed;
    private Boolean cancelled;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="instance_id", referencedColumnName = "instance_id")
    private FlightInstance flightInstance;

}

