package com.SCIR.impostoApi.service;

import com.SCIR.impostoApi.dto.CalculoIRDto;
import net.sf.jasperreports.engine.*;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JasperReportService {

    public static final String RELATORIOS = "classpath:jasper/relatorios/";
    public static final String ARQUIVOJRXML = "relatorio_ir.jrxml";
    public static final String DESTINOPDF = "C:\\jasper-report\\";

    public void gerar(CalculoIRDto calculoIRDto) throws FileNotFoundException {

        Map<String, Object> params = new HashMap<>();
        // --- Aqui fazemos a conversão do LocalDateTime para Date ---
        Date dataHoraConvertida = Date.from(calculoIRDto.getDataHora()
                .atZone(ZoneId.systemDefault())
                .toInstant());
        params.put("dataHora", dataHoraConvertida);

        params.put("dependentes", calculoIRDto.getDependentes());
        params.put("despesasEducacao", calculoIRDto.getDespesasEducacao());
        params.put("faixaAliquotaAplicada", calculoIRDto.getFaixaAliquotaAplicada());
        params.put("impostoCalculado", calculoIRDto.getImpostoCalculado());
        params.put("rendaAnual", calculoIRDto.getRendaAnual());

        String pathAbsoluto = getAbsolutoPath();
        try {
            String folderDiretorio = getDiretorioSave("relatorio-IR-2025");

            JasperReport report = JasperCompileManager.compileReport(pathAbsoluto);
            JasperPrint print = JasperFillManager.fillReport(report, params, new JREmptyDataSource());
            JasperExportManager.exportReportToPdfFile(print, folderDiretorio);

        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    private String getAbsolutoPath() throws FileNotFoundException {
        return ResourceUtils.getFile(RELATORIOS + ARQUIVOJRXML).getAbsolutePath();
    }

    private String getDiretorioSave(String name) {
        this.createDiretorio(DESTINOPDF);
        return DESTINOPDF + name.concat(".pdf");
    }

    private void createDiretorio(String name) {
        File dir = new File(name);
        if (!dir.exists()) {
            dir.mkdir();
        }
    }
}
