package br.com.fiap.checkpoint1.dto.tarefa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public record CadastroTarefaDto(
        @NotBlank @Size(max = 100) String titulo,
        @NotBlank @Size(max = 500) String descricao,
        @NotNull LocalDateTime dataConclusao,
        @NotBlank String status) {
}