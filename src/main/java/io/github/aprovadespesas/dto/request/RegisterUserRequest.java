package io.github.aprovadespesas.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.aprovadespesas.entity.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record RegisterUserRequest(

        @NotBlank(message = "O nome é obrigatório.")
        @Size(max = 130, message = "Nome deve ter no máximo 130 caracteres.")
        String name,

        @NotBlank(message = "O Email é obrigatório.")
        @Email(message = "O Email deve ser um email valido.")
        @Size(max = 150, message = "Email deve ter no máximo 150 caracteres.")
        String email,

        @NotBlank(message = "A Senha é obrigatória.")
        @Size(min = 6, max = 100, message = "A Senha deve ter entre 6 a 16 caracteres.")
        String password,

        @NotNull
        Role role,

        Long departmentId

) {
}
