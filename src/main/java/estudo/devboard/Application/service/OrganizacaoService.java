package estudo.devboard.Application.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import estudo.devboard.Adapters.outbound.repository.OrganizacaoRepository;
import estudo.devboard.domain.organizacao.Organizacao;
import estudo.devboard.domain.organizacao.OrganizacaoCreatedDTO;
import estudo.devboard.utils.mapper.OrganizacaoMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrganizacaoService {

    private final OrganizacaoRepository organizacaoRepository;
    private final OrganizacaoMapper organizacaoMapper;

    //listar organizações
    public List<Organizacao> ListarOrganizacao(){
        return organizacaoRepository.findAll();
    }

    //salvar organização
    public Organizacao salvarOrganizacao(Organizacao organizacao){
        return organizacaoRepository.save(organizacao);
    }

    //listar organização por id
    public Optional<Organizacao> buscarOrganizacaoPorId(UUID id){
        return organizacaoRepository.findById(id);
    }

    //atualizar organização
    public Organizacao atualizarOrganizacao(UUID id, OrganizacaoCreatedDTO dto){
        Organizacao organizacaoExiste = organizacaoRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Organização não encontrada:" + id));

            organizacaoMapper.updateEntity(organizacaoExiste, dto);
            return organizacaoRepository.save(organizacaoExiste);
    }

    //deletar organização
    public void deletarOrganizacao(UUID id){
        Organizacao organizacaoExiste = organizacaoRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Organização não encontrada:" + id));

            organizacaoRepository.delete(organizacaoExiste);
    }

}
