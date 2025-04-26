package com.SCIR.impostoApi.controller;

import com.SCIR.impostoApi.dto.CalculoIRDto;
import com.SCIR.impostoApi.service.CalculoIRService;
import com.SCIR.impostoApi.service.ImpostoRendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calculo_ir")
public class CalculoIRController {

    private CalculoIRService calculoIRService;
    private ImpostoRendaService impostoRendaService;

    public CalculoIRController(CalculoIRService calculoIRService, ImpostoRendaService impostoRendaService) {
        this.calculoIRService = calculoIRService;
        this.impostoRendaService = impostoRendaService;
    }



//    @PostMapping
//    public ResponseEntity<Void> salvar(@RequestBody CalculoIRDto dto) {
//        service.salvar(dto);
//        return ResponseEntity.ok().build();
//    }

    @PostMapping
    public ResponseEntity<CalculoIRDto> calcularImpostoESalvar(@RequestBody CalculoIRDto dto) {
        CalculoIRDto resultado = impostoRendaService.calcularEGuardar(dto);
        return ResponseEntity.ok(resultado);
    }


    @GetMapping
    public ResponseEntity<List<CalculoIRDto>> buscarTodos() {
        List<CalculoIRDto> list = calculoIRService.buscarTodos();
        return ResponseEntity.ok(list);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleInvalidInput(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }


}
