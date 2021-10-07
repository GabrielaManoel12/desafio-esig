package br.com.esig.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.esig.domain.Tarefa;
import br.com.esig.service.TarefaService;

@RestController
@CrossOrigin(origins = "*")
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;

	// EndPoint - Cadastrar Tarefa

	@PostMapping("/cadastrar")
	public ResponseEntity<Tarefa> cadastrar(@RequestBody Tarefa tarefa) {

		return tarefaService.cadastrar(tarefa);

	}

	// EndPoint - Atualizar Tarefa
	@PutMapping("/atualizar")
	public ResponseEntity<Tarefa> atualizar(@RequestBody Tarefa tarefa) {

		return tarefaService.cadastrar(tarefa);

	}

	// EndPoint - Deletar Tarefa
	@GetMapping("/deletar/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {
		return tarefaService.deletar(id);
	}

	// EndPoint - Listar todas as Tarefas

	@GetMapping("/listar")
	public ResponseEntity<List<Tarefa>> listar() {
		return tarefaService.listar();
	}

	// EndPoint - Listar por meio da descrição
	@GetMapping("/findByDescricao/{descricao}")
	public ResponseEntity<List<Tarefa>> findByDescricao(@PathVariable String descricao) {
		return tarefaService.findByDescricao(descricao);
	}

	// EndPoint - Listar por meio do titulo
	@GetMapping("/findByTitulo/{titulo}")
	public ResponseEntity<List<Tarefa>> findByTitulo(@PathVariable String titulo) {
		return tarefaService.findByTitulo(titulo);
	}

	// EndPoint - Listar por meio do Responsavel
	@GetMapping("/findByResponsavel/{responsavel}")
	public ResponseEntity<List<Tarefa>> findByResponsavel(@PathVariable String responsavel) {
		return tarefaService.findByResponsavel(responsavel);
	}

	// EndPoint - Listar por meio da Prioridade
	@GetMapping("/findByPrioridade/{prioridade}")
	public ResponseEntity<List<Tarefa>> findByPrioridade(@PathVariable String prioridade) {
		return tarefaService.findByPrioridade(prioridade);
	}

	// EndPoint - Listar por meio do ID
	@GetMapping("/findAllById/{id}")
	public ResponseEntity<List<Tarefa>> findAllById(@PathVariable Long id) {

		return tarefaService.findAllById(id);

	}

	@GetMapping("/findBySituacao/{situacao}")
	public ResponseEntity<List<Tarefa>> findBySituacao(@PathVariable String situacao) {

		return tarefaService.findBySituacao(situacao);

	}



	@GetMapping("/findById/{id}")
	public Optional<Tarefa> findById( @PathVariable  Long id){
		
		return tarefaService.findById(id);
		
	}



	
	
}
