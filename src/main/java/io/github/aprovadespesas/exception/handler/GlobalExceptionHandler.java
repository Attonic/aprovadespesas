package io.github.aprovadespesas.exception.handler;

import io.github.aprovadespesas.exception.ConflictException;
import io.github.aprovadespesas.exception.InvalidCredentialException;
import io.github.aprovadespesas.exception.InvalidStateTransitionException;
import io.github.aprovadespesas.exception.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class GlobalExceptionHandler {

    //422
    @ExceptionHandler(InvalidStateTransitionException.class)
    public ResponseEntity<ErrorResponse> handlerInvalidStateTransitionException(InvalidStateTransitionException e, HttpServletRequest request){
        return buildResponse(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage(), e.getMessages(), request);
    }

    //409
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorResponse> handlerConflictException(ConflictException e,  HttpServletRequest request){
        return buildResponse(HttpStatus.CONFLICT, e.getMessage(), e.getMessages(), request);
    }

    //404
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerNotFoundException(NotFoundException e,  HttpServletRequest request) {
        return buildResponse(HttpStatus.NOT_FOUND, e.getMessage(), e.getMessages(), request);
    }
    //404
    @ExceptionHandler(InvalidCredentialException.class)
    public ResponseEntity<ErrorResponse> handlerInvalidCredentialException(InvalidCredentialException e,  HttpServletRequest request){
        return buildResponse(HttpStatus.BAD_REQUEST, e.getMessage(), e.getMessages(), request);
    }

    private ResponseEntity<ErrorResponse> buildResponse(
            HttpStatus status,
            String message,
            List<String> messages,
            HttpServletRequest request
    ){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timesTamp(LocalDateTime.now())
                .status(status.value())
                .error(message)
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(status).body(errorResponse);
    }
}
