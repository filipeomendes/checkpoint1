package br.com.fiap.checkpoint1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_TAREFA")
@Getter @Setter @NoArgsConstructor
public class Tarefa {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "ds_titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "ds_descricao", nullable = false, length = 500)
    private String descricao;

    @Column(name = "dt_conclusao")
    private LocalDateTime dataConclusao;

    @Enumerated(EnumType.STRING)
    @Column(name = "ds_status", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public Tarefa(String titulo, String descricao, LocalDateTime dataConclusao, Status status, Usuario usuario) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataConclusao = dataConclusao;
        this.status = status;
        this.usuario = usuario;
    }

    public Tarefa(String titulo, String descricao, LocalDateTime dataConclusao, String status, Usuario usuario) {
    }
}