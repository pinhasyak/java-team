package com.pi.javateam.services;

import com.pi.javateam.domain.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Thrown when there is trouble persisting the {@link com.pi.javateam.domain.Customer customer}.
 *
 * 
 */
@ResponseStatus (HttpStatus.METHOD_NOT_ALLOWED)
public class CustomerWriteException extends CustomerException {

	private static final long serialVersionUID = 1L;

	public CustomerWriteException(Customer customer, Throwable cause) {
		super(customer, cause);
	}

	public CustomerWriteException(long id, Throwable cause) {
		super(id, cause);
	}

	public CustomerWriteException(Customer user) {
		super(user);
	}

	public CustomerWriteException(long id) {
		super(id);
	}

}
