# 📚 Padrões de Projeto - Avaliação Prática

Este repositório contém a implementação de 5 padrões de projeto em Java, desenvolvidos como parte de uma avaliação prática de programação orientada a objetos.

## 🎯 Objetivo

Demonstrar a aplicação correta de diferentes padrões de projeto (Design Patterns) através de implementações práticas em Java, focando na compreensão dos conceitos e na qualidade do código.

## 📋 Questões Implementadas

### [Questão 1 - Factory Method: Sistema de Cálculo de Tarifas](Questao_1/)
**Padrão:** Factory Method  
**Contexto:** Empresa de logística com diferentes modalidades de transporte (terrestre, aéreo, marítimo)  
**Foco:** Desacoplamento da criação de calculadoras de tarifa por modalidade

### [Questão 2 - Factory Method: Plataforma de Pagamentos](Questao_2/)
**Padrão:** Factory Method  
**Contexto:** Sistema de pagamentos com múltiplos meios (cartão, boleto, PIX)  
**Foco:** Instanciação dinâmica de processadores sem conhecimento dos detalhes de criação

### [Questão 3 - Observer: Sistema de Notícias](Questao_3/)
**Padrão:** Observer  
**Contexto:** Site de notícias com inscrição em tópicos (política, esportes, tecnologia)  
**Foco:** Notificação automática de leitores quando novas notícias são publicadas

### [Questão 4 - Decorator: Relatórios Extensíveis](Questao_4/)
**Padrão:** Decorator  
**Contexto:** Sistema de pedidos com relatórios progressivamente extensíveis  
**Foco:** Adição de funcionalidades (estatísticas, gráficos, PDF) sem alterar código existente

### [Questão 5 - Prototype: Documentos Personalizáveis](Questao_5/)
**Padrão:** Prototype  
**Contexto:** Empresa de design com modelos de documentos (currículos, propostas, relatórios)  
**Foco:** Clonagem rápida de documentos com personalização de cores, fontes e logotipos

## 🏗️ Estrutura do Projeto

```
📁 Padroes de Projeto/
├── 📄 README.md (este arquivo)
├── 📁 Questao_1/          # Factory Method - Tarifas
│   ├── 📄 README.md
│   ├── 📁 src/
│   └── 📁 bin/
├── 📁 Questao_2/          # Factory Method - Pagamentos
│   ├── 📄 README.md
│   ├── 📁 src/
│   └── 📁 bin/
├── 📁 Questao_3/          # Observer - Notícias
│   ├── 📄 README.md
│   ├── 📁 src/
│   └── 📁 bin/
├── 📁 Questao_4/          # Decorator - Relatórios
│   ├── 📄 README.md
│   ├── 📁 src/
│   └── 📁 bin/
└── 📁 Questao_5/          # Prototype - Documentos
    ├── 📄 README.md
    ├── 📁 src/
    └── 📁 bin/
```

## 🚀 Como Executar

Cada questão possui suas próprias instruções de compilação e execução. Acesse a pasta da questão desejada e consulte o README específico.

### Compilação Geral (Windows PowerShell)
```bash
# Compilar todas as questões
javac -d Questao_1/bin Questao_1/src/*.java
javac -d Questao_2/bin Questao_2/src/*.java
javac -d Questao_3/bin Questao_3/src/*.java
javac -d Questao_4/bin Questao_4/src/*.java
javac -d Questao_5/bin Questao_5/src/*.java
```

### Execução por Questão
```bash
# Questão 1 - Tarifas
java -cp Questao_1/bin Main

# Questão 2 - Pagamentos
java -cp Questao_2/bin Questao_2.src.Main

# Questão 3 - Notícias
java -cp Questao_3/bin Questao_3.src.Main

# Questão 4 - Relatórios
java -cp Questao_4/bin Main

# Questão 5 - Documentos
java -cp Questao_5/bin Main
```

## 🎨 Padrões de Projeto Utilizados

| Padrão | Questão | Propósito |
|--------|---------|-----------|
| **Factory Method** | 1, 2 | Desacoplar criação de objetos do código cliente |
| **Observer** | 3 | Notificação automática entre objetos |
| **Decorator** | 4 | Adicionar responsabilidades dinamicamente |
| **Prototype** | 5 | Criar objetos através de clonagem |

## 📖 Características do Projeto

- ✅ **Java Puro**: Sem bibliotecas externas
- ✅ **Console Only**: Sem interfaces gráficas
- ✅ **Bem Documentado**: Comentários explicativos em todo código
- ✅ **Princípios SOLID**: Aplicados em todas as implementações
- ✅ **Extensibilidade**: Fácil adicionar novas funcionalidades
- ✅ **Qualidade**: Código limpo e organizado

## 🎓 Aprendizados Demonstrados

- Compreensão profunda dos padrões de projeto
- Aplicação correta dos princípios SOLID
- Arquitetura de software bem estruturada
- Documentação técnica de qualidade
- Separação de responsabilidades
- Desacoplamento entre componentes

## 📝 Observações

Este projeto foi desenvolvido como avaliação prática, focando na aplicação correta dos padrões de projeto sem complexidade desnecessária. Cada implementação prioriza a clareza e a didática, mantendo o código simples mas demonstrando os conceitos fundamentais.

---

**Desenvolvido por:** Felipe Franco Pinheiro | **RGM:** 28839111
 
