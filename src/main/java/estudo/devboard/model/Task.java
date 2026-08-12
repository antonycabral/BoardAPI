package estudo.devboard.model;
    
import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import estudo.devboard.utils.Enum.TaskPrioridade;
import estudo.devboard.utils.Enum.TaskStatus;
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
    @Column(nullable = false, length = 100)
    private String Titulo;

    @Column(columnDefinition = "TEXT")
    private String Descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus Status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskPrioridade Prioridade;

    @Column(name = "due_date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "projeto_id", nullable = false)
    private Projetos projeto;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "responsavel_user_id", nullable = false)
    private User responsavelUser;
}
