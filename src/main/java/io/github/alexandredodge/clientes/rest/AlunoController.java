package io.github.alexandredodge.clientes.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.alexandredodge.clientes.model.entity.Aluno;
import io.github.alexandredodge.clientes.model.repositoty.AlunoRepository;

@RestController
@RequestMapping("/api/alunos")
@CrossOrigin("http://localhost:4200")
public class AlunoController {
	
	private final AlunoRepository repository;
	
	@Autowired
	public AlunoController(AlunoRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Aluno salvar(@RequestBody @Valid Aluno aluno) {
		return repository.save(aluno);
	}

}
