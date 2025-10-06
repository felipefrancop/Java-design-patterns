package Questao_2.src;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

/**
 * Implementação concreta do produto para Boleto Bancário.
 *
 * Responsabilidade:
 * - Encapsula a geração de boleto (linha digitável, vencimento etc.).
 *
 * Observação:
 * - Aqui está tudo mockado para simplificação acadêmica.
 */
public class ProcessadorBoleto implements ProcessadorPagamento {

    @Override
    public void processar(DadosPagamento dados) {
        String valorFmt = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR")).format(dados.getValor());
        System.out.println("[Boleto] Gerando boleto...");
        System.out.println("Valor: " + valorFmt + " | Descrição: " + dados.getDescricao());
        String linhaDigitavel = "34191.79001 01043.510047 91020.150008 7 12340000000000"; // mock
        System.out.println("Linha Digitável: " + linhaDigitavel);
        System.out.println("Vencimento: " + LocalDate.now().plusDays(3));
        System.out.println("Boleto gerado com sucesso.");
    }

    @Override
    public MeioPagamento meio() {
        return MeioPagamento.BOLETO;
    }
}


