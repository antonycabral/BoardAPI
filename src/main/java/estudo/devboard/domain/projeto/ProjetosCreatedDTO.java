package estudo.devboard.domain.projeto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProjetosCreatedDTO(
    @NotBlank @Size(max = 100) String nome,
    @Size(max = 4000) String descricao,
    @NotNull UUID organizacaoId
) {
}
