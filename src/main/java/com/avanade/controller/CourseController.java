package com.avanade.controller;

import com.avanade.model.Course;
import com.avanade.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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


	@Operation(summary = "Get a Course by its id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Found the course",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = Course.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid id supplied",
					content = @Content),
			@ApiResponse(responseCode = "404", description = "Course not found",
					content = @Content) })
	@GetMapping("/course/{id}")
	Course id(@PathVariable Long id) {
		return courseService.findById(id);
	}

	@PostMapping("/course/new")
	public Course create(@Valid @RequestBody Course course) {
		return courseService.save(course);

	}

}
