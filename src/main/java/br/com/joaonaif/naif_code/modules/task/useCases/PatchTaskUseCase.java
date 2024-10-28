package br.com.joaonaif.naif_code.modules.task.useCases;

import br.com.joaonaif.naif_code.exceptions.TaskNotFoundException;
import br.com.joaonaif.naif_code.modules.task.TaskEntity;
import br.com.joaonaif.naif_code.modules.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PatchTaskUseCase {

    @Autowired
    private TaskRepository taskRepository;

    public void execute(UUID idTask) {
        var task = this.taskRepository.findById(idTask)
                .orElseThrow(() -> {
                    throw new TaskNotFoundException();
                });

        task.setActive(!task.getActive());

        taskRepository.save(task);
    }
}
