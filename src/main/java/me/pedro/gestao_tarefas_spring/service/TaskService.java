package me.pedro.gestao_tarefas_spring.service;

import me.pedro.gestao_tarefas_spring.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

        List<Task> findAllTasks();

        Task createTask(Task criarTask);

        Task updateTaskStatus(Long id,Task taskAtualizar);

        Task updateTaskDescricao(Long id,Task taskAtualizar);

        Task updateTaskPrioridade(Long id,Task taskAtualizar);

        Task updateTaskTitulo(Long id,Task taskAtualizar);

        void deleteTask(Long id);

        List<Task> findByTitle(String titulo);

        List<Task> findByStatus(String status);

        List<Task> findByPriority(String prioridade);

}
