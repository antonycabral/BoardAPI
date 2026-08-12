package estudo.devboard.mapper;

import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import estudo.devboard.DTOs.TaskCreatedDTO;
import estudo.devboard.DTOs.TaskResponseDTO;
import estudo.devboard.DTOs.TaskUpdateDTO;
import estudo.devboard.model.Projetos;
import estudo.devboard.model.Task;
import estudo.devboard.model.User;

@Component
public class TaskMapper {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Task toEntity(TaskCreatedDTO dto, Projetos projeto, User responsavelUser) {
        Task task = new Task();
        task.setTitulo(dto.titulo());
        task.setDescricao(dto.descricao());
        task.setStatus(dto.status());
        task.setPrioridade(dto.prioridade());
        task.setDueDate(dto.dueDate());
        task.setProjeto(projeto);
        task.setResponsavelUser(responsavelUser);
        return task;
    }

    public void updateEntity(Task task, TaskUpdateDTO dto) {
        if (dto.titulo() != null) {
            task.setTitulo(dto.titulo());
        }
        if (dto.descricao() != null) {
            task.setDescricao(dto.descricao());
        }
        if (dto.status() != null) {
            task.setStatus(dto.status());
        }
        if (dto.prioridade() != null) {
            task.setPrioridade(dto.prioridade());
        }
        if (dto.dueDate() != null) {
            task.setDueDate(dto.dueDate());
        }
    }

    public TaskResponseDTO toResponse(Task task) {
        return new TaskResponseDTO(
            task.getTitulo(),
            task.getDescricao(),
            task.getStatus() != null ? task.getStatus().name() : null,
            task.getPrioridade() != null ? task.getPrioridade().name() : null,
            task.getDueDate() != null ? task.getDueDate().format(DATE_FORMAT) : null,
            task.getProjeto() != null ? task.getProjeto().getId().toString() : null,
            task.getResponsavelUser() != null ? task.getResponsavelUser().getId().toString() : null
        );
    }
}
