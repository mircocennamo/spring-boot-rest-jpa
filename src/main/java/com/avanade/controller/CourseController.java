package com.avanade.controller;

import com.avanade.model.Course;
import com.avanade.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("avanade")
class CourseController {

	@Autowired
	CourseService courseService;


	@GetMapping("/courses")
	List<Course> all() {
		return  courseService.findAll();
	}

	@GetMapping("/course/{id}")
	Course id(@PathVariable Long id) {
		return courseService.findById(id);
	}

	@PostMapping("/course/new")
	public Course create(@Valid @RequestBody Course course) {
		return courseService.save(course);

	}

}
