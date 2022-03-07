package com.rishavkdu.flightmanagement.repository;

import com.rishavkdu.flightmanagement.entities.Country;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CountryRepositoryTest {

    @Autowired
    private CountryRepository countryRepository;

    @Test
    public void saveCountry(){
        Country country = Country.builder()
                .countryName("India")
                .build();

        countryRepository.save(country);
    }

    @Test
    public void printAllCountry(){
        List<Country> countryList = countryRepository.findAll();
        System.out.println("country list : " + countryList);
    }

    @Test
    public void printStudentByCountryName() {
        List<Country> countries = countryRepository.findByCountryName("India");
        System.out.println("countries = " + countries);
    }

    @Test
    public void printStudentByCountryNameContaining() {
        List<Country> countries = countryRepository.findByCountryNameContaining("ia");
        System.out.println("countries = " + countries);
    }

}