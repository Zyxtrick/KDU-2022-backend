package com.rishavkdu.flightmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Table
public class Route {

    @Id
    @Column(name ="route_id")
    private String routeId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departure_airport_code", referencedColumnName = "airport_code")
    private Airport departureAirport;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "arrival_airport_code", referencedColumnName = "airport_code")
    private Airport arrivalAirport;

}
