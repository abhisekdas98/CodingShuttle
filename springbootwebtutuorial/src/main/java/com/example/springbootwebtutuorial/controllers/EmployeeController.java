package com.example.springbootwebtutuorial.controllers;

import com.example.springbootwebtutuorial.dto.EmployeeDTO;
import com.example.springbootwebtutuorial.entities.EmployeeEntity;
import com.example.springbootwebtutuorial.reposiroties.EmployeeRepository;
import com.example.springbootwebtutuorial.services.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    @GetMapping(path = "/getSecretMessage")
    public String getSecretMessage()
    {
        return "Secret Message : afsghdddk";
    }

    @GetMapping("/{employeeID}")
    public EmployeeDTO getEmployeeById(@PathVariable("employeeID") Long employeeId){

        return employeeService.findById(employeeId);
    }

    @GetMapping
    public List<EmployeeDTO> getEmployees(@RequestParam(required = false) Integer age){

        return employeeService.getAllEmployees();

    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        return employeeService.createNewEmployee(inputEmployee);
    }

    @PutMapping String  updateEmployee(){
        return  "Hi FROM PUT";
    }
}
