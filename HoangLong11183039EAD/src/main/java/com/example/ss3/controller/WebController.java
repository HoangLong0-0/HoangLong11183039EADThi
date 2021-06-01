package com.example.ss3.controller;

import com.example.ss3.entity.StudentEntity;
import com.example.ss3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class WebController {
    @Autowired
    StudentService studentService;

    //security
    @GetMapping("/login")
    public String login() {
        return "security/login";
    }
    @GetMapping(value = "/login",params = "error")
    public String error404(){
        return "security/404";
    }
    @GetMapping("/error")
    public String error() {
        return "security/404";
    }


    @GetMapping("/")
    public String index(Model model) {
        List<StudentEntity> studentList = studentService.getAllStudent();
        model.addAttribute("studentList", studentList);


        return findPaginated(1, model);
    }
    @GetMapping("/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;

        Page<StudentEntity> page = studentService.findPaginated(pageNo, pageSize);
        List <StudentEntity> listStudents = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("studentList", listStudents);
        return "index";
    }

    @PostMapping("/create")
    public String create(Model model, @RequestParam Map<String, String> params){
        String name = params.get("name");
        String birth = params.get("birth");
        String gender = params.get("gender");
        String studentid = params.get("studentid");
        String phone = params.get("phone");
        String email = params.get("email");
        String nativeland = params.get("nativeland");

        StudentEntity p = new StudentEntity(name,birth,gender,studentid,phone,email,nativeland);
        studentService.addStudent(p);
        String result = "successfully added!";
        model.addAttribute("result",result);
        return "result";
    }

    @GetMapping("/delete")
    public String delete(Model model,  @RequestParam Map<String, String> params){
        Integer id = Integer.valueOf(params.get("deleteid"));
        studentService.deleteStudent(id);
        String result = "successfully deleted!";
        model.addAttribute("result",result);
        return "result";
    }

    @GetMapping("/update")
    public String update(Model model,  @RequestParam Map<String, String> params){
        Integer id = Integer.valueOf(params.get("updateid"));
        String name = params.get("name");
        String birth = params.get("birth");
        String gender = params.get("gender");
        String studentid = params.get("studentid");
        String phone = params.get("phone");
        String email = params.get("email");
        String nativeland = params.get("nativeland");

//        Integer quantity = Integer.valueOf(params.get("quantity"));
//        Integer category = Integer.valueOf(params.get("category"));

        studentService.updateStudent(id,name,birth,gender,studentid,phone,email,nativeland);
        String result = "successfully updated!";
        model.addAttribute("result",result);
        return "result";

    }

    Integer checknull(String paramname, Map<String, String> params ){
        String value = params.get(paramname);
        if(!value.isEmpty()){
            return  Integer.valueOf(value);
        }
        return null;
    }

}
