package com.example.ss3.controller;

import com.example.ss3.dto.StudentDto;
import com.example.ss3.entity.StudentEntity;
import com.example.ss3.model.BaseResponse;
import com.example.ss3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping()
    public ResponseEntity getAllStudent(@RequestParam(value = "name", required = false, defaultValue = "Nokia cucgach") String name,
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                        @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit) {
        BaseResponse res = new BaseResponse();
        res.data = studentService.getAllStudent(name, PageRequest.of(page, limit));
        return ResponseEntity.ok(res);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody StudentDto studentDto) {
        StudentEntity entity = new StudentEntity();
//        entity.setName(studentDto.getName());
//        entity.setPrice(studentDto.getPrice());

        return null;
    }

}
