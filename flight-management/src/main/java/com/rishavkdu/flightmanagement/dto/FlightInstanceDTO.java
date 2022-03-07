package com.rishavkdu.flightmanagement.dto;

import com.rishavkdu.flightmanagement.entities.Airplane;
import com.rishavkdu.flightmanagement.entities.RoutePlanes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightInstanceDTO implements Serializable {
    private String instanceId;
    private Integer BSeats;
    private Integer ESeats;
    private Integer FSeats;
    private Integer BCost;
    private Integer ECost;
    private Integer FCost;
    private String arrival;
    private String departure;
    private String routeId;
    private String airplaneId;
}
