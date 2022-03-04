package com.aula2.contato.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aula2.contato.model.Contato;
import com.aula2.contato.service.ContatoService;

@RestController
@RequestMapping("/contato")
public class ContatoController implements ControllerInterface<Contato>{
	@Autowired
	private ContatoService service;
	
	@Override
	@GetMapping
	public ResponseEntity<List<Contato>> getAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Contato> get(@PathVariable("id") Long id){
		Contato _contato = service.findById(id);
		if(_contato != null) {
			return ResponseEntity.ok(_contato);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@Override
	@PostMapping
	public ResponseEntity<Contato> post(@RequestBody Contato obj) {
		service.create(obj);
		URI location = ServletUriComponentsBuilder.
				fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		
		return ResponseEntity.created(location).body(obj);
	}
	
	@Override
	@PutMapping
	public ResponseEntity<Contato> put(@RequestBody Contato obj){
		if (service.update(obj)) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@Override
	@DeleteMapping("{id}")
	public ResponseEntity<Contato> delete(@PathVariable("id") Long id){
		if (service.delete(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
}
