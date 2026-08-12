package estudo.devboard.DTOs;

public record TaskResponseDTO(
    String titulo,
    String descricao,
    String status,
    String prioridade,
    String dueDate,
    String projetoId,
    String responsavelUserId
) {
}


