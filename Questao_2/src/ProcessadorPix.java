package Questao_2.src;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Implementação concreta do produto para PIX.
 *
 * Responsabilidade:
 * - Encapsula o fluxo específico de PIX (chave/QR Code e confirmação).
 *
 * Observação:
 * - Simulação por prints, sem integração com APIs externas.
 */
public class ProcessadorPix implements ProcessadorPagamento {

    @Override
    public void processar(DadosPagamento dados) {
        String valorFmt = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR")).format(dados.getValor());
        System.out.println("[PIX] Gerando QR Code...");
        System.out.println("Valor: " + valorFmt + " | Descrição: " + dados.getDescricao());
        String chave = "pix+felipe@exemplo.com"; // mock
        System.out.println("Chave PIX: " + chave);
        System.out.println("Transação confirmada instantaneamente.");
    }

    @Override
    public MeioPagamento meio() {
        return MeioPagamento.PIX;
    }
}


