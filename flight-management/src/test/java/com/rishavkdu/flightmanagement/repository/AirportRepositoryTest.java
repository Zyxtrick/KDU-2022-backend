package com.rishavkdu.flightmanagement.repository;

import com.rishavkdu.flightmanagement.entities.Airport;
import com.rishavkdu.flightmanagement.entities.City;
import com.rishavkdu.flightmanagement.entities.Country;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AirportRepositoryTest {

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Test
    public void saveAirport(){
        Country country = countryRepository.findById(1L).get();
        City city = City.builder()
                .cityCode(106L)
                .cityName("Siliguri")
                .country(country)
                .build();
        Airport airport = Airport.builder()
                .airportCode("IXB")
                .airportName("Bagdogra International Airport")
                .city(city)
                .country(country)
                .build();

        airportRepository.save(airport);
    }
}