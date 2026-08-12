package estudo.devboard.DTOs;

import java.util.UUID;

public record OrganizacaoResponseDTO(
    UUID id,
    String nome,
    String codigo
) {
}
