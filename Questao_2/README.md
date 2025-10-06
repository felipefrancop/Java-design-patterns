## Questão 2 — Plataforma de Pagamentos (Factory Method)

### Objetivo
Permitir a integração com diferentes meios de pagamento (cartão de crédito, boleto e PIX),
onde a escolha do meio é configurável e a aplicação não conhece os detalhes de criação
dos processadores.

### Padrão Escolhido: Factory Method
Escolhi o Factory Method porque o requisito central é desacoplar a criação do objeto
concreto do código cliente. O cliente sabe apenas que precisa de um `ProcessadorPagamento`,
mas quem decide “qual” processador entregar é uma fábrica concreta, com base na
configuração (`MeioPagamento`).

Benefícios aplicados:
- Desacoplamento: o cliente depende da interface `ProcessadorPagamento`, não de classes concretas.
- Configuração dinâmica: a seleção do meio em tempo de execução não muda o cliente.
- Extensibilidade (OCP): adicionar um novo meio não exige mudar o cliente; cria-se um novo
  `Processador...` e uma fábrica concreta.
- Responsabilidade única (SRP): a criação fica na fábrica; o cliente apenas usa o processador.

### Mapa das classes (Factory Method)
- Product: `src/ProcessadorPagamento.java`
- Concrete Products: `src/ProcessadorCartaoCredito.java`, `src/ProcessadorBoleto.java`, `src/ProcessadorPix.java`
- Creator: `src/PagamentoFactory.java`
- Concrete Creators: `src/CartaoCreditoFactory.java`, `src/BoletoFactory.java`, `src/PixFactory.java`
- Suporte à configuração: `src/MeioPagamento.java` e `src/PagamentoFactoryProvider.java`
- Cliente: `src/Main.java`

### Como executar
Dentro da pasta `Questao_2`:

Compilação (gera em `bin`):
```bash
javac -d bin src/*.java
```

Execução:
```bash
java -cp bin Questao_2.src.Main
```

Para alterar o meio de pagamento, edite `src/Main.java` e mude a variável
`meioEscolhido` para `CARTAO_DE_CREDITO`, `BOLETO` ou `PIX`.

### Como estender (exemplo: Criptomoeda)
1. Criar `src/ProcessadorCriptomoeda.java` implementando `ProcessadorPagamento`.
2. Criar `src/CriptomoedaFactory.java` estendendo `PagamentoFactory` e retornando seu processador.
3. Adicionar `CRIPTOMOEDA` no `src/MeioPagamento.java`.
4. Atualizar o `src/PagamentoFactoryProvider.java` para mapear `CRIPTOMOEDA -> CriptomoedaFactory`.
5. O `Main` permanece igual; só mude o `MeioPagamento`.

### Observações finais
- O foco do trabalho está no padrão de criação; não há UI ou bibliotecas externas.
- Os fluxos de pagamento foram simulados com `System.out.println` para simplificar.

