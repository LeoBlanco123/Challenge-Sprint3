package br.com.fiap.challenge3.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Empresas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 4, max = 255, message = "{empresa.nome.size}")
    @NotEmpty(message = "{empresa.nome.notEmpty}")
    private String nome;

    @Enumerated(EnumType.STRING)
    private OpcoesTamanho tamanho;

    @Enumerated(EnumType.STRING)
    private OpcoesSetor setor;

    @NotEmpty(message = "{empresa.loc.notEmpty}")
    private String localizacaoGeografica;

    @PositiveOrZero(message = "{empresa.numFun.positive}")
    @NotNull(message = "{empresa.numFun.notEmpty}")
    private Integer numeroFuncionarios;

    @Enumerated(EnumType.STRING)
    private OpcoesTipo tipoEmpresa;

    private Boolean cliente;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TendenciasGastos> tendencias = new ArrayList<>();

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DesempenhoFinanceiro> desempenhos = new ArrayList<>();

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HistoricoInteracoes> historicos;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComportamentoNegocios> comportamentos = new ArrayList<>();

    public Empresas() {
    }

    public Empresas(Long id, String nome, OpcoesTamanho tamanho, OpcoesSetor setor, String localizacaoGeografica, Integer numeroFuncionarios, OpcoesTipo tipoEmpresa, Boolean cliente, List<TendenciasGastos> tendencias, List<DesempenhoFinanceiro> desempenhos, List<HistoricoInteracoes> historicos, List<ComportamentoNegocios> comportamentos) {
        this.id = id;
        this.nome = nome;
        this.tamanho = tamanho;
        this.setor = setor;
        this.localizacaoGeografica = localizacaoGeografica;
        this.numeroFuncionarios = numeroFuncionarios;
        this.tipoEmpresa = tipoEmpresa;
        this.cliente = cliente;
        this.tendencias = tendencias;
        this.desempenhos = desempenhos;
        this.historicos = historicos;
        this.comportamentos = comportamentos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public OpcoesTamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(OpcoesTamanho tamanho) {
        this.tamanho = tamanho;
    }

    public OpcoesSetor getSetor() {
        return setor;
    }

    public void setSetor(OpcoesSetor setor) {
        this.setor = setor;
    }

    public String getLocalizacaoGeografica() {
        return localizacaoGeografica;
    }

    public void setLocalizacaoGeografica(String localizacaoGeografica) {
        this.localizacaoGeografica = localizacaoGeografica;
    }

    public Integer getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(Integer numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public OpcoesTipo getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(OpcoesTipo tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public Boolean getCliente() {
        return cliente;
    }

    public void setCliente(Boolean cliente) {
        this.cliente = cliente;
    }

    public List<TendenciasGastos> getTendencias() {
        return tendencias;
    }

    public void setTendencias(List<TendenciasGastos> tendencias) {
        this.tendencias = tendencias;
    }

    public List<DesempenhoFinanceiro> getDesempenhos() {
        return desempenhos;
    }

    public void setDesempenhos(List<DesempenhoFinanceiro> desempenhos) {
        this.desempenhos = desempenhos;
    }

    public List<HistoricoInteracoes> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<HistoricoInteracoes> historicos) {
        this.historicos = historicos;
    }

    public List<ComportamentoNegocios> getComportamentos() {
        return comportamentos;
    }

    public void setComportamentos(List<ComportamentoNegocios> comportamentos) {
        this.comportamentos = comportamentos;
    }
}
