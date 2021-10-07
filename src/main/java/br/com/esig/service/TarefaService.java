package br.com.esig.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.esig.domain.Tarefa;
import br.com.esig.enums.Situacao;
import br.com.esig.repository.TarefaRepository;


@Service
public class TarefaService {
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	
	public ResponseEntity<Tarefa> cadastrar(Tarefa tarefa){
	
		
		tarefa.setSituacao(Situacao.ANDAMENTO);

		tarefaRepository.save(tarefa);
		
		return new ResponseEntity<Tarefa>(tarefa , HttpStatus.CREATED);
		
	
	}
	
	
	public ResponseEntity<Tarefa> atualizar(Tarefa tarefa){
		
		tarefaRepository.saveAndFlush(tarefa);
		
		return new ResponseEntity<Tarefa>(tarefa , HttpStatus.OK);
		
	
	}
	
	
	public ResponseEntity<String> deletar(Long id) {
		
		tarefaRepository.deleteById(id);
		
		return new ResponseEntity<String>("Deletado com Sucesso", HttpStatus.OK);
	}
	

	
	public ResponseEntity<List<Tarefa>> findAllById(Long id){
		

		return new ResponseEntity<List<Tarefa>>(tarefaRepository.findAllById(id), HttpStatus.OK);
		
		
	}
	
	

	public ResponseEntity<List<Tarefa>> listar(){
		
		return new ResponseEntity<List<Tarefa>>(tarefaRepository.findAll(), HttpStatus.OK);
		
	}
	
	
	public ResponseEntity<List<Tarefa>> findByDescricao(String descricao){
		
		return new ResponseEntity<List<Tarefa>>(tarefaRepository.findByDescricao(descricao), HttpStatus.OK);
		
		
	}
	
	public ResponseEntity<List<Tarefa>> findByTitulo(String titulo){
		
		return new ResponseEntity<List<Tarefa>>(tarefaRepository.findByTitulo(titulo), HttpStatus.OK);
		
	}
	

	public ResponseEntity<List<Tarefa>> findByResponsavel(String responsavel){
		
		String responsavelToUpperCase = responsavel.toUpperCase();
		
		return new ResponseEntity<List<Tarefa>>(tarefaRepository.findAllByResponsavel(responsavelToUpperCase), HttpStatus.OK);
		
	}
	
	public ResponseEntity<List<Tarefa>> findByPrioridade(String prioridade){
		
		String prioridadeToUpperCase = prioridade.toUpperCase();
		
		return new ResponseEntity<List<Tarefa>>(tarefaRepository.findAllByPrioridade(prioridadeToUpperCase), HttpStatus.OK);
		
	}

	public ResponseEntity<List<Tarefa>> findBySituacao(String situacao){
		

		
		return new ResponseEntity<List<Tarefa>>(tarefaRepository.findAllBySituacao(situacao), HttpStatus.OK);
		
	}
	
	

	
	public Optional<Tarefa> findById(Long id){
		
		return tarefaRepository.findById(id);
		
	}
	


	
	

}
