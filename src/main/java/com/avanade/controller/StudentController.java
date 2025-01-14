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
    ResponseEntity<List<StudentCorsesVm>> all() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/student/{id}")
    ResponseEntity<StudentCorsesVm>  id(@PathVariable Long id) {
        return  ResponseEntity.ok(studentService.findById(id));
    }

    @PostMapping("/newstudent")
    ResponseEntity<StudentCorsesVm> newEmployee(@Valid @RequestBody Student newStudent) {
        return ResponseEntity.ok(studentService.save(newStudent));
    }



}
