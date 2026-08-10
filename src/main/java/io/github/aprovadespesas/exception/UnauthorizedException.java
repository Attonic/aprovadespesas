package io.github.aprovadespesas.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Getter
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RuntimeException{

    private final List<String> messages;

    public UnauthorizedException(List<String> messages){
        super(messages.toString());
        this.messages = messages;
    }

    public UnauthorizedException(String message) {
        super(message);
        this.messages = List.of(message);
    }

}
