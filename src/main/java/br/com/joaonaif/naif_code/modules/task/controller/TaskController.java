package br.com.joaonaif.naif_code.modules.task.controller;

import br.com.joaonaif.naif_code.modules.task.TaskEntity;
import br.com.joaonaif.naif_code.modules.task.useCases.CreateTaskUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class TaskController {

    @Autowired
    private CreateTaskUseCase createTaskUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody TaskEntity taskEntity) {
        try {
            var result = this.createTaskUseCase.execute((taskEntity));
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
