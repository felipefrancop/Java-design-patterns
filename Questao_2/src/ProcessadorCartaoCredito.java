package Questao_2.src;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Implementação concreta do produto para Cartão de Crédito.
 *
 * Responsabilidade:
 * - Encapsula o fluxo específico do cartão (autorização/captura).
 *
 * Observação:
 * - Para fins acadêmicos, apenas simulamos prints.
 */
public class ProcessadorCartaoCredito implements ProcessadorPagamento {

    @Override
    public void processar(DadosPagamento dados) {
        String valorFmt = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR")).format(dados.getValor());
        System.out.println("[Cartão de Crédito] Iniciando processamento..." );
        System.out.println("Valor: " + valorFmt + " | Descrição: " + dados.getDescricao());
        System.out.println("Autorizando transação com a operadora...");
        System.out.println("Pagamento com cartão aprovado e capturado.");
    }

    @Override
    public MeioPagamento meio() {
        return MeioPagamento.CARTAO_DE_CREDITO;
    }
}


