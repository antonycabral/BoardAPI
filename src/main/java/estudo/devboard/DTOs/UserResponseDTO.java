package estudo.devboard.DTOs;

import java.util.UUID;

import estudo.devboard.utils.Enum.Role;

public record UserResponseDTO(
    UUID id,
    String nome,
    String email,
    Role role
) {
}
