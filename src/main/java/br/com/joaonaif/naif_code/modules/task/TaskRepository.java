package br.com.joaonaif.naif_code.modules.task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {
    Optional<TaskEntity> findByName(String name);
}
