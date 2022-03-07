package com.rishavkdu.flightmanagement.controller;

import com.rishavkdu.flightmanagement.dto.RouteDTO;
import com.rishavkdu.flightmanagement.entities.Route;
import com.rishavkdu.flightmanagement.mapper.RouteMapper;
import com.rishavkdu.flightmanagement.service.Route.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouteController {

    @Autowired
    private RouteMapper mapper;

    @Autowired
    private RouteService routeService;

    @PostMapping("/addRoute")
    public Route addRoute(@RequestBody RouteDTO routeDTO){
        Route route = mapper.toEntity(routeDTO);
        return routeService.saveRoute(route);
    }
}
