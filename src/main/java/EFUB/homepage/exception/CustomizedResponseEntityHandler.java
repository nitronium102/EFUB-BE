package EFUB.homepage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityHandler {

	@ExceptionHandler(DuplicateUserException.class)
	public final ResponseEntity<Object> handleDuplicatedUserException(DuplicateUserException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}

	@ExceptionHandler(NoSuchUserException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(NoSuchUserException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}

	@ExceptionHandler(NoSuchAdminException.class)
	public final ResponseEntity<Object> handleNoSuchAdminException(NoSuchAdminException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}

	@ExceptionHandler(SaveFailureException.class)
	public final ResponseEntity<Object> handleSaveFailureException(SaveFailureException e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException e) {
		Map<String, String> errors = new HashMap<>();
		e.getBindingResult().getAllErrors().forEach(
				c -> errors.put(((FieldError) c).getField(), c.getDefaultMessage()));
		return ResponseEntity.badRequest().body(errors);
	}

	@ExceptionHandler(NotPassMidException.class)
	public ResponseEntity<Map<Long, String>> handleNotPassMidExceptions(NotPassMidException e) {
		Map<Long, String> errors = new HashMap<>();
		e.getUserIds().forEach(userId -> errors.put(userId, e.getMessage()));
		return ResponseEntity.badRequest().body(errors);
	}
}
