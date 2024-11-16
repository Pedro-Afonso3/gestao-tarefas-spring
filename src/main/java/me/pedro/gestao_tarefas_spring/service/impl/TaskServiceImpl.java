package me.pedro.gestao_tarefas_spring.service.impl;

import jakarta.persistence.EntityNotFoundException;
import me.pedro.gestao_tarefas_spring.model.Task;
import me.pedro.gestao_tarefas_spring.repository.TaskRepository;
import me.pedro.gestao_tarefas_spring.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findByTitle(String titulo) {
        return taskRepository.findByTitulo(titulo);

    }

    public List<Task> findByStatus(String status){
        return taskRepository.findByStatus(status);
    }

    @Override
    public List<Task> findByPriority(String prioridade) {
        return taskRepository.findByPrioridade(prioridade);

    }

    @Override
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task createTask(Task criarTask) {
        if(taskRepository.existsByTitulo(criarTask.getTitulo())) {
            throw new IllegalArgumentException("Essa tarefa já existe!!!");
        }

        return taskRepository.save(criarTask);

    }



    @Override
    public Task updateTaskStatus(Long id, Task taskAtualizar) {
        return attTaskS(id,taskAtualizar);
    }

    @Override
    public Task updateTaskDescricao(Long id, Task taskAtualizar) {
        return attTaskD(id,taskAtualizar);
    }


    @Override
    public Task updateTaskPrioridade(Long id, Task taskAtualizar) {
        return attTaskP(id,taskAtualizar);
    }

    @Override
    public Task updateTaskTitulo(Long id, Task taskAtualizar) {
       return  attTaskT(id,taskAtualizar);
    }


    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task attTaskT(Long id, Task taskAtualizar){
        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent()){
            Task taskExistente = task.get();

            taskExistente.setTitulo(taskAtualizar.getTitulo());

            return taskRepository.save(taskExistente);
        }else {
            throw new EntityNotFoundException("Tarefa com id: "+id+" não foi encontrada");
        }
    }

    public Task attTaskD(Long id, Task taskAtualizar){
        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent()){
            Task taskExistente = task.get();

            taskExistente.setDescricao(taskAtualizar.getDescricao());

            return taskRepository.save(taskExistente);
        }else {
            throw new EntityNotFoundException("Tarefa com id: "+id+" não foi encontrada");
        }
    }

    public Task attTaskS(Long id, Task taskAtualizar){
        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent()){
            Task taskExistente = task.get();

            taskExistente.setStatus(taskAtualizar.getStatus());

            return taskRepository.save(taskExistente);
        }else {
            throw new EntityNotFoundException("Tarefa com id: "+id+" não foi encontrada");
        }
    }

    public Task attTaskP(Long id, Task taskAtualizar){
        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent()){
            Task taskExistente = task.get();

            taskExistente.setPrioridade(taskAtualizar.getPrioridade());

            return taskRepository.save(taskExistente);
        }else {
            throw new EntityNotFoundException("Tarefa com id: "+id+" não foi encontrada");
        }
    }


}
