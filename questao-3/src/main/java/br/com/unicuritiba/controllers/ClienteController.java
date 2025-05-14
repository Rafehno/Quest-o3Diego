package br.com.unicuritiba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import br.com.unicuritiba.models.Cliente;
import br.com.unicuritiba.repositories.ClienteRepository;

@RestController
public class ClienteController {
	
	@Autowired
	ClienteRepository repository;
	
	
	@GetMapping("/Clientes")
	public ResponseEntity<List<Cliente>> getClientes(){
		return ResponseEntity.ok(repository.findAll());	
	}

	@GetMapping("/Clientes/{id}")
	public ResponseEntity<Cliente> getCliente(@PathVariable long id){
		return ResponseEntity.ok(repository.findById(id).get());	
	}
	
	@PostMapping("/Clientes")
	public ResponseEntity<Cliente> saveCliente(
			@RequestBody Cliente Cliente){
		Cliente savedCliente = repository.save(Cliente);
		return ResponseEntity.ok(savedCliente);
	}
	
	@DeleteMapping("/Clientes/{id}")
	public void removeCliente(@PathVariable long id) {
		 repository.deleteById(id);
	}
	
	@PutMapping("/Clientes/{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable long id,
			@RequestBody Cliente Cliente) {
		Cliente.setId(id);
		Cliente savedCliente = repository.save(Cliente);
		return ResponseEntity.ok(savedCliente);
	}
}