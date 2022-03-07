package com.rishavkdu.flightmanagement.mapper;

import com.rishavkdu.flightmanagement.dto.RouteDTO;
import com.rishavkdu.flightmanagement.entities.Route;
import com.rishavkdu.flightmanagement.repository.AirportRepository;
import com.rishavkdu.flightmanagement.service.Airport.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouteMapper {

    @Autowired
    private AirportService airportService;

    public Route toEntity(RouteDTO routeDTO){
        Route route = Route.builder()
                .routeId(routeDTO.getRouteId())
                .arrivalAirport(airportService.getById(routeDTO.getArrivalAirportCode()))
                .departureAirport(airportService.getById(routeDTO.getDepartureAirportCode()))
                .build();

        return route;
    }
}
