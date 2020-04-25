package com.queuing.kafka.exceptionhandling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidConsumerException extends InvalidEntityException {
	public InvalidConsumerException() {
		super();
	}

	public InvalidConsumerException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidConsumerException(String message) {
		super(message);
	}

	public InvalidConsumerException(Throwable cause) {
		super(cause);
	}
}