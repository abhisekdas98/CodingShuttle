package com.example.springbootwebtutuorial.services;

import com.example.springbootwebtutuorial.dto.EmployeeDTO;
import com.example.springbootwebtutuorial.entities.EmployeeEntity;
import com.example.springbootwebtutuorial.reposiroties.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    public EmployeeDTO findById(Long employeeId) {

        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).orElse(null);
        EmployeeDTO employeeDTO = mapper.map(employeeEntity, EmployeeDTO.class);
        return employeeDTO;
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities =employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOS = employeeEntities
                .stream()
                .map(employeeEntity -> mapper.map(employeeEntity,EmployeeDTO.class))
                .collect(Collectors.toList());
        return employeeDTOS;
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
        EmployeeEntity toSaveEntity = mapper.map(inputEmployee,EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(toSaveEntity);
        EmployeeDTO employeeDTO = mapper.map(savedEmployeeEntity,EmployeeDTO.class);

        return employeeDTO;
    }
}
