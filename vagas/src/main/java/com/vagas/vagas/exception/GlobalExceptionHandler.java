package com.vagas.vagas.exception;
import com.vagas.vagas.dto.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailJaExisteException.class)
    public ResponseEntity<ErrorResponse> handlerEmailExiste(EmailJaExisteException emailJaExisteException){
        ErrorResponse erro = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                emailJaExisteException.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}
