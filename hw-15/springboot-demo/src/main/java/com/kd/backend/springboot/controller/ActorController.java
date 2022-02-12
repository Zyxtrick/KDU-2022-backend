package com.kd.backend.springboot.controller;

import com.kd.backend.springboot.dto.ActorDTO;
import com.kd.backend.springboot.dto.FilmDTO;
import com.kd.backend.springboot.service.ActorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/actor")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @Value("${spring.application.name}")
    private static String applicationName;

    private final Logger logger = LoggerFactory.getLogger(FilmController.class);

    @GetMapping("/{actorId}")
    public ResponseEntity<ActorDTO> getById(@PathVariable Long actorId) {
        logger.info("Recieved a request to fetch actor with id: {}", actorId);
        return Optional.ofNullable(actorService.getActorById(actorId))
                .map(a -> new ResponseEntity<>(a, HttpStatus.OK))
                .orElse(sendNotFound());

    }

    private ResponseEntity<ActorDTO> sendNotFound() {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/")
    public ActorDTO createActor(@RequestBody ActorDTO actorDTO) {
        return actorService.createActor(actorDTO);
    }


}
