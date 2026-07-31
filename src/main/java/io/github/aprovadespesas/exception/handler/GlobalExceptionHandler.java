package io.github.aprovadespesas.exception.handler;

import io.github.aprovadespesas.exception.ConflictException;
import io.github.aprovadespesas.exception.InvalidStateTransitionException;
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
