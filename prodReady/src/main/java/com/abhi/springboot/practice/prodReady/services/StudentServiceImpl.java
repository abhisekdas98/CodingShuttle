package com.abhi.springboot.practice.prodReady.services;

import com.abhi.springboot.practice.prodReady.Exceptions.NoResourceFoundException;
import com.abhi.springboot.practice.prodReady.Exceptions.StudentAlreadyPresentException;
import com.abhi.springboot.practice.prodReady.dtos.StudentDto;
import com.abhi.springboot.practice.prodReady.entity.StudentEntity;
import com.abhi.springboot.practice.prodReady.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final ModelMapper mapper;
    private final StudentRepository studentRepository;

    @Override
    public ResponseEntity<StudentEntity> createStudent(StudentDto studentDto) {

        Long id = studentDto.getStudentId();

        StudentEntity studentEntity = studentRepository.findById(id).orElse(null);

        if (Objects.nonNull(studentEntity)) {
            throw new StudentAlreadyPresentException("Student is already present with given ID");
        } else {
            studentEntity = studentRepository.save(mapper.map(studentDto, StudentEntity.class));

        }


        return ResponseEntity.ok(studentEntity);
    }

    @Override
    public ResponseEntity<List<StudentEntity>> getAllStudents() {

        return ResponseEntity.ok(studentRepository.findAll());
    }

    @Override
    public ResponseEntity<StudentEntity> getStudentWithId(long id) {
        StudentEntity studentEntity = studentRepository.getReferenceById(id);

        if (Objects.isNull(studentEntity)) {
            throw new NoResourceFoundException("No Student found for the given ID : " + id);
        }

        return ResponseEntity.ok(studentEntity);
    }


}
