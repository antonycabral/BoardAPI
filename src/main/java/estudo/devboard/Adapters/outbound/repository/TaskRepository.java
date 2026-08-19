package estudo.devboard.Adapters.outbound.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import estudo.devboard.domain.task.Task;

public interface TaskRepository extends JpaRepository<Task, UUID> {

}
