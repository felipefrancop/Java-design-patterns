## Questão 1 — Cálculo de Tarifas por Modalidade (Factory Method)

### Objetivo
Sistema em Java que calcula tarifas de transporte para três modalidades (terrestre, aéreo e marítimo), cada uma com sua própria regra de cálculo, mantendo o uso genérico no cliente.

### Padrão de Projeto Utilizado: Factory Method
- Por quê?
  - O cliente precisa de um objeto que calcule tarifas, mas não deve conhecer as classes concretas.
  - Encapsula a decisão de criação no "Creator" (`EmpresaLogistica` / `EmpresaLogisticaPadrao`).
  - Facilita a extensão (OCP): adicionar nova modalidade sem alterar o cliente.
- Elementos no código:
  - Product: `CalculadoraTarifa`
  - Concrete Products: `CalculadoraTarifaTerrestre`, `CalculadoraTarifaAerea`, `CalculadoraTarifaMaritima`
  - Creator: `EmpresaLogistica`
  - Concrete Creator: `EmpresaLogisticaPadrao`

### Regras de Cálculo (exemplos didáticos)
- Terrestre: tarifa = (distanciaKm × 1,50) + 10,00
- Aéreo: tarifa = (pesoKg × 12,00) + 50,00
- Marítimo: tarifa = (volumeM3 × 200,00) + 80,00

Cada calculadora valida seus próprios dados de entrada (ex.: distância/peso/volume > 0).

### Estrutura Simples do Projeto
```
Questao_1/
  ├─ src/
  │  ├─ Main.java
  │  ├─ EmpresaLogistica.java
  │  ├─ EmpresaLogisticaPadrao.java
  │  ├─ CalculadoraTarifa.java
  │  ├─ CalculadoraTarifaTerrestre.java
  │  ├─ CalculadoraTarifaAerea.java
  │  ├─ CalculadoraTarifaMaritima.java
  │  ├─ TarifaRequisicao.java
  │  └─ TransporteTipo.java
  └─ bin/
```

### Como Compilar e Executar
No diretório `Questao_1`:
```bash
javac -d bin src/*.java
java -cp bin Main
```

### Pontos de Design (comentados no código)
- Cliente desacoplado de classes concretas (usa `CalculadoraTarifa`).
- Creator concentra a lógica de criação (`EmpresaLogistica`).
- Cada modalidade encapsula sua própria regra e validações.
- Uso de `Builder` em `TarifaRequisicao` para evitar construtores telescópicos.

### Observações Finais
As fórmulas são exemplos didáticos e podem ser ajustadas conforme requisitos de avaliação. O padrão escolhido prioriza clareza, extensibilidade e baixo acoplamento.
