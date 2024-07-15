package com.example.springbootwebtutuorial.controllers;

import com.example.springbootwebtutuorial.dto.EmployeeDTO;
import com.example.springbootwebtutuorial.services.EmployeeService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

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
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("employeeID") Long employeeId){

        return employeeService.findById(employeeId);
    }

    @GetMapping
    public List<EmployeeDTO> getEmployees(@RequestParam(required = false) Integer age){

        return employeeService.getAllEmployees();

    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO inputEmployee){
        return employeeService.createNewEmployee(inputEmployee);
    }

    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO>  updateEmployeeById(@RequestBody @Valid EmployeeDTO employeeDTO,@PathVariable(name = "employeeId") Long id){

        return  employeeService.updateEmployeeById(id,employeeDTO);
    }

    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<Boolean>  deleteEmployeeById(@PathVariable(name = "employeeId") Long id){
       return employeeService.deleteEmployeeById(id);
    }

    @PatchMapping(path = "/{employeeId}")
    public EmployeeDTO  updatePartialEmployeeById(Map<String, Objects> updates, @PathVariable(name = "employeeId") Long id){

        return  employeeService.updatePartialEmployeeById(id,updates);
    }
}
