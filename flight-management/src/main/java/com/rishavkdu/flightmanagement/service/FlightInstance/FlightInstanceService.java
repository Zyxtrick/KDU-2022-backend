package com.rishavkdu.flightmanagement.service.FlightInstance;

import com.rishavkdu.flightmanagement.entities.FlightInstance;

import java.util.List;

public interface FlightInstanceService {
    public FlightInstance updateFlightInstance(String airplaneId, FlightInstance flightInstance);

    FlightInstance getFlightById(String instanceId);

    List<FlightInstance> viewFlightDetails();
}
