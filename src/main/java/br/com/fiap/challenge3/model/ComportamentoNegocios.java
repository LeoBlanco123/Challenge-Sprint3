package br.com.fiap.challenge3.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "ComportamentoNegocios")
public class ComportamentoNegocios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long interacoesPlataforma;

    @Min(value = 0)
    @Max(value = 10)
    @NotNull
    private Long frequenciaUso;

    @NotBlank
    private String feedback;

    @Enumerated(EnumType.STRING)
    private OpcoesRecursos usoRecursosEspecificos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresas empresa;
}