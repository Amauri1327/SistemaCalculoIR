package com.SCIR.impostoApi.service;

import com.SCIR.impostoApi.dto.CalculoIRDto;
import com.SCIR.impostoApi.repository.CalculoIRRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculoIRService {

    private CalculoIRRepository repository;
    public CalculoIRService(CalculoIRRepository repository){
        this.repository = repository;
    }


    public List<CalculoIRDto> buscarTodos(){
        return repository.buscarTodos();
    }

    public CalculoIRDto buscarPorId(Long id){
        return repository.buscarPorId(id);
    }

    public void delete(Long id){
        try {
            repository.delete(id);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Error ao deletar o ID: " + id + " - " + e.getMessage());
        }
    }

    public void atualizar(Long id, CalculoIRDto dto) {
        repository.atualizar(id, dto);
    }



}
