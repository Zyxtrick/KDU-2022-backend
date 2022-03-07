package com.rishavkdu.flightmanagement.repository;

import com.rishavkdu.flightmanagement.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    public List<Country> findByCountryName(String firstName);
    public List<Country> findByCountryNameContaining(String name);


}


