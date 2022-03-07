package com.rishavkdu.flightmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class Airplane {

    @Id
    @Column(name = "airplane_id")
    private String airplaneId;

    @Column(name = "airplane_name")
    private String airplaneName;

    @Column(name = "B_Seats")
    private Integer BSeats;

    @Column(name = "E_Seats")
    private Integer ESeats;

    @Column(name = "F_Seats")
    private Integer FSeats;

}
