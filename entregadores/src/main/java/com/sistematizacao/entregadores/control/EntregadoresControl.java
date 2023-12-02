package com.sistematizacao.entregadores.control;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import com.sistematizacao.entregadores.repositories.*;
import com.sistematizacao.entregadores.dtos.*;
import com.sistematizacao.entregadores.models.*;

@RestController
public class EntregadoresControl {
	
	@Autowired
	EntregadoresRepository entregadoresRepository;

	@PostMapping("/entregadores")
	public ResponseEntity<EntregadoresModel> salvar(@RequestBody @Valid EntregadoresDto entregadoresDto) {
		var entregadoresModel = new EntregadoresModel();
		BeanUtils.copyProperties(entregadoresDto, entregadoresModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(entregadoresRepository.save(entregadoresModel));
	}
	
	@GetMapping("/entregadores")
	public ResponseEntity<List<EntregadoresModel>> listar(){
		List<EntregadoresModel> entregadoresList = entregadoresRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(entregadoresList);
	}
	
	@GetMapping("/entregadores/{id}")
	public ResponseEntity<Object> detalhar(@PathVariable(value="id") Integer id){
		Optional<EntregadoresModel> entregadores = entregadoresRepository.findById(id);
		if(entregadores.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado exibição.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(entregadores.get());
	}
	
	@DeleteMapping("/entregadores/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable(value="id") Integer id) {
		Optional<EntregadoresModel> entregadores = entregadoresRepository.findById(id);
		if(entregadores.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado para exclusão.");
		}
		entregadoresRepository.delete(entregadores.get());
		return ResponseEntity.status(HttpStatus.OK).body("O Entregador foi excluído.");
	}
	
	@PutMapping("/entregadores/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable(value="id") Integer id,
													  @RequestBody @Valid EntregadoresDto entregadoresDto) {
		Optional<EntregadoresModel> entregadores = entregadoresRepository.findById(id);
		if(entregadores.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado para edição");
		}
		var entregadoresModel = entregadores.get();
		BeanUtils.copyProperties(entregadoresDto, entregadoresModel);
		return ResponseEntity.status(HttpStatus.OK).body(entregadoresRepository.save(entregadoresModel));
	}
	
	
	
	

}
