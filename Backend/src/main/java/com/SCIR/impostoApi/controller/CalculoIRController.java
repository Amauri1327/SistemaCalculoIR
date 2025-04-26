package com.SCIR.impostoApi.controller;

import com.SCIR.impostoApi.dto.CalculoIRDto;
import com.SCIR.impostoApi.repository.CalculoIRRepository;
import com.SCIR.impostoApi.service.CalculoIRService;
import jakarta.persistence.GeneratedValue;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calculo_ir")
public class CalculoIRController {

    private CalculoIRService service;

    public CalculoIRController(CalculoIRService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody CalculoIRDto dto) {
        service.salvar(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<CalculoIRDto>> buscarTodos() {
        List<CalculoIRDto> list = service.buscarTodos();
        return ResponseEntity.ok(list);
    }


}
