package com.example.springbootwebtutuorial.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String email;
    String address;
    Integer age;
    LocalDate dateOfJoining;
    Boolean isActive;
    String role;
    Double salary;
}
