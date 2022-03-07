package com.rishavkdu.flightmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(uniqueConstraints = @UniqueConstraint(name="country_unique", columnNames = "country_name"))
public class Country {

    @Id
    @Column(name = "country_code")
    @SequenceGenerator(name="country_sequence", sequenceName = "country_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_sequence" )
    private Long countryCode;

    @Column(name = "country_name")
    private String countryName;

}
