package com.rishavkdu.flightmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RouteDTO implements Serializable {

    private String routeId;
    private String arrivalAirportCode;
    private String departureAirportCode;
}
