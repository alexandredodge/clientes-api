package io.github.alexandredodge.clientes.model.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.alexandredodge.clientes.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Integer>{

}
