# Questao_3 — Padrão Observer (Publicação/Assinatura por Tópicos)

## Objetivo
Implementar um sistema em que leitores podem se inscrever em tópicos (política, esportes, tecnologia) e sejam notificados automaticamente quando novas notícias forem publicadas nesses tópicos.

## Padrão Escolhido: Observer
Justificativa:
- Precisamos notificar automaticamente vários interessados quando um evento ocorre (publicação de notícia). Esse é o caso clássico de publish/subscribe.
- O Observer desacopla o emissor de eventos (sujeito) dos consumidores (observadores), permitindo inscrição e desinscrição dinâmicas.
- Facilita a extensão: novos tipos de observadores podem ser adicionados sem alterar o sujeito (princípio Aberto/Fechado — OCP).
- Suporta múltiplos tópicos naturalmente por meio de um mapeamento `tópico -> observadores`.

## Arquitetura (pastas e classes)
- `src/Assunto.java`: interface Subject; define `inscrever`, `desinscrever` e `publicar`.
- `src/Observador.java`: interface Observer; define `atualizar(topico, noticia)`.
- `src/TopicoNoticias.java`: sujeito concreto; mantém assinaturas por tópico e notifica observadores ao publicar.
- `src/Leitor.java`: observador concreto; imprime notificações no console quando recebe uma atualização.
- `src/Noticia.java`: entidade imutável com `titulo` e `conteudo`.
- `src/Main.java`: demonstração de uso (inscreve leitores, publica notícias e remove inscrição).

## Decisões de Projeto
- Sem bibliotecas externas e sem UI (console apenas), conforme a proposta do trabalho.
- Estrutura de dados interna do sujeito: `Map<String, Set<Observador>>` para gerenciar inscrições por tópico.
- Validações mínimas: não aceitar observador nulo, tópico vazio ou notícia nula.
- Uso de snapshot na notificação para evitar `ConcurrentModificationException` caso um observador altere inscrições durante a notificação.
- `Noticia` é imutável para preservar integridade após a publicação.

## Como executar
1. Compilar (a partir da pasta do repositório):
   - Windows PowerShell:
     ```bash
     javac -d "Questao_3\\bin" Questao_3\\src\\*.java
     ```
2. Executar:
   ```bash
   java -cp "Questao_3\\bin" Questao_3.src.Main
   ```

## Fluxo de execução (esperado)
- Inscrições:
  - Ana: política, tecnologia
  - Bruno: esportes
  - Carla: política, esportes
- Publicações e resultados:
  - Publica política → notifica Ana e Carla
  - Publica esportes → notifica Bruno e Carla
  - Publica tecnologia → notifica Ana
  - Remove Carla de política e publica política → notifica apenas Ana

## Possíveis extensões futuras (não implementadas)
- Observadores que enviam e‑mail, push notifications ou registram logs estruturados.
- Persistência das inscrições e das notícias (banco de dados).
- Camada de serviços com fila de eventos e processamento assíncrono.


