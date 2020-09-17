package io.github.alexandredodge.clientes.rest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.alexandredodge.clientes.model.entity.Cliente;
import io.github.alexandredodge.clientes.model.entity.ServicoPrestado;
import io.github.alexandredodge.clientes.model.repositoty.ClienteRepository;
import io.github.alexandredodge.clientes.model.repositoty.ServicoPrestadoRepository;
import io.github.alexandredodge.clientes.rest.dto.ServicoPrestadoDTO;
import io.github.alexandredodge.clientes.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/servicos-prestados")
public class ServicoPrestadoController {
	
	private final ClienteRepository clienteRepository;
	private final ServicoPrestadoRepository servicoPrestadoRepository;
	private final BigDecimalConverter bigDecimalConverter;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto) {
		LocalDate data = LocalDate.parse(dto.getData(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Integer idCliente = dto.getIdCliente();
		
		Cliente cliente = clienteRepository
				.findById(idCliente)
				.orElseThrow( () -> new ResponseStatusException(
						HttpStatus.BAD_REQUEST,"Cliente Inexistente."));
		
		ServicoPrestado servicoPrestado = new ServicoPrestado();
		servicoPrestado.setDescricao(dto.getDescricao());
		servicoPrestado.setData(data);
		servicoPrestado.setCliente(cliente);
		servicoPrestado.setValor(bigDecimalConverter.converter(dto.getPreco()));
		
		return servicoPrestadoRepository.save(servicoPrestado);
	}
	
}
