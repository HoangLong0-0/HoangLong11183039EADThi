package com.example.ss3.repository;

import com.example.ss3.entity.StudentEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<StudentEntity, Integer> {

    List<StudentEntity> findAllByName(String name, Pageable pageable);
}
