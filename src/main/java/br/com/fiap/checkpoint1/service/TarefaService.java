package br.com.fiap.checkpoint1.service;

import br.com.fiap.checkpoint1.dto.tarefa.CadastroTarefaDto;
import br.com.fiap.checkpoint1.dto.tarefa.AtualizacaoTarefaDto;
import br.com.fiap.checkpoint1.dto.tarefa.DetalhesTarefaDto;
import br.com.fiap.checkpoint1.model.Status;
import br.com.fiap.checkpoint1.model.Tarefa;
import br.com.fiap.checkpoint1.model.Usuario;
import br.com.fiap.checkpoint1.repository.TarefaRepository;
import br.com.fiap.checkpoint1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    public DetalhesTarefaDto criarTarefa(CadastroTarefaDto dto, String token) {
        String email = tokenService.getSubject(token);
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null) {
            throw new RuntimeException("Usuário não encontrado");
        }
        Tarefa tarefa = new Tarefa(dto.titulo(), dto.descricao(), dto.dataConclusao(), dto.status(), usuario);
        tarefaRepository.save(tarefa);
        return new DetalhesTarefaDto(tarefa);
    }

    public List<DetalhesTarefaDto> listarTarefas(String token) {
        String email = tokenService.getSubject(token);
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null) {
            throw new RuntimeException("Usuário não encontrado");
        }
        List<Tarefa> tarefas = tarefaRepository.findByUsuarioId(usuario.getId());
        return tarefas.stream().map(DetalhesTarefaDto::new).collect(Collectors.toList());
    }

    public DetalhesTarefaDto atualizarTarefa(Long id, AtualizacaoTarefaDto dto) {
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        tarefa.setTitulo(dto.titulo() != null ? dto.titulo() : tarefa.getTitulo());
        tarefa.setDescricao(dto.descricao() != null ? dto.descricao() : tarefa.getDescricao());
        tarefa.setDataConclusao(dto.dataConclusao() != null ? dto.dataConclusao() : tarefa.getDataConclusao());
        tarefa.setStatus(dto.status() != null ? Status.valueOf(dto.status()) : tarefa.getStatus());
        tarefaRepository.save(tarefa);
        return new DetalhesTarefaDto(tarefa);
    }

    public void excluirTarefa(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        tarefaRepository.delete(tarefa);
    }
}