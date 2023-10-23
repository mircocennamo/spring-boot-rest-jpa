package com.avanade.controller;

import com.avanade.exception.StudentNotFoundException;
import com.avanade.model.Student;
import com.avanade.repository.StudentJpaRepository;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("/student/{id}")
	Student id(@PathVariable Long id) {

		return repository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException(id));
	}

	@PostMapping("/newstudent")
	Student newEmployee(@RequestBody Student newStudent) {

		return repository.save(newStudent);
	}

}
