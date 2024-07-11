package com.example.springbootwebtutuorial.controllers;

import com.example.springbootwebtutuorial.dto.EmployeeDTO;
import com.example.springbootwebtutuorial.entities.EmployeeEntity;
import com.example.springbootwebtutuorial.reposiroties.EmployeeRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }
    @GetMapping(path = "/getSecretMessage")
    public String getSecretMessage()
    {
        return "Secret Message : afsghdddk";
    }

    @GetMapping("/{employeeID}")
    public EmployeeEntity getEmployeeById(@PathVariable("employeeID") Long employeeId){

        return employeeRepository.findById(employeeId).orElse(null);
    }

    @GetMapping
    public List<EmployeeEntity> getEmployees(@RequestParam(required = false) Integer age){

        return employeeRepository.findAll();

    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
        return employeeRepository.save(inputEmployee);
    }

    @PutMapping String  updateEmployee(){
        return  "Hi FROM PUT";
    }
}
