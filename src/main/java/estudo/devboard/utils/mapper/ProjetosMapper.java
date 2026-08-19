package estudo.devboard.utils.mapper;

import org.springframework.stereotype.Component;

import estudo.devboard.domain.organizacao.Organizacao;
import estudo.devboard.domain.projeto.Projetos;
import estudo.devboard.domain.projeto.ProjetosCreatedDTO;
import estudo.devboard.domain.projeto.ProjetosResponseDTO;
import estudo.devboard.domain.projeto.ProjetosUpdateDTO;

@Component
public class ProjetosMapper {

    public Projetos toEntity(ProjetosCreatedDTO dto, Organizacao organizacao) {
        Projetos projeto = new Projetos();
        projeto.setNome(dto.nome());
        projeto.setDescricao(dto.descricao());
        projeto.setOrganizacao(organizacao);
        return projeto;
    }

    public void updateEntity(Projetos projeto, ProjetosUpdateDTO dto, Organizacao organizacao) {
        if (dto.nome() != null) {
            projeto.setNome(dto.nome());
        }
        if (dto.descricao() != null) {
            projeto.setDescricao(dto.descricao());
        }
        if (organizacao != null) {
            projeto.setOrganizacao(organizacao);
        }
    }

    public ProjetosResponseDTO toResponse(Projetos projeto) {
        return new ProjetosResponseDTO(
            projeto.getId(),
            projeto.getNome(),
            projeto.getDescricao(),
            projeto.getOrganizacao() != null ? projeto.getOrganizacao().getId() : null
        );
    }
}
