package io.github.aprovadespesas.dto.response;

public record AuthResponse(

        String accessToken,
        String tokenType,
        Long expiresIn

) {


}
