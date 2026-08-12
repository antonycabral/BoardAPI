package estudo.devboard.DTOs;

import java.time.LocalDate;
import java.util.UUID;

import estudo.devboard.utils.Enum.TaskPrioridade;
import estudo.devboard.utils.Enum.TaskStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TaskCreatedDTO(
    @NotBlank @Size(max = 100) String titulo,
    @Size(max = 4000) String descricao,
    @NotNull TaskStatus status,
    @NotNull TaskPrioridade prioridade,
    @FutureOrPresent LocalDate dueDate,
    @NotNull UUID projetoId,
    @NotNull UUID responsavelUserId
) {}
