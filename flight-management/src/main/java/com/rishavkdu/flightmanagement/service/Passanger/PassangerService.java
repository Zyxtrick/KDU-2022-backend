package com.rishavkdu.flightmanagement.service.Passanger;

import com.rishavkdu.flightmanagement.entities.Passenger;

import java.util.List;

public interface PassangerService {
    public Passenger savePassenger(Passenger passenger);

    List<Passenger> getAllPassengers();

    List<Passenger> getAllPassangersByAirPlaneId(String airplaneId);
}
