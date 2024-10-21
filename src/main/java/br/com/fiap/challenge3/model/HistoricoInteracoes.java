package br.com.fiap.challenge3.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class HistoricoInteracoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{historico.proposta.notBlank}")
    private String propostaNegocio;

    @Enumerated(EnumType.STRING)
    private OpcoesContrato contratoAssinado;

    @NotBlank(message = "{historico.feedback.notBlank}")
    private String feedbackServicosProdutos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresas empresa;

    public HistoricoInteracoes() {
    }

    public HistoricoInteracoes(Long id, String propostaNegocio, OpcoesContrato contratoAssinado, String feedbackServicosProdutos, Empresas empresa) {
        this.id = id;
        this.propostaNegocio = propostaNegocio;
        this.contratoAssinado = contratoAssinado;
        this.feedbackServicosProdutos = feedbackServicosProdutos;
        this.empresa = empresa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropostaNegocio() {
        return propostaNegocio;
    }

    public void setPropostaNegocio(String propostaNegocio) {
        this.propostaNegocio = propostaNegocio;
    }

    public OpcoesContrato getContratoAssinado() {
        return contratoAssinado;
    }

    public void setContratoAssinado(OpcoesContrato contratoAssinado) {
        this.contratoAssinado = contratoAssinado;
    }

    public String getFeedbackServicosProdutos() {
        return feedbackServicosProdutos;
    }

    public void setFeedbackServicosProdutos(String feedbackServicosProdutos) {
        this.feedbackServicosProdutos = feedbackServicosProdutos;
    }

    public Empresas getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresas empresa) {
        this.empresa = empresa;
    }
}