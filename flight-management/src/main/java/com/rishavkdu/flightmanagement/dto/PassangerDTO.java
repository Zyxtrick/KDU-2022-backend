package com.rishavkdu.flightmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassangerDTO implements Serializable {
    private String passangerName;
    private String type;
    private Integer seatNumber;
    private String emailId;
    private Long phone;
    private Integer age;
    private String sex;
    private Boolean confirmed;
    private Boolean cancelled;
    private Long userId;
    private String instanceId;
}
