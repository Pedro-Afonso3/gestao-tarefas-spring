package me.pedro.gestao_tarefas_spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_lista")
public class task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;



}
