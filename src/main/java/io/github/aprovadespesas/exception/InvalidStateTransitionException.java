package io.github.aprovadespesas.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 *  Http Status 422 Unprocessable Entity
 */
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
@Getter
public class InvalidStateTransitionException extends RuntimeException{

    private final List<String> messages;

    public InvalidStateTransitionException(String messges){
        super(messges);
        this.messages = List.of(messges);
    }

    public InvalidStateTransitionException(List<String> messages){
        super(messages.toString());
        this.messages = messages;
    }

}
