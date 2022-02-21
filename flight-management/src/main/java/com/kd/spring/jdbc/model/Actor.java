package com.kd.spring.jdbc.model;

import lombok.Data;

@Data
public class Actor {
    private long actorId;
    private String firstName;
    private String lastName;
    private String lastUpdate;
}