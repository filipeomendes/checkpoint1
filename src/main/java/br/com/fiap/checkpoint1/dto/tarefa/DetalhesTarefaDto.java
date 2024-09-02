package br.com.fiap.checkpoint1.dto.tarefa;

import br.com.fiap.checkpoint1.model.Tarefa;
import java.time.LocalDateTime;

public record DetalhesTarefaDto(Long id, String titulo, String descricao, LocalDateTime dataConclusao, String status) {

    public DetalhesTarefaDto(Tarefa tarefa) {
        this(tarefa.getId(), tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getDataConclusao(), String.valueOf(tarefa.getStatus()));
    }
}