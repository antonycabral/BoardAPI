package estudo.devboard.DTOs;

import java.time.LocalDate;

import estudo.devboard.utils.Enum.TaskPrioridade;
import estudo.devboard.utils.Enum.TaskStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Size;

public record TaskUpdateDTO(
    @Size(max = 100) String titulo,
    @Size(max = 4000) String descricao,
    TaskStatus status,
    TaskPrioridade prioridade,
    @FutureOrPresent LocalDate dueDate
) {

}
