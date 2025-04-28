package com.SCIR.impostoApi.controller;

import com.SCIR.impostoApi.dto.CalculoIRDto;
import com.SCIR.impostoApi.repository.CalculoIRRepository;
import com.SCIR.impostoApi.service.JasperReportService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/report")
public class JasperReportController {

    private final JasperReportService jasperReportService;
    private final CalculoIRRepository calculoIRRepository;

    public JasperReportController(JasperReportService jasperReportService, CalculoIRRepository calculoIRRepository) {
        this.jasperReportService = jasperReportService;
        this.calculoIRRepository = calculoIRRepository;
    }

//    @GetMapping("/gerar-relatorio")
//    public ResponseEntity<byte[]> gerarRelatorio() {
//        try {
//            byte[] pdfBytes = jasperReportService.gerar();
//
//            return ResponseEntity.ok()
//                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=relatorio_imposto.pdf")
//                    .contentType(MediaType.APPLICATION_PDF)
//                    .body(pdfBytes);
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().build();
//        }
//    }

}
