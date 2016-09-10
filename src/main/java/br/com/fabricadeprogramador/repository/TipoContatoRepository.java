package br.com.fabricadeprogramador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fabricadeprogramador.model.TipoContato;

@Repository
public interface TipoContatoRepository extends JpaRepository<TipoContato, Integer> {

}
