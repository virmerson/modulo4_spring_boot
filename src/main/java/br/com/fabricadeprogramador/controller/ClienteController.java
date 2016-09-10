package br.com.fabricadeprogramador.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fabricadeprogramador.model.Cliente;
import br.com.fabricadeprogramador.model.Contato;
import br.com.fabricadeprogramador.repository.ClienteRepository;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Setter @Getter
	private List<Cliente> clientes;
	@Setter @Getter
	private Cliente cliente =  new Cliente();
	@Setter @Getter
	private boolean modoEdicao=false;
	@Setter @Getter
	private Contato contato= new Contato();
	
	@PostConstruct
	public void init() {
		setClientes(clienteRepository.buscarTodos());
	}
	
	public void salvar(){
		
		clienteRepository.save(cliente);
		if(!isModoEdicao())
			clientes.add(cliente);
		cliente = new Cliente();
		setModoEdicao(false);
	}

	public void excluir(Cliente cliente){
		clienteRepository.delete(cliente);
		clientes.remove(cliente);
	}
	
	public void editar(Cliente cliente){
		setCliente(cliente);
		setModoEdicao(true);
	}
	
	public void cancelar(){
		cliente = new Cliente();
		setModoEdicao(false);
	}

	
	public void adicionarContato(){
		
		contato.setCliente(cliente);
		cliente.getContatos().add(contato);
		contato = new Contato();
		
		
	}
	
	public void excluirContato(Contato contato){
		
		cliente.getContatos().remove(contato);
	}
	
	


}
