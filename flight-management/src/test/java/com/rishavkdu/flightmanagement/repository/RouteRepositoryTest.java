package com.rishavkdu.flightmanagement.repository;

import com.rishavkdu.flightmanagement.entities.Airport;
import com.rishavkdu.flightmanagement.entities.Route;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RouteRepositoryTest {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Test
    public void saveRoute(){
        Airport arrivalAirport = airportRepository.findById("IXB").get();
        Airport destinationAirport = airportRepository.findById("CCU").get();
        Route route = Route.builder()
                .routeId("15")
                .arrivalAirport(arrivalAirport)
                .departureAirport(destinationAirport)
                .build();

        routeRepository.save(route);
    }

}