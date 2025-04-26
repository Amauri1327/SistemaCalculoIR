package com.SCIR.impostoApi.model;

public class FaixaIR {

    private double limiteSuperior;
    private double aliquota;
    private double parcelaDeducao;

    public FaixaIR(double limiteSuperior, double aliquota, double parcelaDeducao) {
        this.limiteSuperior = limiteSuperior;
        this.aliquota = aliquota;
        this.parcelaDeducao = parcelaDeducao;
    }

    public double getLimiteSuperior() {
        return limiteSuperior;
    }

    public double getAliquota() {
        return aliquota;
    }

    public double getParcelaDeducao() {
        return parcelaDeducao;
    }
}
