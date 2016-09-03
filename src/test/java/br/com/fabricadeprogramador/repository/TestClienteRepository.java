package br.com.fabricadeprogramador.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.fabricadeprogramador.model.Cliente;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class TestClienteRepository {

	@Autowired
	 ClienteRepository clienteRepository;
	
	@Autowired
	EntityManager entityManager;
	
	@Test
	public void testSalvar(){
	
		Cliente cli = new Cliente("Jão");
		Cliente cliSalvo = clienteRepository.save(cli);
		Assert.assertNotNull(cliSalvo.getId());
		
		
	}
	
	
	@Test
	public void testBuscarPorEmail(){
		Cliente cli = new Cliente("Jão");
		entityManager.persist(cli);
		
		//Cliente cliEncontrado = clienteRepository.buscarPorEmail("jao@htcursos.com");
		
		//assertThat(cliEncontrado.getNome()).isEqualTo(cli.getNome());
	}
	
	@Test
	public void testBuscarTodos(){
		Cliente cliJao = new Cliente("Jão");
		entityManager.persist(cliJao);
		
		Cliente cliZe = new Cliente("ze");
		entityManager.persist(cliZe);
		
		
		List<Cliente> lista = clienteRepository.buscarTodos();
		assertThat(lista.get(0).getNome()).isEqualTo(cliJao.getNome());
		assertThat(lista.get(1).getNome()).isEqualTo(cliZe.getNome());
		
	}
	
	
}
