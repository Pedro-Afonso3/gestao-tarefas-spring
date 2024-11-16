package me.pedro.gestao_tarefas_spring.repository;

import org.springframework.data.repository.query.Param;
//import feign.Param;
import me.pedro.gestao_tarefas_spring.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task> findByTitulo(@Param("titulo") String titulo);

    List<Task> findByStatus(@Param("status") String status);

    List<Task> findByPrioridade(@Param("prioridade") String prioridade);

    boolean existsByTitulo(String name);
}
