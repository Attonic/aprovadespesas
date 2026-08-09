package io.github.aprovadespesas.exception;

import jdk.dynalink.linker.LinkerServices;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

//400
@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCredentialException extends RuntimeException{

    private final List<String> messages;

    public InvalidCredentialException(List<String> messages) {
        super(messages.toString());
        this.messages = messages;
    }

    public InvalidCredentialException(String message) {
        super(message);
        this.messages = List.of(message);
    }


}
