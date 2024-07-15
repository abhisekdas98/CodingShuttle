package com.example.springbootwebtutuorial.dto;

import com.example.springbootwebtutuorial.annotations.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
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

    private Long id;
    @NotNull(message = "Required Field in Employee : name")
    @Size(min = 3, max = 10, message = "Number of characters in the name should be in range [3,10]")
    private String name;
    @Email(message = "Email should be a valid email")
    @NotBlank(message = "Email cannot be blank")
    private String email;
    private String address;
    @NotNull(message = "Age of Employee cannot be Null")
    @Max(value = 80, message = "age of employee cannot be greater than 80")
    @Min(value = 18, message = "age of employee cannot be less than 18")
    private Integer age;

    @NotNull(message = "Role of Employee cannot be blank")
    //@Pattern(regexp = "^(ADMIN|USER)$",message = "Role of Employee can be ADMIN or USER")
    @EmployeeRoleValidation
    private String role;

    @PastOrPresent(message = "DOB field in Employee should not be in future")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee should be Active")
    private Boolean isActive;

    @NotNull(message = "Salary of Employee cannot be null")
    @Positive(message = "Salary of the Employee should be Positive")
    @Digits(integer = 6,fraction = 2 , message = "Salary of Employee should be in format xxxxxx.yy")
    @DecimalMin(value = "100.50")
    @DecimalMax(value = "100000.600")
    private Double salary;
}
