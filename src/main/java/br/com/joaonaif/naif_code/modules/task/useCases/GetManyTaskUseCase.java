package br.com.joaonaif.naif_code.modules.task.useCases;

import br.com.joaonaif.naif_code.modules.task.TaskEntity;
import br.com.joaonaif.naif_code.modules.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetManyTaskUseCase {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskEntity> execute() {
        return taskRepository.findAll();
    }
}
