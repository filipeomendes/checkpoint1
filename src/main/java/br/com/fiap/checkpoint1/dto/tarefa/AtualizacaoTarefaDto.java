package br.com.fiap.checkpoint1.dto.tarefa;

import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public record AtualizacaoTarefaDto(
        @Size(max = 100) String titulo,
        @Size(max = 500) String descricao,
        LocalDateTime dataConclusao,
        String status) {
}