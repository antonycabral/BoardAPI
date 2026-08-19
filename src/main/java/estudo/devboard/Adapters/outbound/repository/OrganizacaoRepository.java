package estudo.devboard.Adapters.outbound.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import estudo.devboard.domain.organizacao.Organizacao;

public interface OrganizacaoRepository extends JpaRepository<Organizacao, UUID> {

}
