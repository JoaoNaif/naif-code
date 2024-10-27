package br.com.joaonaif.naif_code.modules.task.useCases;

import br.com.joaonaif.naif_code.exceptions.TaskAlreadyExist;
import br.com.joaonaif.naif_code.modules.task.TaskEntity;
import br.com.joaonaif.naif_code.modules.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskUseCase {

    @Autowired
    private TaskRepository taskRepository;

    public TaskEntity execute(TaskEntity taskEntity) {
        this.taskRepository.findByName(taskEntity.getName())
                .ifPresent((user) -> {
                    throw new TaskAlreadyExist();
                });

        return this.taskRepository.save(taskEntity);
    }
}
