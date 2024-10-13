package br.com.fiap.challenge3.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "DesempenhoFinanceiro")
public class DesempenhoFinanceiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @PositiveOrZero
    @NotNull
    private Double receita;

    @PositiveOrZero
    @NotNull
    private Double lucro;

    @DecimalMin(value = "0.0")
    @DecimalMax(value = "100.0")
    @NotNull
    private Double crescimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresas empresa;
}
