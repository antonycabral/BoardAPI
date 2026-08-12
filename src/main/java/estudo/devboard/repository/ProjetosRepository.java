package estudo.devboard.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import estudo.devboard.model.Projetos;

public interface ProjetosRepository extends JpaRepository<Projetos, UUID> {

}
