package estudo.devboard.domain.task;
    
import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import estudo.devboard.domain.projeto.Projetos;
import estudo.devboard.domain.task.Enum.TaskPrioridade;
import estudo.devboard.domain.task.Enum.TaskStatus;
import estudo.devboard.domain.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String Titulo;

    @Size(max = 1000)
    @Column(columnDefinition = "TEXT")
    private String Descricao;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TaskStatus Status;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TaskPrioridade Prioridade;

    @Column(name = "due_date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dueDate;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "projeto_id", nullable = false)
    private Projetos projeto;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "responsavel_user_id", nullable = false)
    private User responsavelUser;
}
