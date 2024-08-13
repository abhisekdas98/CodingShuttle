package com.abhi.springboot.practice.prodReady.services;

import com.abhi.springboot.practice.prodReady.dtos.StudentDto;
import com.abhi.springboot.practice.prodReady.entity.StudentEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    ResponseEntity<StudentEntity> createStudent(StudentDto studentDto);
    ResponseEntity<List<StudentEntity>> getAllStudents();
    ResponseEntity<StudentEntity> getStudentWithId(long id);

}
