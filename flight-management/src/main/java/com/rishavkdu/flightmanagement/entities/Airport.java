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
@Builder
public class Airport {

    @Id
    @Column(name = "airport_code")
    private String airportCode;

    @Column(name = "airport_name")
    private String airportName;

    @ManyToOne
    @JoinColumn(name = "country_code", referencedColumnName = "country_code")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "city_code", referencedColumnName = "city_code")
    private City city;
}
