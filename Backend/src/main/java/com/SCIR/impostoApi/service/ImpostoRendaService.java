package com.SCIR.impostoApi.service;

import com.SCIR.impostoApi.dto.CalculoIRDto;
import com.SCIR.impostoApi.model.CalculoIR;
import com.SCIR.impostoApi.model.FaixaIR;
import com.SCIR.impostoApi.model.TabelaIR;
import com.SCIR.impostoApi.repository.CalculoIRRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ImpostoRendaService {

    private CalculoIRRepository repository;

    public ImpostoRendaService(CalculoIRRepository repository){
        this.repository = repository;
    }

    private List<FaixaIR> faixas = TabelaIR.getFaixas();

    public CalculoIRDto calcularEGuardar(CalculoIRDto dto) {
        if (dto.getRendaAnual() < 0 || dto.getDependentes() < 0 || dto.getDespesasEducacao() < 0) {
            throw new IllegalArgumentException("Valores inválidos: Renda Anual, Dependentes e Despesas de Educação não podem ser negativos.");
        }

        double impostoAnual = calcularImposto(dto);

        dto.setImpostoCalculado(impostoAnual);
        dto.setDataHora(LocalDateTime.now());

        // Converter DTO para a entidade CalculoIR
        CalculoIR calculoIR = new CalculoIR();
        calculoIR.setRendaAnual(dto.getRendaAnual());
        calculoIR.setDependentes(dto.getDependentes());
        calculoIR.setDespesasEducacao(dto.getDespesasEducacao());
        calculoIR.setImpostoCalculado(dto.getImpostoCalculado());
        calculoIR.setDataHora(dto.getDataHora());

        // Salvar a entidade no banco
        repository.salvar(calculoIR);

        // Atualizar o DTO com o ID gerado no banco de dados
        dto.setId(calculoIR.getId());

        return dto;
    }


    private double calcularImposto(CalculoIRDto dto) {
        double rendaAnual = dto.getRendaAnual();
        int dependentes = dto.getDependentes();
        double despesasEducacao = dto.getDespesasEducacao();

        double deducaoPorDependente = TabelaIR.getDeducaoPorDependentes();
        double limiteEducacao = TabelaIR.getLimiteEducacao();

        double despesasEducaoLimitada = Math.min(despesasEducacao, limiteEducacao);

        // Calculando a renda liquida anual
        double rendaLiquidaAnual = rendaAnual - (dependentes * deducaoPorDependente) - despesasEducaoLimitada;

        // procurando faixa IR certa
        FaixaIR faixaAplicavel = faixas.stream()
                .filter(faixa -> rendaLiquidaAnual <= faixa.getLimiteSuperior())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Faixa de imposto não encontrada"));

        // Calculando imposto anual
        double impostoAnual = (rendaLiquidaAnual * faixaAplicavel.getAliquota()) - faixaAplicavel.getParcelaDeducao();

        return Math.max(impostoAnual, 0.0);
    }

}
