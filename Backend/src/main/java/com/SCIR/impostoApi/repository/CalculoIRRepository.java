package com.SCIR.impostoApi.repository;

import com.SCIR.impostoApi.dto.CalculoIRDto;
import com.SCIR.impostoApi.model.CalculoIR;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CalculoIRRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void salvar(CalculoIR calculoIR) {
        entityManager.persist(calculoIR);
    }

//    @Transactional
//    public void salvar (CalculoIRDto dto) {
//        entityManager.createNativeQuery(
//                "INSERT INTO calculo_ir (renda_anual, dependentes, despesas_educacao, imposto_calculado, data_hora)" +
//                        "VALUES (:rendaAnual, :dependentes, :despesasEducacao, :impostoCalculado, :dataHora)")
//                .setParameter("rendaAnual", dto.getRendaAnual())
//                .setParameter("dependentes", dto.getDependentes())
//                .setParameter("despesasEducacao", dto.getDespesasEducacao())
//                .setParameter("impostoCalculado", dto.getImpostoCalculado())
//                .setParameter("dataHora", LocalDateTime.now())
//                .executeUpdate();
//    }

    public List<CalculoIRDto> buscarTodos() {
        List<Object[]> resultados = entityManager.createNativeQuery(
                        "SELECT id, renda_anual, dependentes, despesas_educacao, imposto_calculado, data_hora " +
                                "FROM calculo_ir ")
                .getResultList();

        return resultados.stream()
                .map(this::mapearParaDto)
                .collect(Collectors.toList());
    }

    private CalculoIRDto mapearParaDto(Object[] registro) {
        CalculoIRDto dto = new CalculoIRDto();
        dto.setId((Long) registro[0]);
        dto.setRendaAnual((Double) registro[1]);
        dto.setDependentes((Integer) registro[2]);
        dto.setDespesasEducacao((Double) registro[3]);
        dto.setImpostoCalculado((Double) registro[4]);
        dto.setDataHora(((java.sql.Timestamp) registro[5]).toLocalDateTime());
        return dto;
    }




}
