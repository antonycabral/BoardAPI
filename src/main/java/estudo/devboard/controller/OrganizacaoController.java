package estudo.devboard.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import estudo.devboard.DTOs.OrganizacaoCreatedDTO;
import estudo.devboard.DTOs.OrganizacaoResponseDTO;
import estudo.devboard.mapper.OrganizacaoMapper;
import estudo.devboard.model.Organizacao;
import estudo.devboard.service.OrganizacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/organizacao")
@RequiredArgsConstructor
public class OrganizacaoController {

    private final OrganizacaoService organizacaoService;
    private final OrganizacaoMapper organizacaoMapper;

    //listar todas as organizações
    @GetMapping
    public ResponseEntity<List<OrganizacaoResponseDTO>> listarOrganizacoes(){
        List<OrganizacaoResponseDTO> organizacoes = organizacaoService.ListarOrganizacao()
                .stream()
                .map(organizacaoMapper::toResponse)
                .toList();

        return ResponseEntity.ok(organizacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizacaoResponseDTO> buscarOrganizacaoPorID(UUID id){
        return ResponseEntity.of(
            organizacaoService.buscarOrganizacaoPorId(id)
                .map(organizacaoMapper::toResponse)
        );
    }

    @PostMapping
    public ResponseEntity<OrganizacaoResponseDTO> cadastrarOrganizacao(
        @Valid @RequestBody OrganizacaoCreatedDTO dto) {

            Organizacao organizacao = organizacaoMapper.toEntity(dto);
            Organizacao organizacaoSalva = organizacaoService.salvarOrganizacao(organizacao);

            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(organizacaoMapper.toResponse(organizacaoSalva));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizacaoResponseDTO> atualizarOrganizacao(
        @PathVariable UUID id,
        @Valid @RequestBody OrganizacaoCreatedDTO dto) {

        Organizacao organizacaoAtualizada = organizacaoService.atualizarOrganizacao(id, dto);
        return ResponseEntity.ok(organizacaoMapper.toResponse(organizacaoAtualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarOrganizacao(@PathVariable UUID id){
        organizacaoService.deletarOrganizacao(id);
        return ResponseEntity.noContent().build();
    }

}
