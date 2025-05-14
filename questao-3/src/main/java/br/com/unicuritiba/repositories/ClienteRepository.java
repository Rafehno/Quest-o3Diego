package br.com.unicuritiba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unicuritiba.models.Cliente;

public interface ClienteRepository 
extends JpaRepository<Cliente, Long> {

	
	
}
