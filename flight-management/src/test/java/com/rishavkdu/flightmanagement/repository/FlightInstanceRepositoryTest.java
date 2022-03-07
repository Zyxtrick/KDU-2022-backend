package com.rishavkdu.flightmanagement.repository;

import com.rishavkdu.flightmanagement.entities.Airplane;
import com.rishavkdu.flightmanagement.entities.FlightInstance;
import com.rishavkdu.flightmanagement.entities.Route;
import com.rishavkdu.flightmanagement.entities.RoutePlanes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FlightInstanceRepositoryTest {

    @Autowired
    private FlightInstanceRepository flightInstanceRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Test
    public void saveFlightInstance(){
        Route route = routeRepository.findById("6").get();
        Airplane airplane = airplaneRepository.findById("IGO 001").get();
        RoutePlanes routePlane = RoutePlanes.builder()
                .routeId("6")
                .airplane(airplane)
                .build();
        FlightInstance flightInstance = FlightInstance.builder()
                .instanceId("FL0001")
                .BSeats(5)
                .FSeats(109)
                .ESeats(10)
                .BCost(10000)
                .ECost(5000)
                .FCost(20000)
                .routePlane(routePlane)
                .airplane(airplane)
                .arrival("21-02-2022 09:30")
                .departure("21-02-2022 12:30")
                .build();

        flightInstanceRepository.save(flightInstance);
    }
}