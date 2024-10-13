package br.com.fiap.challenge3.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
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
@Table(name = "TendenciasGastos")
public class TendenciasGastos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1900)
    @Max(value = 2025)
    @NotNull
    private Integer ano;

    @PositiveOrZero
    @NotNull
    private Double gastoMarketing;

    @PositiveOrZero
    @NotNull
    private Double gastoAutomacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresas empresa;
}


