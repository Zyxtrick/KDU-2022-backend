package com.rishavkdu.flightmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Airline {

    @Id
    @Column(name = "airline_code")
    private String airlineId;

    @Column(name = "airline_name")
    private String airlineName;

    @ManyToMany()
    @JoinTable(
            name = "Routes_Airline",
            joinColumns = @JoinColumn(name = "airline_code", referencedColumnName = "airline_code"),
            inverseJoinColumns = @JoinColumn(name = "route_id", referencedColumnName = "route_id")
    )
    private List<Route> routes;

}
