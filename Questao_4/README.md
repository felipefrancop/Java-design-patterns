# Questão 4 — Relatórios com extensão progressiva (Decorator)

## Objetivo
Sistema de pedidos que gera relatórios de vendas com funcionalidades opcionais adicionadas de forma flexível, sem alterar o relatório básico.

## Padrão escolhido: Decorator
- Permite adicionar responsabilidades dinamicamente a um objeto `Relatorio` existente.
- Atende ao princípio Aberto/Fechado (Open-Closed, SOLID): novas funcionalidades (estatísticas, gráficos, exportar PDF) são implementadas como novos decoradores, sem modificar o código do relatório básico.
- Evita heranças rígidas com muitas subclasses combinando funcionalidades; a composição de decoradores é feita em tempo de execução.

## Estrutura
- `src/Relatorio.java`: interface do relatório.
- `src/RelatorioBasico.java`: lista pedidos (implementação mínima).
- `src/RelatorioDecorator.java`: base para decoradores.
- `src/RelatorioComEstatisticas.java`: adiciona estatísticas de faturamento.
- `src/RelatorioComGraficos.java`: adiciona gráfico ASCII por faixa de valores.
- `src/RelatorioExportarPdf.java`: simula exportação em PDF (grava texto em `.pdf`).
- `src/Pedido.java`: modelo de pedido.
- `src/DadosExemplo.java`: pedidos de exemplo.
- `src/Main.java`: demonstração de extensão progressiva.

## Como compilar
Dentro da pasta do projeto (onde está esta pasta `Questao_4`):

```bash
javac -d Questao_4/bin Questao_4/src/*.java
```

## Como executar

```bash
java -cp Questao_4/bin Main
```

O programa também salvará um arquivo `Questao_4/bin/relatorio.pdf` contendo o conteúdo textual do relatório (simulação de PDF).

## Observações de projeto
- O relatório básico não é alterado quando novas funcionalidades são adicionadas.
- A ordem dos decoradores pode ser combinada conforme necessidade.
- A exportação para PDF é apenas uma simulação sem bibliotecas externas, suficiente para fins acadêmicos.


