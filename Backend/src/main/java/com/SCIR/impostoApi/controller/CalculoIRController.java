package com.SCIR.impostoApi.controller;

import com.SCIR.impostoApi.dto.CalculoIRDto;
import com.SCIR.impostoApi.repository.CalculoIRRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculo_ir")
public class CalculoIRController {

    private final CalculoIRRepository repository;

    public CalculoIRController(CalculoIRRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody CalculoIRDto dto) {
        repository.salvar(dto);
        return ResponseEntity.ok().build();
    }



}
