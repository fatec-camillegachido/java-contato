package com.aula2.contato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aula2.contato.model.Contato;


@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{
	
}
