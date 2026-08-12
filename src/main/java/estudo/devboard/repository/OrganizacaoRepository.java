package estudo.devboard.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import estudo.devboard.model.Organizacao;

public interface OrganizacaoRepository extends JpaRepository<Organizacao, UUID> {

}
