package br.com.fiap.checkpoint1.dto.autenticacao;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroUsuarioDto(
        @NotBlank @Size(max = 50) String nome,
        @NotBlank @Email @Size(max = 100) String email,
        @NotBlank @Size(min = 6, max = 100) String senha
) {
}