# 📄 API de Cálculo de Imposto de Renda

Sistema desenvolvido para calcular o Imposto de Renda, armazenar os resultados e gerar relatórios em PDF.

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot 3
- Spring Web
- Spring Data JPA
- PostgreSQL
- JasperReports
- Maven

---

## 🛠️ Ferramentas usadas
- Intellij idea 2024.2.6
- Jasper report 6.20.0

---
## 🎯 Funcionalidades

- Calcular o Imposto de Renda baseado na renda anual, número de dependentes e despesas com educação.
- Persistir o resultado do cálculo no banco de dados.
- Buscar cálculos individuais ou todos os cálculos.
- Atualizar cálculos existentes.
- Deletar cálculos existentes.
- Gerar relatório em PDF do cálculo realizado.

---

## 📚 Endpoints da API

- `POST /calculo_ir`: Calcula o imposto, salva o cálculo no banco de dados e gera o relatório em PDF.
- `GET /calculo_ir`: Retorna a lista de todos os cálculos realizados.
- `GET /calculo_ir/{id}`: Retorna um cálculo específico pelo ID.
- `PUT /calculo_ir/{id}`: Atualiza um cálculo de imposto existente.
- `DELETE /calculo_ir/{id}`: Deleta um cálculo existente.

---

## 🛢️ Consultas Nativas com JPA

O projeto utiliza consultas nativas SQL através do Spring Data JPA para otimizar a recuperação de dados em determinados cenários, como:

- Buscar cálculos de imposto de renda com informações específicas diretamente do banco de dados.
- Melhorar a performance em operações de leitura.
- Trabalhar diretamente com mapeamentos personalizados de DTOs.

---
## ⚙️ Tratamento de Erros

- `400 Bad Request`: 
  - Dados de entrada inválidos (IllegalArgumentException).
  - Erros durante a geração do relatório em PDF (RuntimeException).

---

