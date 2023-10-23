package com.avanade.controller;

import com.avanade.exception.EntityNotFoundException;
import com.avanade.model.Course;
import com.avanade.model.Student;
import com.avanade.repository.CourseJpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("avanade")
class CourseController {

	private final CourseJpaRepository repository;

	CourseController(CourseJpaRepository repository) {
		this.repository = repository;
	}


	@GetMapping("/courses")
	List<Course> all() {
		return  repository.findAll();
	}

	@GetMapping("/course/{id}")
	Course id(@PathVariable Long id) {

		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(id));
	}

}
