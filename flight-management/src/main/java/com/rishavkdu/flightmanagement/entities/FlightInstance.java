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
public class FlightInstance {

    @Id
    @Column(name = "instance_id")
    private String instanceId;

    @Column(name = "B_Seats")
    private Integer BSeats;

    @Column(name = "E_Seats")
    private Integer ESeats;

    @Column(name = "F_Seats")
    private Integer FSeats;

    @Column(name = "B_Cost")
    private Integer BCost;

    @Column(name = "E_Cost")
    private Integer ECost;

    @Column(name = "F_Cost")
    private Integer FCost;

    private String arrival;
    private String departure;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "route_id", referencedColumnName = "route_id")
    private RoutePlanes routePlane;

    @ManyToOne
    @JoinColumn(name = "airplane_id", referencedColumnName = "airplane_id")
    private Airplane airplane;

}
