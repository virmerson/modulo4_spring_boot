package br.com.fabricadeprogramador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fabricadeprogramador.model.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer>{

}
