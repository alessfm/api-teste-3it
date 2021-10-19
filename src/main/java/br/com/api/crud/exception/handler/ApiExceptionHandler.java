package br.com.api.crud.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException exception) {
		return buildResponseEntity(HttpStatus.NOT_FOUND, exception.getMessage(),
				Collections.singletonList(exception.getMessage()));
	}

	@ExceptionHandler(EntityExistsException.class)
	public ResponseEntity<Object> handleEntityExistsException(EntityExistsException exception) {
		return buildResponseEntity(HttpStatus.BAD_REQUEST, exception.getMessage(),
				Collections.singletonList(exception.getMessage()));
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> errors = new ArrayList<>();
		exception.getBindingResult().getFieldErrors().forEach(fieldError -> errors
				.add("Campo " + fieldError.getField().toUpperCase() + " " + fieldError.getDefaultMessage()));
		exception.getBindingResult().getGlobalErrors().forEach(globalErrors -> errors
				.add("Objeto " + globalErrors.getObjectName() + " " + globalErrors.getDefaultMessage()));

		return buildResponseEntity(HttpStatus.BAD_REQUEST, "Os argumentos inseridos falharam na validação", errors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return buildResponseEntity(HttpStatus.BAD_REQUEST, "Corpo da requisição inválida",
				Collections.singletonList(exception.getLocalizedMessage()));
	}

	private ResponseEntity<Object> buildResponseEntity(HttpStatus httpStatus, String message, List<String> errors) {

		ApiError apiError = new ApiError(httpStatus.value(), message, LocalDateTime.now(), message, errors);

		return ResponseEntity.status(httpStatus).body(apiError);
	}
}