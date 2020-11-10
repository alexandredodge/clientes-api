package io.github.alexandredodge.clientes.model.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.alexandredodge.clientes.model.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno,Integer>{

}
