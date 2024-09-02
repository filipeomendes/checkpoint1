package br.com.fiap.checkpoint1.controller;

import br.com.fiap.checkpoint1.dto.autenticacao.CadastroUsuarioDto;
import br.com.fiap.checkpoint1.dto.autenticacao.LoginDto;
import br.com.fiap.checkpoint1.dto.autenticacao.DadosTokenJwtDto;
import br.com.fiap.checkpoint1.service.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping("/register")
    public ResponseEntity<Void> cadastrarUsuario(@RequestBody CadastroUsuarioDto dto) {
        autenticacaoService.cadastrarUsuario(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<DadosTokenJwtDto> autenticar(@RequestBody LoginDto dto) {
        String token = autenticacaoService.autenticar(dto);
        return ResponseEntity.ok(new DadosTokenJwtDto(token));
    }
}