package estudo.devboard.Adapters.outbound.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import estudo.devboard.domain.user.User;

public interface UserRepository extends JpaRepository<User, UUID>{

}
