package com.avanade.exception;

public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException(Long id) {
		super("student not find with id: " + id);
	}
}
