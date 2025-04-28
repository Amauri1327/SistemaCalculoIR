package com.SCIR.impostoApi.controller;

import com.SCIR.impostoApi.dto.CalculoIRDto;
import com.SCIR.impostoApi.service.CalculoIRService;
import com.SCIR.impostoApi.service.ImpostoRendaService;
import com.SCIR.impostoApi.service.JasperReportService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/calculo_ir")
public class CalculoIRController {

    private CalculoIRService calculoIRService;
    private ImpostoRendaService impostoRendaService;
    private JasperReportService jasperReportService;

    public CalculoIRController(CalculoIRService calculoIRService, ImpostoRendaService impostoRendaService, JasperReportService jasperReportService) {
        this.calculoIRService = calculoIRService;
        this.impostoRendaService = impostoRendaService;
        this.jasperReportService = jasperReportService;
    }


    @PostMapping
    public ResponseEntity<CalculoIRDto> calcularImpostoESalvar(@RequestBody CalculoIRDto dto) {
        CalculoIRDto resultado = impostoRendaService.calcularImposto(dto);

        try {
            jasperReportService.gerar(resultado);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error ao gerar pdf " + e.getMessage());
        }

        return ResponseEntity.ok(resultado);
    }

//    @PostMapping("/relatorio")
//    public void gerar(@RequestBody CalculoIRDto calculoIRDto) throws FileNotFoundException {
//        this.jasperReportService.gerar(calculoIRDto);
//    }


    @GetMapping
    public ResponseEntity<List<CalculoIRDto>> buscarTodos() {
        List<CalculoIRDto> list = calculoIRService.buscarTodos();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CalculoIRDto> buscarPorId(@PathVariable Long id) {
        CalculoIRDto dto = calculoIRService.buscarPorId(id);
        return ResponseEntity.ok().body(dto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarCalculoIR(@PathVariable Long id, @RequestBody CalculoIRDto dto) {
        calculoIRService.atualizar(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CalculoIRDto> deleteCalculoIr(@PathVariable Long id) {
        calculoIRService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleInvalidInput(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleExceptionInput(RuntimeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }


}
