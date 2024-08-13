package com.abhi.springboot.practice.prodReady.controllers;

import com.abhi.springboot.practice.prodReady.dtos.StudentDto;
import com.abhi.springboot.practice.prodReady.entity.StudentEntity;
import com.abhi.springboot.practice.prodReady.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping(path = "/create",consumes = "application/json")
    public ResponseEntity<StudentEntity> createStudent(@RequestBody StudentDto studentDto){
        return studentService.createStudent(studentDto);
    }

    @GetMapping(path = "/get/{studentId}")
    public ResponseEntity<StudentEntity> getStudentByID(@PathVariable(name = "studentId") Long id){
        return studentService.getStudentWithId(id);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<StudentEntity>> getAllStudents(){
        return studentService.getAllStudents();
    }
}
