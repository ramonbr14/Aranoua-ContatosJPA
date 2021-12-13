package br.edu.aranoua.contatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.aranoua.contatos.entity.ContatoEntity;

public interface ContatoRepository extends JpaRepository<ContatoEntity,Long> {
	
 
}
