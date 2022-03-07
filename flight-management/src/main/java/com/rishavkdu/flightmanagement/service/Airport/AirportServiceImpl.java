package com.rishavkdu.flightmanagement.service.Airport;

import com.rishavkdu.flightmanagement.entities.Airport;
import com.rishavkdu.flightmanagement.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl implements AirportService{

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public Airport getById(String arrivalAirportCode) {
        return airportRepository.findById(arrivalAirportCode).get();
    }
}
