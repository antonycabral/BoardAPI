package estudo.devboard.domain.organizacao;

import jakarta.validation.constraints.Size;

public record OrganizacaoUpdateDTO(
    @Size(max = 100) String nome,
    @Size(max = 80) String codigo
) {
}
