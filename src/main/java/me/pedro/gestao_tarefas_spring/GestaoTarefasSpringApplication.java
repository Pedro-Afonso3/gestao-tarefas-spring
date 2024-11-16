package me.pedro.gestao_tarefas_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GestaoTarefasSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoTarefasSpringApplication.class, args);
	}

}
