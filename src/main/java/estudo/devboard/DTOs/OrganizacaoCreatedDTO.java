package estudo.devboard.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record OrganizacaoCreatedDTO(
    @NotBlank @Size(max = 100) String nome,
    @NotBlank @Size(max = 80) String codigo
) {
}
