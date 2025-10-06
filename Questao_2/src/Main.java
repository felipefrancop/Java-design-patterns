package Questao_2.src;

import java.math.BigDecimal;

/**
 * Exemplo de uso da plataforma de pagamentos empregando o padrão Factory Method.
 *
 * Justificativa da escolha do padrão:
 * - A plataforma precisa instanciar dinamicamente o processador sem conhecer detalhes de criação.
 * - Factory Method delega a criação para fábricas concretas específicas de cada meio.
 * - Reduz acoplamento e facilita a inclusão de novos meios (ex.: "CriptomoedaFactory") sem mudar o cliente.
 *
 * Observação:
 * - Em um cenário real, a escolha do meio poderia vir de linha de comando, variável de ambiente
 *   ou arquivo de configuração. Aqui está fixo para simplificação do trabalho.
 */
public class Main {

    public static void main(String[] args) {
        // Configuração do meio de pagamento pode vir de arquivo, env, args etc.
        MeioPagamento meioEscolhido = MeioPagamento.PIX; // altere para CARTAO_DE_CREDITO ou BOLETO

        // Cliente não conhece detalhes de criação; pede a fábrica adequada
        PagamentoFactory factory = PagamentoFactoryProvider.por(meioEscolhido);
        ProcessadorPagamento processador = factory.obterProcessador();

        // Processa um pagamento de exemplo
        DadosPagamento dados = new DadosPagamento(new BigDecimal("149.90"), "Assinatura mensal");
        System.out.println("Processando via: " + processador.meio());
        processador.processar(dados);
    }
}


