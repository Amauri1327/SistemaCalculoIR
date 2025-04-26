package com.SCIR.impostoApi.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "calculo_ir")
public class CalculoIR {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double rendaAnual;
    private Integer dependentes;
    private Double despesasEducacao;
    private Double impostoCalculado;
    private LocalDateTime dataHora;

    public CalculoIR(){}

    public CalculoIR(Long id, Double rendaAnual, Integer dependentes, Double despesasEducacao, Double impostoCalculado, LocalDateTime dataHora) {
        this.id = id;
        this.rendaAnual = rendaAnual;
        this.dependentes = dependentes;
        this.despesasEducacao = despesasEducacao;
        this.impostoCalculado = impostoCalculado;
        this.dataHora = dataHora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getRendaAnual() {
        return rendaAnual;
    }

    public void setRendaAnual(Double rendaAnual) {
        this.rendaAnual = rendaAnual;
    }

    public Integer getDependentes() {
        return dependentes;
    }

    public void setDependentes(Integer dependentes) {
        this.dependentes = dependentes;
    }

    public Double getDespesasEducacao() {
        return despesasEducacao;
    }

    public void setDespesasEducacao(Double despesasEducacao) {
        this.despesasEducacao = despesasEducacao;
    }

    public Double getImpostoCalculado() {
        return impostoCalculado;
    }

    public void setImpostoCalculado(Double impostoCalculado) {
        this.impostoCalculado = impostoCalculado;
    }
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

}