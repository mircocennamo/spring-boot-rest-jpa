package com.avanade.controller;

import com.avanade.model.Student;
import com.avanade.repository.StudentJpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("avanade")
class StudentController {

	private final StudentJpaRepository repository;

	StudentController(StudentJpaRepository repository) {
		this.repository = repository;
	}


	@GetMapping("/students")
	List<Student> all() {
		return  repository.findAll();
	}

}
