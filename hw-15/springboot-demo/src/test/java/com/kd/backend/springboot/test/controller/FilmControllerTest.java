package com.kd.backend.springboot.test.controller;

import com.kd.backend.springboot.entity.Film;
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
public class FilmControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FilmRepository filmRepository;


    @Test
    public void getFilmByIdTest() throws Exception {
        Film film = new Film();
        film.setYear(2008L);
        film.setTitle("Dark Knight");
        film.setDescription("Another Batman movie By Chris Nolan");
        film.setRating("A");
        film = filmRepository.save(film);
        System.out.println("Inserted new film with id: " + film.getId());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/film/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getFilmByIdNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/film/100")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGlobalExceptionHandler() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/film/?year=2006")
                        .header("x-limit", 10)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }
}
