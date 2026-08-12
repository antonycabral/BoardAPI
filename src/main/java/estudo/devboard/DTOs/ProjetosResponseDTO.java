package estudo.devboard.DTOs;

import java.util.UUID;

public record ProjetosResponseDTO(
    UUID id,
    String nome,
    String descricao,
    UUID organizacaoId
) {
}
