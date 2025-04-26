package com.SCIR.impostoApi.repository;

import com.SCIR.impostoApi.dto.CalculoIRDto;
import com.SCIR.impostoApi.model.CalculoIR;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

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

    public List<CalculoIRDto> buscarTodos() {
        List<Object[]> resultados = entityManager.createNativeQuery(
                        "SELECT id, renda_anual, dependentes, despesas_educacao, imposto_calculado, data_hora " +
                                "FROM calculo_ir ")
                .getResultList();

        return resultados.stream()
                .map(this::mapearParaDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        if(!existedId(id)){
            throw new RuntimeException("ID não encontrado: " + id);
        }
        entityManager.createNativeQuery("DELETE FROM calculo_ir WHERE id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    public void atualizar(Long id, CalculoIRDto dto) {
        if (!existedId(id)) {
            throw new RuntimeException("ID não encontrado: " + id);
        }
        String sql = "UPDATE calculo_ir " +
                "SET renda_anual = :rendaAnual, " +
                "dependentes = :dependentes, " +
                "despesas_educacao = :despesasEducacao, " +
                "imposto_calculado = :impostoCalculado, " +
                "data_hora = :dataHora " +
                "WHERE id = :id";
        // atualizando
        try {
            entityManager.createNativeQuery(sql)
                    .setParameter("rendaAnual", dto.getRendaAnual())
                    .setParameter("dependentes", dto.getDependentes())
                    .setParameter("despesasEducacao", dto.getDespesasEducacao())
                    .setParameter("impostoCalculado", dto.getImpostoCalculado())
                    .setParameter("dataHora", dto.getDataHora())
                    .setParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Não foi encontrado nenhum registro ID : " + id);
        }

    }


    private boolean existedId(Long id) {
        Long count = (Long) entityManager.createNativeQuery(
                "SELECT COUNT(*) FROM calculo_ir WHERE id = :id")
                .setParameter("id", id)
                .getSingleResult();
        return count > 0;
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
