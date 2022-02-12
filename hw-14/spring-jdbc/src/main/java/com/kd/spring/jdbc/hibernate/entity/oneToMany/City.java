package com.kd.spring.jdbc.hibernate.entity.oneToMany;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name ="city")
@Data
public class City implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "city_id")
    private Long cityId;

    private String city;

    @NotEmpty
    private Long country_id;
    private String last_update;

    @OneToMany(mappedBy = "city")
    private List<Address> address;

}
