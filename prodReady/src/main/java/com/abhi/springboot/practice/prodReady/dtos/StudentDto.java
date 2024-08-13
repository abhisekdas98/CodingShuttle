package com.abhi.springboot.practice.prodReady.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    @NotNull(message = "Student ID should not be null or empty")
    private Long studentId;
    @NotNull(message = "Student Name should not be empty or null")
    private String studentName;
    private String studentAddress;
    private String studentDepartment;
    private LocalDate studentEnrollmentYear;
}
