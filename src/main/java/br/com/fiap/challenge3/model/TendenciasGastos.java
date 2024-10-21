package br.com.fiap.challenge3.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class TendenciasGastos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1900, message = "{tendencia.ano.min}")
    @Max(value = 2025, message = "{tendencia.ano.max}")
    @NotNull(message = "{tendencia.ano.notNull}")
    private Integer ano;

    @PositiveOrZero(message = "{tendencia.gastoMarketing.positive}")
    @NotNull(message = "{tendencia.gastoMarketing.notNull}")
    private Double gastoMarketing;

    @PositiveOrZero(message = "{tendencia.gastoAutomacao.positive}")
    @NotNull(message = "{tendencia.gastoAutomacao.notNull}")
    private Double gastoAutomacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresas empresa;

    public TendenciasGastos() {
    }

    public TendenciasGastos(Long id, Integer ano, Double gastoMarketing, Double gastoAutomacao, Empresas empresa) {
        this.id = id;
        this.ano = ano;
        this.gastoMarketing = gastoMarketing;
        this.gastoAutomacao = gastoAutomacao;
        this.empresa = empresa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Double getGastoMarketing() {
        return gastoMarketing;
    }

    public void setGastoMarketing(Double gastoMarketing) {
        this.gastoMarketing = gastoMarketing;
    }

    public Double getGastoAutomacao() {
        return gastoAutomacao;
    }

    public void setGastoAutomacao(Double gastoAutomacao) {
        this.gastoAutomacao = gastoAutomacao;
    }

    public Empresas getEmpresa() {
        return empresa;
    }
    public void setEmpresa(Empresas empresa) {
        this.empresa = empresa;
    }
}


