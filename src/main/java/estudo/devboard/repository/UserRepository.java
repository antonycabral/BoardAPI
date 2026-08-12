package estudo.devboard.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import estudo.devboard.model.User;

public interface UserRepository extends JpaRepository<User, UUID>{

}
