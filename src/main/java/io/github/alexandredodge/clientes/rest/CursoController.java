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

import io.github.alexandredodge.clientes.model.entity.Curso;
import io.github.alexandredodge.clientes.model.repositoty.CursoRepository;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin
public class CursoController {

	private final CursoRepository repository;
	
	@Autowired
	public CursoController(CursoRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Curso salvar(@RequestBody @Valid Curso curso) {
		return this.repository.save(curso);
	}
	
}
