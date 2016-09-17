package br.com.fabricadeprogramador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Usuario {
	@Id
	@GeneratedValue
	private Integer id;
	private String  nome;
	private String senha;
	private  String papel;
}
