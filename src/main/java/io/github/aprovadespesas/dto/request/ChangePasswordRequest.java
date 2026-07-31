package io.github.aprovadespesas.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ChangePasswordRequest(

        @NotBlank(message = "A senha atual deve ser informada.")
        @Size(min = 16, max = 100, message = "A Senha deve ter no mínimo 16 caracteres e no máximo 100.")
        String currentPassword,

        @NotBlank(message = "A Senha deve ser informada.")
        @Size(min = 16, max = 100, message = "A Senha deve ter no mínimo 16 caracteres e no máximo 100.")
        String newPassword,

        @NotBlank(message = "A Senha deve ser informada.")
        @Size(min = 16, max = 100, message = "A Senha deve ter no mínimo 16 caracteres e no máximo 100.")
        String confirmPassword
) {
}
