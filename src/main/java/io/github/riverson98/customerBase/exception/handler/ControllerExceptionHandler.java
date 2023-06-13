package io.github.riverson98.customerBase.exception.handler;

import io.github.riverson98.customerBase.exception.ErrorCustomResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Iterator;
import java.util.List;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorCustomResponse> argumentNotValidHandler(MethodArgumentNotValidException notValidException){
        log.error("stackTrace: {} - payloadRequest: {}", processFieldError(notValidException.getFieldErrors()),
                notValidException.getBindingResult().getTarget());
        return ResponseEntity.badRequest()
                .body(
                    new ErrorCustomResponse("Invalid request", processFieldError(notValidException.getFieldErrors()))
                );
    }

    private String processFieldError(List<FieldError> fieldErrors) {
        StringBuilder sb = new StringBuilder();
        Iterator<FieldError> iterator = fieldErrors.iterator();
        sb.append("fields with error: ");
        while (iterator.hasNext()){
            FieldError error = iterator.next();
            sb.append(error.getDefaultMessage());
            if (iterator.hasNext()){
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
