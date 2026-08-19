package estudo.devboard.Application.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import estudo.devboard.Adapters.outbound.repository.UserRepository;
import estudo.devboard.domain.user.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //listar usuarios
    public List<User> listarUsuarios() {
        return userRepository.findAll();
    }

    //buscar usuario por id
    public Optional<User> buscarUsuarioPorId(UUID id){
        return userRepository.findById(id);
    }

    //salvar usuario
    public User cadastrarUsuario(User user){
        return userRepository.save(user);
    }

    //atualizar usuario
    public User atualizarUsuario(User user){
        return userRepository.save(user);
    }

    //deletar usuario
    public void deletarUsuario(UUID id){
        userRepository.deleteById(id);
    }

}

