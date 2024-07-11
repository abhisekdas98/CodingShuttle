package com.example.springbootwebtutuorial.services;

import com.example.springbootwebtutuorial.dto.EmployeeDTO;
import com.example.springbootwebtutuorial.entities.EmployeeEntity;
import com.example.springbootwebtutuorial.reposiroties.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    public ResponseEntity<EmployeeDTO> findById(Long employeeId) {

        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).orElse(null);
        if(employeeEntity == null)
        {
            return ResponseEntity.notFound().build();
        }
        EmployeeDTO employeeDTO = mapper.map(employeeEntity, EmployeeDTO.class);
        return ResponseEntity.ok(employeeDTO);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOS = employeeEntities
                .stream()
                .map(employeeEntity -> mapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
        return employeeDTOS;
    }

    public ResponseEntity<EmployeeDTO> createNewEmployee(EmployeeDTO inputEmployee) {
        EmployeeEntity toSaveEntity = mapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(toSaveEntity);
        EmployeeDTO employeeDTO = mapper.map(savedEmployeeEntity, EmployeeDTO.class);

        return new ResponseEntity<>(employeeDTO, HttpStatus.CREATED);
    }

    public ResponseEntity<EmployeeDTO> updateEmployeeById(Long id, EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = mapper.map(employeeDTO, EmployeeEntity.class);
        employeeEntity.setId(id);

        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);

        EmployeeDTO savedEmployeeDto = mapper.map(savedEmployeeEntity, EmployeeDTO.class);

        return  ResponseEntity.ok(savedEmployeeDto);
    }

    public ResponseEntity<Boolean> deleteEmployeeById(Long id) {

        boolean exists = true;
        if(!employeeRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        try {
            employeeRepository.deleteById(id);
            return ResponseEntity.ok(true);
        } catch (Exception exception){
            exception.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    public EmployeeDTO updatePartialEmployeeById(Long id, Map<String, Objects> updates) {
        boolean exists = true;
        if(!employeeRepository.existsById(id)){
            return null;
        }
        try {
            EmployeeEntity employeeEntity =employeeRepository.findById(id).orElse(null);
            updates.forEach((field,value)->{
               Field fieldTobeUpdated= ReflectionUtils.findRequiredField(EmployeeEntity.class,field);
                fieldTobeUpdated.setAccessible(true);
                ReflectionUtils.setField(fieldTobeUpdated,employeeEntity,value);
            });
            return mapper.map(employeeRepository.save(employeeEntity),EmployeeDTO.class);
        } catch (Exception exception){
            exception.printStackTrace();
            return null;
        }
    }
}
