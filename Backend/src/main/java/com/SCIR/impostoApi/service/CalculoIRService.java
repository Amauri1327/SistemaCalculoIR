package com.SCIR.impostoApi.service;

import com.SCIR.impostoApi.dto.CalculoIRDto;
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
        repository.salvar(dto);
    }

    public List<CalculoIRDto> buscarTodos(){
        return repository.buscarTodos();
    }

}
