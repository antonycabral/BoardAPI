package estudo.devboard.domain.user.DTO;

import estudo.devboard.domain.user.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record UserUpdateDTO(
    @Size(max = 100) String nome,
    @Email @Size(max = 150) String email,
    Role role
) {
}
