package com.avanade.controller;

import com.avanade.model.Student;
import com.avanade.service.StudentService;
import com.avanade.viewmodel.StudentCorsesVm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("avanade")
class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    List<Student> all() {
        return studentService.findAll();
    }

    @GetMapping("/student/{id}")
    ResponseEntity<StudentCorsesVm>  id(@PathVariable Long id) {
        return  ResponseEntity.ok(studentService.findById(id));
    }

    @PostMapping("/newstudent")
    Student newEmployee(@Valid @RequestBody Student newStudent) {
        return studentService.save(newStudent);
    }

}
