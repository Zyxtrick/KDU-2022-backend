package com.rishavkdu.flightmanagement.repository;

import com.rishavkdu.flightmanagement.entities.Airline;
import com.rishavkdu.flightmanagement.entities.Route;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AirlineRepositoryTest {

    @Autowired
    private AirlineRepository airlineRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Test
    public void saveAirline(){
        //SpiceJet  SEJ 1,3,5,7,10,11,14
        //AirAsia   AIC 1,2,4,6,8,10,12
        //AirIndia  AIN 5,9,11,12,13,14,15
        //Indigo    IGO  2,3,4,6,8,12,13
        //Vistara   VTI
        Route route1 = routeRepository.findById("2").get();
        Route route2 = routeRepository.findById("3").get();
        Route route3 = routeRepository.findById("4").get();
        Route route4 = routeRepository.findById("6").get();
        Route route5 = routeRepository.findById("8").get();
        Route route6 = routeRepository.findById("12").get();
        Route route7 = routeRepository.findById("13").get();


        Airline airline = Airline.builder()
                .airlineId("IGO")
                .airlineName("Indigo")
                .routes(List.of(route1, route2, route3, route4, route5, route6, route7))
                .build();

        airlineRepository.save(airline);
    }


}