package io.github.aprovadespesas.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record DepartmentRequest(


        @NotBlank(message = "O nome do Departamento deve Ser informado.")
        @Size(max = 150, message = "Nome deve ter no máximo 250 caracteres.")
        String name,

        @NotBlank(message = "A descrição do departamento deve ser informada.")
        @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres.")
        String description

    ){
}
