package br.edu.aranoua.contatos.resource;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.aranoua.contatos.assembler.ContatoModelAssembler;
import br.edu.aranoua.contatos.entity.ContatoEntity;
import br.edu.aranoua.contatos.model.ContatoModel;
import br.edu.aranoua.contatos.service.ContatoService;


@RestController
@RequestMapping("/contatos")
public class ContatoResource {

	@Autowired
	ContatoService contatoService;
	
	@Autowired
	ContatoModelAssembler contatoModelAssembler;
	
	@GetMapping
	public ResponseEntity<CollectionModel<ContatoModel>> getContatos(){
		List<ContatoEntity> contatoEntities = contatoService.listarContato();
		return ResponseEntity.ok(
				contatoModelAssembler.toCollectionModel(contatoEntities))
	}
	
	@GetMapping("/id")
	public ResponseEntity<ContatoEntity> getContatos(@PathVariable Long id){
		Optional<ContatoEntity> contato = contatoService.listarContato(id);
		
		if(contato.isPresent()) {
				return ResponseEntity.ok(
						contatoModelAssembler.toModel(contato.get()));
				}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ContatoEntity setContato(@RequestBody ContatoEntity contato) {
		return contatoService.salvar(contato);
	}
	
	@PutMapping("/id")
	public ResponseEntity<ContatoEntity> updateContato(@PathVariable Long id,
		@RequestBody ContatoEntity contato){
		if(contatoService.listarContato(id).isPresent()) {
			contato.setId(id);
			return ResponseEntity.ok(contatoService.atualizar(contato));
		}
		return ResponseEntity.notFound().build();
		}
	
	@DeleteMapping("/id")
	public ResponseEntity<Void> deleteContato(@PathVariable Long id){
		if(contatoService.listarContato(id).isPresent()) {
			contatoService.excluir(id);
			return ResponseEntity.noContent().build();
		}
	}
}
