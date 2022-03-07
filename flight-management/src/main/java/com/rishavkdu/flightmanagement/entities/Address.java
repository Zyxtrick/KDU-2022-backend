package com.rishavkdu.flightmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverrides({
    @AttributeOverride(name="lineOne", column = @Column(name ="line_one")),
    @AttributeOverride(name="lineTwo", column = @Column(name ="line_two")),
})
public class Address {

    private String lineOne;
    private String lineTwo;
    private String city;
    private String state;
    private String country;
}
