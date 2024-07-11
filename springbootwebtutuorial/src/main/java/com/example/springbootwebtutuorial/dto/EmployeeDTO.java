package com.example.springbootwebtutuorial.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDTO {

    Long id;
    String name;
    String email;
    String address;
    Integer age;
    LocalDate dateOfJoining;
    Boolean isActive;
}
