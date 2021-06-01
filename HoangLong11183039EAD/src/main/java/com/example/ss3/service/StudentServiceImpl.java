package com.example.ss3.service;

import com.example.ss3.entity.StudentEntity;
import com.example.ss3.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    int pageSize = 5;
    @Autowired
    StudentRepo studentRepo;

    @Override
    public List<StudentEntity> getAllStudent() {

        return studentRepo.findAll();
    }

    @Override
    public List<StudentEntity> getAllStudent(String name, Pageable pageable) {
        return studentRepo.findAllByName(name, pageable);
    }

    @Override
    public StudentEntity addStudent(StudentEntity p) {
        StudentEntity student = studentRepo.save(p);
        return student;
    }

    @Override
    public void deleteStudent(Integer productid) {
        StudentEntity p = studentRepo.findById(productid).get();
        studentRepo.delete(p);
    }

    @Override
    public void updateStudent(Integer id, String name, String birth, String gender, String studentid, String phone, String email, String nativeland) {
       StudentEntity p = studentRepo.findById(id).get();
        if(!StringUtils.isEmpty(name))
        {
            p.setName(name);
        }
        if(!StringUtils.isEmpty(birth))
        {
            p.setBirth(birth);
        }
        if(!StringUtils.isEmpty(gender))
        {
            p.setGender(gender);
        }
        if(!StringUtils.isEmpty(email))
        {
            p.setEmail(email);
        }
        if(!StringUtils.isEmpty(phone))
        {
            p.setPhone(phone);
        }
        if(!StringUtils.isEmpty(studentid))
        {
            p.setStudentid(studentid);
        }
        if(!StringUtils.isEmpty(nativeland))
        {
            p.setName(nativeland);
        }

       studentRepo.save(p);
    }

    @Override
    public Page<StudentEntity> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.studentRepo.findAll(pageable);
    }
//    int pageNumber = 1;
//    Pageable pageable = PageRequest.of(pageNumber, pageSize);
//    Page<ProductEntity> page = productRepo.findAll(pageable);


}
