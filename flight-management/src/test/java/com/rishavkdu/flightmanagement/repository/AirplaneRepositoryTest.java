package com.rishavkdu.flightmanagement.repository;

import com.rishavkdu.flightmanagement.entities.Airplane;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Table;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AirplaneRepositoryTest {

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Test
    public void saveAirplane(){
        Airplane airplane = Airplane.builder()
                .airplaneId("IGO 003")
                .airplaneName("Indigo 003")
                .BSeats(10)
                .ESeats(101)
                .FSeats(12)
                .build();
        airplaneRepository.save(airplane);
    }
}