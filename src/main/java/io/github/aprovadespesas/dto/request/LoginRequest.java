package io.github.aprovadespesas.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public record LoginRequest(
        @Email(message = "Email deve ser um email valido.")
        @NotBlank(message = "O Email é obrigatório.")
        @Size(max = 150, message = "Email deve ter no máximo 150 caracteres.")
        String email,

        @NotBlank(message = "Senha é obrigatória")
        @Size(min = 6, max = 100, message = "Senha deve ter entre 6 a 20 caracteres.")
        String password
) {
}
