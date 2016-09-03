package br.com.fabricadeprogramador.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cliente {

	@Id @GeneratedValue 
	private Long id;
	
	private String nome;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="cliente", fetch=FetchType.EAGER)
	private List<Contato> contatos =  new ArrayList<>();
	
	@JoinColumn
	@ManyToOne
	private Estado estado;

	
	public Cliente() {
	}
	
	public Cliente(String nome) {
		this.nome=nome;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
	
}
