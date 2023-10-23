package com.avanade.exception;

public class CourseNotFoundException extends RuntimeException {

	public CourseNotFoundException(Long id) {
		super("course not find with id: " + id);
	}
}
