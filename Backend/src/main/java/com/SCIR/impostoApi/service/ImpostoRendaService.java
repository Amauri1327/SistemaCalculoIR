package com.SCIR.impostoApi.service;

import com.SCIR.impostoApi.dto.CalculoIRDto;
import com.SCIR.impostoApi.model.CalculoIR;
import com.SCIR.impostoApi.repository.CalculoIRRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ImpostoRendaService {

    private CalculoIRRepository repository;

    public ImpostoRendaService(CalculoIRRepository repository){
        this.repository = repository;
    }

    public CalculoIRDto calcularImposto(CalculoIRDto dto) {
        double rendaAnual = dto.getRendaAnual();
        int dependentes = dto.getDependentes();
        double despesasEducacao = dto.getDespesasEducacao();

        // Dedução anual
        double deducaoDependentes = dependentes * 2275.08;
        double deducaoEducacao = Math.min(despesasEducacao, 3561.50);

        // Base de cálculo anual
        double baseAnual = rendaAnual - (deducaoDependentes + deducaoEducacao);
        double baseMensal = baseAnual / 12;

        double aliquota = 0.0;
        double parcelaDeduzir = 0.0;
        String faixa = "";

        if (baseMensal <= 1903.98) {
            aliquota = 0.0;
            parcelaDeduzir = 0.0;
            faixa = "Isento";
        } else if (baseMensal <= 2826.65) {
            aliquota = 0.075;
            parcelaDeduzir = 142.80;
            faixa = "7,5%";
        } else if (baseMensal <= 3751.05) {
            aliquota = 0.15;
            parcelaDeduzir = 354.80;
            faixa = "15%";
        } else if (baseMensal <= 4664.68) {
            aliquota = 0.225;
            parcelaDeduzir = 636.13;
            faixa = "22,5%";
        } else {
            aliquota = 0.275;
            parcelaDeduzir = 869.36;
            faixa = "27,5%";
        }

        double impostoMensal = (baseMensal * aliquota) - parcelaDeduzir;
        if (impostoMensal < 0) impostoMensal = 0.0;

        // Arredondamento para 2 casas decimais
        impostoMensal = Math.round(impostoMensal * 100.0) / 100.0;

        // Cálculo do imposto anual
        double impostoAnual = Math.round(impostoMensal * 12 * 100.0) / 100.0;

        // Preenche o DTO com o resultado do cálculo
        dto.setImpostoCalculado(impostoAnual);
        dto.setFaixaAliquotaAplicada(faixa);
        dto.setDataHora(LocalDateTime.now());

        CalculoIR calculoIR = new CalculoIR(
                dto.getId(),
                dto.getRendaAnual(),
                dto.getDependentes(),
                dto.getDespesasEducacao(),
                dto.getImpostoCalculado(),
                dto.getDataHora(),
                dto.getFaixaAliquotaAplicada()
        );
        repository.salvar(calculoIR);

        return dto;
    }


}
