package io.github.alexandredodge.clientes.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.alexandredodge.clientes.model.entity.Cliente;
import io.github.alexandredodge.clientes.model.entity.ServicoPrestado;
import io.github.alexandredodge.clientes.model.repositoty.ServicoPrestadoRepository;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {

	private ServicoPrestadoRepository repository;
	
	@Autowired
	public ServicoController(ServicoPrestadoRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServicoPrestado salvar(@RequestBody ServicoPrestado servico) {
		return repository.save(servico);
	}
}
