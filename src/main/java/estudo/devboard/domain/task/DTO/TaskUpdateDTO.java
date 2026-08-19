package estudo.devboard.domain.task.DTO;

import java.time.LocalDate;

import estudo.devboard.domain.task.Enum.TaskPrioridade;
import estudo.devboard.domain.task.Enum.TaskStatus;
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
