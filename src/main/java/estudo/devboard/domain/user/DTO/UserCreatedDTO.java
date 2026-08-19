package estudo.devboard.domain.user.DTO;

import estudo.devboard.domain.user.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserCreatedDTO(
    @NotBlank @Size(max = 100) String nome,
    @NotBlank @Email @Size(max = 150) String email,
    @NotNull Role role
) {
}
