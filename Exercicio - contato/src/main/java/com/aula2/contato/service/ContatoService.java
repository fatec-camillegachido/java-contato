package com.aula2.contato.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula2.contato.model.Contato;
import com.aula2.contato.repository.ContatoRepository;

@Service
public class ContatoService implements ServiceInterface<Contato>{
	@Autowired
	private ContatoRepository repository;
	
	@Override
	public List<Contato> findAll(){
		return repository.findAll();
	}
	
	@Override
	public Contato findById(Long id) {
		Optional<Contato> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	@Override 
	public Contato create(Contato obj) {
		repository.save(obj);
		return obj;
	}
	
	@Override
	public boolean update(Contato obj) {
		if (repository.existsById(obj.getId())) {
			repository.save(obj);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean delete(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
}
