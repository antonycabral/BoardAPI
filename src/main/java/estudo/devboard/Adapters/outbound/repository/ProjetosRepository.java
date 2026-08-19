package estudo.devboard.Adapters.outbound.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import estudo.devboard.domain.projeto.Projetos;

public interface ProjetosRepository extends JpaRepository<Projetos, UUID> {

}
