package br.com.fiap.checkpoint1.controller;

import br.com.fiap.checkpoint1.dto.tarefa.CadastroTarefaDto;
import br.com.fiap.checkpoint1.dto.tarefa.AtualizacaoTarefaDto;
import br.com.fiap.checkpoint1.dto.tarefa.DetalhesTarefaDto;
import br.com.fiap.checkpoint1.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<DetalhesTarefaDto> criarTarefa(@RequestHeader("Authorization") String authHeader, @RequestBody CadastroTarefaDto dto) {
        String token = authHeader.replace("Bearer ", "");
        DetalhesTarefaDto tarefa = tarefaService.criarTarefa(dto, token);
        return ResponseEntity.ok(tarefa);
    }

    @GetMapping
    public ResponseEntity<List<DetalhesTarefaDto>> listarTarefas(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        List<DetalhesTarefaDto> tarefas = tarefaService.listarTarefas(token);
        return ResponseEntity.ok(tarefas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalhesTarefaDto> atualizarTarefa(@PathVariable Long id, @RequestBody AtualizacaoTarefaDto dto) {
        DetalhesTarefaDto tarefa = tarefaService.atualizarTarefa(id, dto);
        return ResponseEntity.ok(tarefa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirTarefa(@PathVariable Long id) {
        tarefaService.excluirTarefa(id);
        return ResponseEntity.noContent().build();
    }
}