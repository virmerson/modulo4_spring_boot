package br.com.fabricadeprogramador.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fabricadeprogramador.model.Cliente;
import br.com.fabricadeprogramador.repository.ClienteRepository;

@Named
@ViewScoped
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	private List<Cliente> clientes;
	
	private Cliente cliente =  new Cliente();
	
	@PostConstruct
	public void init() {
		setClientes(clienteRepository.buscarTodos());
	}
	public void salvar(){
		
		clienteRepository.save(cliente);
		clientes.add(cliente);
		cliente = new Cliente();
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
