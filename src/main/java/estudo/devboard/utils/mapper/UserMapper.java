package estudo.devboard.utils.mapper;

import org.springframework.stereotype.Component;

import estudo.devboard.domain.user.User;
import estudo.devboard.domain.user.DTO.UserCreatedDTO;
import estudo.devboard.domain.user.DTO.UserResponseDTO;
import estudo.devboard.domain.user.DTO.UserUpdateDTO;

@Component
public class UserMapper {

    public User toEntity(UserCreatedDTO dto) {
        User user = new User();
        user.setNome(dto.nome());
        user.setEmail(dto.email());
        user.setRole(dto.role());
        return user;
    }

    public void updateEntity(User user, UserUpdateDTO dto) {
        if (dto.nome() != null) {
            user.setNome(dto.nome());
        }
        if (dto.email() != null) {
            user.setEmail(dto.email());
        }
        if (dto.role() != null) {
            user.setRole(dto.role());
        }
    }

    public UserResponseDTO toResponse(User user) {
        return new UserResponseDTO(
            user.getId(),
            user.getNome(),
            user.getEmail(),
            user.getRole()
        );
    }
}
