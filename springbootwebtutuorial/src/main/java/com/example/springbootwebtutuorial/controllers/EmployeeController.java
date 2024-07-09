package com.example.springbootwebtutuorial.controllers;

import com.example.springbootwebtutuorial.dto.EmployeeDTO;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping(path = "/getSecretMessage")
    public String getSecretMessage()
    {
        return "Secret Message : afsghdddk";
    }

    @GetMapping("/{employeeID}")
    public EmployeeDTO getEmployeeById(@PathVariable("employeeID") Long employeeId){

        return new EmployeeDTO(employeeId,"Abhisek","abhisekdas98@gmail.com","Puri",25, LocalDate.of(2024,7,9),true);
    }

    @GetMapping
    public String getEmployees(@RequestParam(required = false) Integer age){

        return "Hi age"+age;

    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){

        inputEmployee.setId(100l);
        return inputEmployee;
    }

    @PutMapping String  updateEmployee(){
        return  "Hi FROM PUT";
    }
}
