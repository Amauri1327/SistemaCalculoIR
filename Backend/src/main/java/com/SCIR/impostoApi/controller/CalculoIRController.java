package com.SCIR.impostoApi.controller;

import com.SCIR.impostoApi.dto.CalculoIRDto;
import com.SCIR.impostoApi.repository.CalculoIRRepository;
import jakarta.persistence.GeneratedValue;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<CalculoIRDto>> buscarTodos() {
        List<CalculoIRDto> list = repository.buscarTodos();
        return ResponseEntity.ok(list);
    }


}
