package io.github.aprovadespesas.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

//409
@Getter
@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException{

    private final List<String> messages;

    public ConflictException (List<String> messages){
        super(messages.toString());
        this.messages = messages;
    }

    public ConflictException(String message) {
        super(message);
        this.messages = List.of(message);
    }

}
