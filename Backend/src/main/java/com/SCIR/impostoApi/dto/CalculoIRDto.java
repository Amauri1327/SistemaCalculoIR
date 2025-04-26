package com.SCIR.impostoApi.dto;

import java.time.LocalDateTime;

public class CalculoIRDto {

    private Double rendaAnual;
    private Integer dependentes;
    private Double despesasEducacao;
    private Double impostoCalculado;
    private LocalDateTime dataHora;

    public CalculoIRDto(){}

    public CalculoIRDto(Double rendaAnual, Integer dependentes, Double despesasEducacao, Double impostoCalculado, LocalDateTime dataHora) {
        this.rendaAnual = rendaAnual;
        this.dependentes = dependentes;
        this.despesasEducacao = despesasEducacao;
        this.impostoCalculado = impostoCalculado;
        this.dataHora = dataHora;
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
