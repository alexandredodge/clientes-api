package io.github.alexandredodge.clientes.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_aluno;
	
	@Column(nullable = false,length = 30)
	private String nome;
	
	@Column(nullable = false,length = 30)
	private String email;
	
	@Column(nullable = false,length = 30)
	private String ra;
	
//	@ManyToOne
//	@JoinColumn(name = "id_curso")
//	private Curso curso;
}
