package br.com.fiap.challenge3.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class ComportamentoNegocios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "{comportamento.interacoes.notNull}")
    @PositiveOrZero(message = "{comportamento.interacoes.positive}")
    private Long interacoesPlataforma;

    @Min(value = 0, message = "{comportamento.frequencia.min}")
    @Max(value = 10, message = "{comportamento.frequencia.max}")
    @NotNull(message = "{comportamento.frequencia.notNull}")
    private Long frequenciaUso;

    @NotBlank(message = "{comportamento.feedback.notBlank}")
    private String feedback;

    @Enumerated(EnumType.STRING)
    private OpcoesRecursos usoRecursosEspecificos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresas empresa;

    public ComportamentoNegocios() {
    }

    public ComportamentoNegocios(Long id, Long interacoesPlataforma, Long frequenciaUso, String feedback, OpcoesRecursos usoRecursosEspecificos, Empresas empresa) {
        this.id = id;
        this.interacoesPlataforma = interacoesPlataforma;
        this.frequenciaUso = frequenciaUso;
        this.feedback = feedback;
        this.usoRecursosEspecificos = usoRecursosEspecificos;
        this.empresa = empresa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInteracoesPlataforma() {
        return interacoesPlataforma;
    }

    public void setInteracoesPlataforma(Long interacoesPlataforma) {
        this.interacoesPlataforma = interacoesPlataforma;
    }

    public Long getFrequenciaUso() {
        return frequenciaUso;
    }

    public void setFrequenciaUso(Long frequenciaUso) {
        this.frequenciaUso = frequenciaUso;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public OpcoesRecursos getUsoRecursosEspecificos() {
        return usoRecursosEspecificos;
    }

    public void setUsoRecursosEspecificos(OpcoesRecursos usoRecursosEspecificos) {
        this.usoRecursosEspecificos = usoRecursosEspecificos;
    }

    public Empresas getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresas empresa) {
        this.empresa = empresa;
    }
}