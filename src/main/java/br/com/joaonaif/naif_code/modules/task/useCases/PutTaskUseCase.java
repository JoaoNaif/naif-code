package br.com.joaonaif.naif_code.modules.task.useCases;

import br.com.joaonaif.naif_code.exceptions.TaskAlreadyExistException;
import br.com.joaonaif.naif_code.exceptions.TaskNotFoundException;
import br.com.joaonaif.naif_code.modules.task.Category;
import br.com.joaonaif.naif_code.modules.task.TaskEntity;
import br.com.joaonaif.naif_code.modules.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PutTaskUseCase {

    @Autowired
    private TaskRepository taskRepository;

    public TaskEntity execute(UUID idTask, String name, Category category) {
        var task = this.taskRepository.findById(idTask)
                .orElseThrow(() -> {
                    throw new TaskNotFoundException();
                });

        this.taskRepository.findByName(name)
                .ifPresent((user) -> {
                    throw new TaskAlreadyExistException();
                });

        task.setName(name);
        task.setCategory(category);

        taskRepository.save(task);

        return task;
    }
}
