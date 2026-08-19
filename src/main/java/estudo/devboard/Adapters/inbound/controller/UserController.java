package estudo.devboard.Adapters.inbound.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import estudo.devboard.Application.service.UserService;
import estudo.devboard.domain.user.User;
import estudo.devboard.domain.user.DTO.UserCreatedDTO;
import estudo.devboard.domain.user.DTO.UserResponseDTO;
import estudo.devboard.domain.user.DTO.UserUpdateDTO;
import estudo.devboard.utils.mapper.UserMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> listarUsuarios() {
        List<UserResponseDTO> usuarios = userService.listarUsuarios()
                .stream()
                .map(userMapper::toResponse)
                .toList();

        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> buscarUsuarioPorId(@PathVariable UUID id) {
        return ResponseEntity.of(
                userService.buscarUsuarioPorId(id)
                        .map(userMapper::toResponse)
        );
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> cadastrarUsuario(
            @Valid @RequestBody UserCreatedDTO dto) {

        User user = userMapper.toEntity(dto);
        User usuarioSalvo = userService.cadastrarUsuario(user);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userMapper.toResponse(usuarioSalvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> atualizarUsuario(
            @PathVariable UUID id,
            @Valid @RequestBody UserUpdateDTO dto) {

        Optional<User> resultado = userService.buscarUsuarioPorId(id);

        if (resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }   

        User user = resultado.get();
        userMapper.updateEntity(user, dto);
        User usuarioAtualizado = userService.atualizarUsuario(user);

        return ResponseEntity.ok(userMapper.toResponse(usuarioAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable UUID id) {
        if (userService.buscarUsuarioPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        userService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
