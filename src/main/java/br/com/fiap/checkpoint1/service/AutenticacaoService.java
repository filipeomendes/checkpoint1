package br.com.fiap.checkpoint1.service;

import br.com.fiap.checkpoint1.dto.autenticacao.CadastroUsuarioDto;
import br.com.fiap.checkpoint1.dto.autenticacao.LoginDto;
import br.com.fiap.checkpoint1.model.Usuario;
import br.com.fiap.checkpoint1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    public void cadastrarUsuario(CadastroUsuarioDto dto) {
        Usuario usuario = new Usuario(dto.nome(), dto.email(), passwordEncoder.encode(dto.senha()));
        usuarioRepository.save(usuario);
    }

    public String autenticar(LoginDto dto) {
        Usuario usuario = usuarioRepository.findByEmail(dto.email());
        if (usuario != null && passwordEncoder.matches(dto.senha(), usuario.getSenha())) {
            return tokenService.gerarToken(usuario);
        } else {
            throw new RuntimeException("Credenciais inválidas");
        }
    }
}