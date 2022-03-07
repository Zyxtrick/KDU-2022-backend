package com.rishavkdu.flightmanagement.controller;

import com.rishavkdu.flightmanagement.dto.FlightInstanceDTO;
import com.rishavkdu.flightmanagement.entities.FlightInstance;
import com.rishavkdu.flightmanagement.mapper.FlightInstanceMapper;
import com.rishavkdu.flightmanagement.service.FlightInstance.FlightInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightInstanceController {

    @Autowired
    private FlightInstanceService flightInstanceService;

    @Autowired
    private FlightInstanceMapper flightInstanceMapper;

    @PutMapping("/changeFlightDetails/{instanceId}")
    public FlightInstance changeFlightInstance(@PathVariable String instanceId, @RequestBody FlightInstanceDTO flightInstanceDTO){
        FlightInstance flightInstance = flightInstanceMapper.toEntity(flightInstanceDTO);
        return flightInstanceService.updateFlightInstance(instanceId, flightInstance);
    }

    @GetMapping("/seeFlightDetails")
    public List<FlightInstance> viewFlightDetails(){
        return flightInstanceService.viewFlightDetails();
    }
}
