package io.github.alexandredodge.clientes.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.alexandredodge.clientes.model.entity.Cliente;
import io.github.alexandredodge.clientes.model.entity.Servico;
import io.github.alexandredodge.clientes.model.repositoty.ServicoRepository;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {

	private ServicoRepository repository;
	
	@Autowired
	public ServicoController(ServicoRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Servico salvar(@RequestBody Servico servico) {
		return repository.save(servico);
	}
}
