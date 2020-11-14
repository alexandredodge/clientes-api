package io.github.alexandredodge.clientes.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.alexandredodge.clientes.model.entity.Aluno;
import io.github.alexandredodge.clientes.model.entity.Curso;
import io.github.alexandredodge.clientes.model.repositoty.AlunoRepository;
import io.github.alexandredodge.clientes.model.repositoty.CursoRepository;
import io.github.alexandredodge.clientes.rest.dto.AlunoDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/alunos")
@CrossOrigin("http://localhost:4200")
public class AlunoController {
	
	private final AlunoRepository repository;
	private final CursoRepository cursoRepository;
	
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Aluno salvar(@RequestBody AlunoDTO dto) {
		String nomeAlu = dto.getNome();
		String emaAlu = dto.getEmail();
		String ra = dto.getRa();
		Integer idCurso = dto.getIdCurso();
		
		Curso curso = cursoRepository.findById(idCurso).orElseThrow(() -> new ResponseStatusException
				( HttpStatus.BAD_REQUEST,"Curso Inexistente.." ));
		
		Aluno aluno = new Aluno();
		aluno.setNome(nomeAlu);
		aluno.setEmail(emaAlu);
		aluno.setRa(ra);
		aluno.setCurso(curso);
				
		
		return repository.save(aluno);
	}

}
