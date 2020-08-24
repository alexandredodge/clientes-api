package io.github.alexandredodge.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ClientesApplication {

//	@Bean
//	public CommandLineRunner t  (@Autowired ServicoRepository sRepo){
//		Servico s = new Servico();
//		s.setDescricao("Descri");
//		sRepo.save(s);
//		return null;
//	}
//	
//	@Bean
//	public CommandLineRunner run (@Autowired ClienteRepository repository) {
//		
//		return args ->{
//			Cliente cliente = Cliente.builder().cpf("00000000000").nome("Isabela").build();
//			repository.save(cliente);
//		};
//		
//		
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(ClientesApplication.class, args);
	}

}
