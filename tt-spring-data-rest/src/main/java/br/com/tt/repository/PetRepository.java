package br.com.tt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.tt.model.Cliente;
import br.com.tt.model.Pet;

@RepositoryRestResource(collectionResourceRel = "pet", path = "pets")
public interface PetRepository extends PagingAndSortingRepository<Pet, Long> {

	/**
	 * Método que retorna uma lista de clientes fazendo a busca pelo nome
	 * passado como parâmetro.
	 * 
	 * @param name
	 * @return lista de clientes
	 */
	List<Pet> findByNome(@Param("nome") String nome);

	/**
	 * Método que retorna o cliente com apenas seu nome fazendo a busca com o id
	 * passado como parâmetro.
	 * 
	 * @param id
	 * @return cliente do id passado como parâmetro.
	 */
	@Query("SELECT p.nome FROM Pet p where p.id = :id")
	Cliente findNomeById(@Param("id") Long id);

	/**
	 * Método que retorna uma lista de clientes fazendo a busca pelo nome
	 * passado como parâmetro e ordenando os clientes pelo nome.
	 * 
	 * @param name
	 * @return lista de clientes
	 */
	List<Cliente> findByNomeOrderByNome(@Param("nome") float nome);

}