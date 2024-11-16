package me.pedro.gestao_tarefas_spring.controller;

import me.pedro.gestao_tarefas_spring.model.Task;
import me.pedro.gestao_tarefas_spring.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Task>> buscarTodasTarefas(){
        return ResponseEntity.ok(taskService.findAllTasks());
    }

    @GetMapping("/buscarPorTitulo/{titulo}")
    public ResponseEntity<Iterable<Task>> buscarPorTitulo(@PathVariable String titulo){
        var taskSearch = taskService.findByTitle(titulo);
        return ResponseEntity.ok(taskSearch);
    }

    @GetMapping("/buscarPorStatus/{status}")
    public ResponseEntity<Iterable<Task>> buscarPorStatus(@PathVariable String status){
        var taskSearch = taskService.findByStatus(status);
        return ResponseEntity.ok(taskSearch);
    }

    @GetMapping("/buscarPorPrioridade/{prioridade}")
    public ResponseEntity<Iterable<Task>> buscarPorPrioridade(@PathVariable String prioridade){
        var taskSearch = taskService.findByPriority(prioridade);
        return ResponseEntity.ok(taskSearch);
    }

    @PostMapping
    public ResponseEntity<Task> inserirTarefa(@RequestBody Task task){
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @PutMapping("/atualizarDescricaoTarefa/{id}")
    public ResponseEntity<Task> atualizarDescricaoTarefa(@PathVariable Long id,@RequestBody Task task){
        return ResponseEntity.ok(taskService.updateTaskDescricao(id,task));
    }

    @PutMapping("/atualizarStatusTarefa/{id}")
    public ResponseEntity<Task> atualizarStatusTarefa(@PathVariable Long id,@RequestBody Task task){
        return ResponseEntity.ok(taskService.updateTaskStatus(id,task));
    }

    @PutMapping("/atualizarPrioridadeTarefa/{id}")
    public ResponseEntity<Task> atualizarPrioridadeTarefa(@PathVariable Long id,@RequestBody Task task){
        return ResponseEntity.ok(taskService.updateTaskPrioridade(id,task));
    }

    @PutMapping("/atualizarTituloTarefa/{id}")
    public ResponseEntity<Task> atualizarTituloTarefa(@PathVariable Long id,@RequestBody Task task){
        return ResponseEntity.ok(taskService.updateTaskTitulo(id,task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteUsuario(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }
}
