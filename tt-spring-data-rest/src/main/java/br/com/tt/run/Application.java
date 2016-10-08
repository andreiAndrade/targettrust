package br.com.tt.run;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.tt.model.Cliente;
import br.com.tt.model.Compra;
import br.com.tt.model.Pet;
import br.com.tt.repository.ClienteRepository;
import br.com.tt.repository.PetRepository;

@SpringBootApplication
@EntityScan(basePackages = { "br.com.tt.model" })
@EnableJpaRepositories(basePackages = { "br.com.tt.repository" })
@ComponentScan(basePackages = {"br.com.tt.controller"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}

	@Bean
	public CommandLineRunner loadClientes(ClienteRepository repository) {
		return (args) -> {
			repository.save(new Cliente("1234345423", "Avenida Rebouças 1500", "Luiz", Arrays.asList( new Compra[]{new Compra(50D, 6),new Compra(56D, 11)})));
			repository.save(new Cliente("6545645654", "Rua dos Pinheiros 2000", "Bruna",Arrays.asList( new Compra[]{new Compra(10D, 5),new Compra(57D, 22)})));
			repository.save(new Cliente("6452345234", "Alameda Santos 120", "Sonia",Arrays.asList( new Compra[]{new Compra(12D, 4),new Compra(588D, 44)})));
			repository.save(new Cliente("7565345325", "Rua XV de Novembro 2012", "Brianda",Arrays.asList( new Compra[]{new Compra(43D, 3),new Compra(599D, 65)})));
			repository.save(new Cliente("6456563454", "Rua 7 de Setembro 2001", "Enio",Arrays.asList( new Compra[]{new Compra(45D, 2),new Compra(511D, 67)})));
			repository.save(new Cliente("7565345645", "Avenida Brasil 201", "Marcelo",Arrays.asList( new Compra[]{new Compra(100D, 1),new Compra(511D, 76)})));
		};
	}
	@Bean
	public CommandLineRunner loadPets(PetRepository repository) {
		return (args) -> {
			repository.save(new Pet("Totó", "Eu", "BodyBuilder", "Gente que nem a gente"));
		};
	}


}