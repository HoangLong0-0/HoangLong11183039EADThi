package com.example.ss3.service;

import com.example.ss3.entity.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    List<StudentEntity> getAllStudent();
    List<StudentEntity> getAllStudent(String name, Pageable pageable);
    StudentEntity addStudent(StudentEntity p);
    void deleteStudent(Integer productid);
    void updateStudent(Integer id, String name, String birth, String gender, String studentid, String phone, String email, String nativeland);
    Page<StudentEntity> findPaginated(int pageNo, int pageSize);
}
