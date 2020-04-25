package com.queuing.kafka.exceptionhandling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidTopicException extends InvalidEntityException {
	public InvalidTopicException() {
		super();
	}

	public InvalidTopicException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidTopicException(String message) {
		super(message);
	}

	public InvalidTopicException(Throwable cause) {
		super(cause);
	}
}