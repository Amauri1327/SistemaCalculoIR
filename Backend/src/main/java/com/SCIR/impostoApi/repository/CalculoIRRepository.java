package com.SCIR.impostoApi.repository;

import com.SCIR.impostoApi.dto.CalculoIRDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class CalculoIRRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void salvar (CalculoIRDto dto) {
        entityManager.createNativeQuery(
                "INSERT INTO calculo_ir (renda_anual, dependentes, despesas_educacao, imposto_calculado, data_hora)" +
                        "VALUES (:rendaAnual, :dependentes, :despesasEducacao, :impostoCalculado, :dataHora)")
                .setParameter("rendaAnual", dto.getRendaAnual())
                .setParameter("dependentes", dto.getDependentes())
                .setParameter("despesasEducacao", dto.getDespesasEducacao())
                .setParameter("impostoCalculado", dto.getImpostoCalculado())
                .setParameter("dataHora", LocalDateTime.now())
                .executeUpdate();
    }



}
