package com.SCIR.impostoApi.model;

import java.util.Arrays;
import java.util.List;

public class TabelaIR {
    // TABELA IR 2025

    public static List<FaixaIR> getFaixas(){
        return Arrays.asList(
                new FaixaIR(1903.98, 0.0, 0.0),
                new FaixaIR(2826.65, 0.075, 142.80),
                new FaixaIR(3751.05, 0.15, 354.80),
                new FaixaIR(4664.68, 0.225, 636.13),
                new FaixaIR(Double.MAX_VALUE, 0.275, 869.36)
        );
    }

    public static double getDeducaoPorDependentes() {
        return 2275.08;
    }

    public static double getLimiteEducacao() {
        return 3561.50;
    }



}
