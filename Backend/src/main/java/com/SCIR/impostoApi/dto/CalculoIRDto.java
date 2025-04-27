package com.SCIR.impostoApi.dto;

import java.time.LocalDateTime;

public class CalculoIRDto {

    private Long id;
    private Double rendaAnual;
    private Integer dependentes;
    private Double despesasEducacao;
    private Double impostoCalculado;
    private LocalDateTime dataHora;
    private String faixaAliquotaAplicada;


    public CalculoIRDto(){}

    public CalculoIRDto(Double rendaAnual, Integer dependentes, Double despesasEducacao, Double impostoCalculado, LocalDateTime dataHora, Long id, String faixaAliquotaAplicada) {
        this.rendaAnual = rendaAnual;
        this.dependentes = dependentes;
        this.despesasEducacao = despesasEducacao;
        this.impostoCalculado = impostoCalculado;
        this.dataHora = dataHora;
        this.id = id;
        this.faixaAliquotaAplicada = faixaAliquotaAplicada;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFaixaAliquotaAplicada() {
        return faixaAliquotaAplicada;
    }

    public void setFaixaAliquotaAplicada(String faixaAliquotaAplicada) {
        this.faixaAliquotaAplicada = faixaAliquotaAplicada;
    }
}
