package estudo.devboard.utils.mapper;

import org.springframework.stereotype.Component;

import estudo.devboard.domain.organizacao.Organizacao;
import estudo.devboard.domain.organizacao.OrganizacaoCreatedDTO;
import estudo.devboard.domain.organizacao.OrganizacaoResponseDTO;

@Component
public class OrganizacaoMapper {

    public Organizacao toEntity(OrganizacaoCreatedDTO dto) {
        Organizacao organizacao = new Organizacao();
        organizacao.setNome(dto.nome());
        organizacao.setCodigo(dto.codigo());
        return organizacao;
    }

    public void updateEntity(Organizacao organizacao, OrganizacaoCreatedDTO dto) {
        if (dto.nome() != null) {
            organizacao.setNome(dto.nome());
        }
        if (dto.codigo() != null) {
            organizacao.setCodigo(dto.codigo());
        }
    }

    public OrganizacaoResponseDTO toResponse(Organizacao organizacao) {
        return new OrganizacaoResponseDTO(
            organizacao.getId(),
            organizacao.getNome(),
            organizacao.getCodigo()
        );
    }
}
