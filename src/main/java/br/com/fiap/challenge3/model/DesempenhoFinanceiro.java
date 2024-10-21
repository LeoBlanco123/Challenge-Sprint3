package br.com.fiap.challenge3.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class DesempenhoFinanceiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @PositiveOrZero(message = "{desempenho.receita.positive}")
    @NotNull(message = "{desempenho.receita.notNull}")
    private Double receita;

    @PositiveOrZero(message = "{desempenho.lucro.positive}")
    @NotNull(message = "{desempenho.lucro.notNull}")
    private Double lucro;

    @DecimalMin(value = "0.0", inclusive = true, message = "{desempenho.crescimento.min}")
    @DecimalMax(value = "100.0", inclusive = true, message = "{desempenho.crescimento.max}")
    @NotNull(message = "{desempenho.crescimento.notNull}")
    private Double crescimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresas empresa;

    public DesempenhoFinanceiro() {
    }

    public DesempenhoFinanceiro(Long id, Double receita, Double lucro, Double crescimento, Empresas empresa) {
        this.id = id;
        this.receita = receita;
        this.lucro = lucro;
        this.crescimento = crescimento;
        this.empresa = empresa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getReceita() {
        return receita;
    }

    public void setReceita(Double receita) {
        this.receita = receita;
    }

    public Double getLucro() {
        return lucro;
    }

    public void setLucro(Double lucro) {
        this.lucro = lucro;
    }

    public Double getCrescimento() {
        return crescimento;
    }

    public void setCrescimento(Double crescimento) {
        this.crescimento = crescimento;
    }

    public Empresas getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresas empresa) {
        this.empresa = empresa;
    }
}
