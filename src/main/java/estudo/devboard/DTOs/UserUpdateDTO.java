package estudo.devboard.DTOs;

import estudo.devboard.utils.Enum.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record UserUpdateDTO(
    @Size(max = 100) String nome,
    @Email @Size(max = 150) String email,
    Role role
) {
}
