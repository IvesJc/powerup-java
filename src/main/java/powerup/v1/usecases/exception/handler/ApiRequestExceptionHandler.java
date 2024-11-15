package powerup.v1.usecases.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import powerup.v1.infra.JsonExceptionConfig;
import powerup.v1.usecases.exception.IdNotFoundException;

@ControllerAdvice
public class ApiRequestExceptionHandler {


    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<JsonExceptionConfig> idNotFoundExceptionHandler(IdNotFoundException exception){

        JsonExceptionConfig exceptionConfig = new JsonExceptionConfig(
                HttpStatus.NOT_FOUND,
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionConfig);
    }
}
