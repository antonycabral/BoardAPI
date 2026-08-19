package estudo.devboard.domain.organizacao;

import java.util.UUID;

public record OrganizacaoResponseDTO(
    UUID id,
    String nome,
    String codigo
) {
}
