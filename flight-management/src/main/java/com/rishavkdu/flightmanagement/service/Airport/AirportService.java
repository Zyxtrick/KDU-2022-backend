package com.rishavkdu.flightmanagement.service.Airport;

import com.rishavkdu.flightmanagement.entities.Airport;

public interface AirportService {
    Airport getById(String arrivalAirportCode);
}
