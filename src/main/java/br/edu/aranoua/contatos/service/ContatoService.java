package br.edu.aranoua.contatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.aranoua.contatos.entity.ContatoEntity;
import br.edu.aranoua.contatos.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;
	
	public List<ContatoEntity> listarContatos(){
		return contatoRepository.findAll();
	}
	
	public Optional<ContatoEntity> listarContato(Long id){
		return contatoRepository.findById(id);
	}
	
	public ContatoEntity salvar(ContatoEntity contato) {
		return contatoRepository.save(contato);
	}
	public ContatoEntity atualizar(ContatoEntity contato) {
		return contatoRepository.save(contato);
	}
	public void excluir(Long id) {
		contatoRepository.deleteById(id);
	}
	 
}
