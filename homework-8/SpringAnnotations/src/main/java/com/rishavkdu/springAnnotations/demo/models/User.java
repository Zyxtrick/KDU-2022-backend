package com.rishavkdu.springAnnotations.demo.models;

import javax.validation.constraints.NotNull;
import lombok.Data;
import com.rishavkdu.springAnnotations.demo.validation.ValidAge;

@Data
public class User {

    @NotNull(message = "Name cannot be null")
    private String name;

    @ValidAge
    private String dob;

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}