package com.SCIR.impostoApi.service;

import com.SCIR.impostoApi.dto.CalculoIRDto;
import com.SCIR.impostoApi.model.CalculoIR;
import com.SCIR.impostoApi.repository.CalculoIRRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculoIRService {

    private CalculoIRRepository repository;

    public CalculoIRService(CalculoIRRepository repository) {
        this.repository = repository;
    }

    public void salvar(CalculoIRDto dto) {
        CalculoIR calculoIR = new CalculoIR();
        calculoIR.setRendaAnual(dto.getRendaAnual());
        calculoIR.setDependentes(dto.getDependentes());
        calculoIR.setDespesasEducacao(dto.getDespesasEducacao());
        calculoIR.setImpostoCalculado(dto.getImpostoCalculado());
        calculoIR.setDataHora(dto.getDataHora());

        // Salvando a entidade no repositório
        repository.salvar(calculoIR);
    }

    public List<CalculoIRDto> buscarTodos(){
        return repository.buscarTodos();
    }

}
