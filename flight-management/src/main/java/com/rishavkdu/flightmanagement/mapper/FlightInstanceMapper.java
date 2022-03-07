package com.rishavkdu.flightmanagement.mapper;

import com.rishavkdu.flightmanagement.dto.FlightInstanceDTO;
import com.rishavkdu.flightmanagement.entities.FlightInstance;
import com.rishavkdu.flightmanagement.service.Airplane.AirplaneService;
import com.rishavkdu.flightmanagement.service.FlightInstance.FlightInstanceService;
import com.rishavkdu.flightmanagement.service.RoutePlanes.RoutePlanesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FlightInstanceMapper {

    @Autowired
    private AirplaneService airplaneService;

    @Autowired
    private RoutePlanesService routePlanesService;


    public FlightInstance toEntity(FlightInstanceDTO flightInstanceDTO){
        FlightInstance flightInstance = FlightInstance.builder()
                .instanceId(flightInstanceDTO.getInstanceId())
                .BSeats(flightInstanceDTO.getBSeats())
                .ESeats(flightInstanceDTO.getESeats())
                .FSeats(flightInstanceDTO.getFSeats())
                .BCost(flightInstanceDTO.getBCost())
                .FCost(flightInstanceDTO.getFCost())
                .ECost(flightInstanceDTO.getECost())
                .arrival(flightInstanceDTO.getArrival())
                .departure(flightInstanceDTO.getDeparture())
                .build();

        if(Objects.nonNull(flightInstanceDTO.getAirplaneId()) && !"".equalsIgnoreCase(flightInstanceDTO.getInstanceId())){
            flightInstance.setAirplane(airplaneService.getById(flightInstanceDTO.getInstanceId()));
        }
        if(Objects.nonNull(flightInstanceDTO.getRouteId()) && !"".equalsIgnoreCase(flightInstanceDTO.getRouteId())){
            flightInstance.setRoutePlane(routePlanesService.getById(flightInstanceDTO.getRouteId()));
        }

        return flightInstance;
    }

}
