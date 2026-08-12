package estudo.devboard.DTOs;

import java.util.UUID;

import jakarta.validation.constraints.Size;

public record ProjetosUpdateDTO(
    @Size(max = 100) String nome,
    @Size(max = 4000) String descricao,
    UUID organizacaoId
) {
}
