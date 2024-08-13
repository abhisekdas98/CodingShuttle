package com.abhi.springboot.practice.prodReady.repositories;

import com.abhi.springboot.practice.prodReady.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
}
