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
@Table(uniqueConstraints = @UniqueConstraint(name="country_unique", columnNames = "country_name"))
public class City {

    @Id
    @Column(name = "city_code")
    @SequenceGenerator(name="city_sequence", sequenceName = "city_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "city_sequence" )
    private Long cityCode;

    @Column(name = "country_name")
    private String cityName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_code", referencedColumnName = "country_code")
    private Country country;

}

