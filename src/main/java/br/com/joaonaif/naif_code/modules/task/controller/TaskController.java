package br.com.joaonaif.naif_code.modules.task.controller;

import br.com.joaonaif.naif_code.modules.task.Category;
import br.com.joaonaif.naif_code.modules.task.TaskEntity;
import br.com.joaonaif.naif_code.modules.task.dto.PutTaskRequestDTO;
import br.com.joaonaif.naif_code.modules.task.useCases.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cursos")
public class TaskController {

    @Autowired
    private CreateTaskUseCase createTaskUseCase;

    @Autowired
    private GetManyTaskUseCase getManyTaskUseCase;

    @Autowired
    private DeleteTaskUseCase deleteTaskUseCase;

    @Autowired
    private PatchTaskUseCase patchTaskUseCase;

    @Autowired
    private PutTaskUseCase putTaskUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody TaskEntity taskEntity) {
        try {
            var result = this.createTaskUseCase.execute((taskEntity));
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> get() {
        try {
            var getTask = this.getManyTaskUseCase.execute();
            return ResponseEntity.ok().body(getTask);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<Object> patch(@PathVariable UUID id) {
        try {
            this.patchTaskUseCase.execute(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> put(
            @PathVariable UUID id, @Valid @RequestBody PutTaskRequestDTO putTaskRequestDTO) {
        String name = putTaskRequestDTO.getName();
        Category category = putTaskRequestDTO.getCategory();

        try {
            var task = this.putTaskUseCase.execute(id, name, category);
            return ResponseEntity.ok().body(task);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        try {
            this.deleteTaskUseCase.execute(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
