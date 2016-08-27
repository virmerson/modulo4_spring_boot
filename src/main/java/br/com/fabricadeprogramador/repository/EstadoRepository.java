package br.com.fabricadeprogramador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fabricadeprogramador.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
