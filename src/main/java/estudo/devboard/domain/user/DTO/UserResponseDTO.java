package estudo.devboard.domain.user.DTO;

import java.util.UUID;

import estudo.devboard.domain.user.enums.Role;

public record UserResponseDTO(
    UUID id,
    String nome,
    String email,
    Role role
) {
}
