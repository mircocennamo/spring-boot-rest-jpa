package com.avanade.exception;

public class EntityNotFoundException extends RuntimeException {

	public EntityNotFoundException(Long id) {
		super("entity not find with id: " + id);
	}
}
