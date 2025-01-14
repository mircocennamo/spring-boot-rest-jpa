package com.avanade.controller;


import com.avanade.model.Course;
import com.avanade.service.CourseService;
import com.avanade.viewmodel.CorseVm;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("avanade")
class CourseController {

	@Autowired
	CourseService courseService;



	private static final Logger log = LoggerFactory.getLogger(CourseController.class);

	@GetMapping("/courses")
	ResponseEntity<List<CorseVm>> all() {
		log.info("API Request to get all courses");
		return  ResponseEntity.ok(courseService.findAll());
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
	ResponseEntity<CorseVm> id(@PathVariable Long id) {
		log.info("API Request to get course by id");
		
		return ResponseEntity.ok(courseService.findById(id));
	}

	@PostMapping("/course/new")
	public ResponseEntity<CorseVm> create(@Valid @RequestBody Course course) {
		return ResponseEntity.ok(courseService.save(course));

	}

	@PutMapping("/course/update/{id}")
	public ResponseEntity<CorseVm> update(@PathVariable Long id, @Valid @RequestBody Course course) {
		return ResponseEntity.ok(courseService.update(id, course));
	}

	@DeleteMapping("/course/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		courseService.deleteById(id);
		return ResponseEntity.ok("Course deleted successfully");
	}
}
