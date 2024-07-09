package com.example.springbootwebtutuorial.dto;

import java.time.LocalDate;

public class EmployeeDTO {

    Long id;
    String name;
    String email;
    String address;
    Integer age;
    LocalDate dateOfJoining;
    Boolean isActive;

    public EmployeeDTO(Long id, String name, String email, String address, Integer age, LocalDate dateOfJoining, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.age = age;
        this.dateOfJoining = dateOfJoining;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public Integer getAge() {
        return age;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
