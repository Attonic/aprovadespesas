package io.github.aprovadespesas.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public record RejectExpenseRequest(

        @NotBlank(message = "A Justificativa de rejeição é obrigatória.")
        String reason

) {
}
