package com.kd.spring.jdbc.hibernate.entity.oneToMany;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.nio.MappedByteBuffer;


@Entity
@Table(name ="address")
@Data
public class Address implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "address_id")
    private Long addressId;

    private String address;
    private String address2;
    private String district;

    @NotEmpty
    private Long city_id;
    private Long phone;
    private int postal_code;
    private String last_update;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private City city;

}
