package io.github.aprovadespesas.dto.response;

import lombok.Builder;

@Builder
public record AuthResponse(

        String accessToken,
        String tokenType,
        Long expiresIn

) {


}
