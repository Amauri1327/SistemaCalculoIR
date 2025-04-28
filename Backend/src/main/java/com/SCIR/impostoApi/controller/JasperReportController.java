package com.SCIR.impostoApi.controller;

import com.SCIR.impostoApi.dto.CalculoIRDto;
import com.SCIR.impostoApi.service.JasperReportService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class JasperReportController {

    private final JasperReportService jasperReportService;

    public JasperReportController(JasperReportService jasperReportService) {
        this.jasperReportService = jasperReportService;
    }

    @PostMapping("/gerar-relatoio")
    public void gerarRelatorio(@RequestBody CalculoIRDto calculoIRDto) {
        this.jasperReportService.gerar(calculoIRDto);
    }

}
