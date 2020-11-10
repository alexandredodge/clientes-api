package io.github.alexandredodge.clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.alexandredodge.clientes.model.entity.Cliente;
import io.github.alexandredodge.clientes.model.repositoty.ClienteRepository;


@SpringBootApplication
public class ClientesApplication {

	@Bean
	CommandLineRunner c (@Autowired ClienteRepository repo) {
		return args ->{
			
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ClientesApplication.class, args);
	}

}
