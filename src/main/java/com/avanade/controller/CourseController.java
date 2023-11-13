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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("avanade")
class CourseController {

	@Autowired
	CourseService courseService;


	@GetMapping("/courses")
	ResponseEntity<List<CorseVm>> all() {
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
		return ResponseEntity.ok(courseService.findById(id));
	}

	@PostMapping("/course/new")
	public ResponseEntity<CorseVm> create(@Valid @RequestBody Course course) {
		return ResponseEntity.ok(courseService.save(course));

	}

}
