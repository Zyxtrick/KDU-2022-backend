package com.kd.backend.springboot.test.controller;

import com.kd.backend.springboot.entity.Actor;
import com.kd.backend.springboot.entity.Film;
import com.kd.backend.springboot.repository.ActorRepository;
import com.kd.backend.springboot.repository.FilmRepository;
import org.apache.coyote.http11.filters.VoidInputFilter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ActorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ActorRepository actorRepository;

    private Actor actor = null;

    public ActorControllerTest() {

    }

    @Test
    public void getByIdTest() throws Exception {
        Actor actor = new Actor();
        actor.setFirstName("John");
        actor.setLastName("Bird");
        actor = actorRepository.save(actor);
        System.out.println("Inserted new film with id: " + actor.getId());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/actor/id/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getByFirstNameTest() throws Exception {
        Actor actor = new Actor();
        actor.setFirstName("John");
        actor.setLastName("Bird");
        actor = actorRepository.save(actor);
        System.out.println("Inserted new film with id: " + actor.getId());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/actor/firstName/John")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getByLastNameTest() throws Exception {
        Actor actor = new Actor();
        actor.setFirstName("John");
        actor.setLastName("Bird");
        actor = actorRepository.save(actor);
        System.out.println("Inserted new film with id: " + actor.getId());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/actor/lastName/Bird")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getActorByIdNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/actor/id/100111")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getActorByFirstNameNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/actor/firstName/Perte")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGlobalIllegalExceptionHandler() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/actor/id/Cale")
                        .header("x-limit", 10)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }

}
