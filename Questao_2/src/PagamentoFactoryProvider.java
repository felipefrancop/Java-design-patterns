package Questao_2.src;

/**
 * Classe auxiliar para escolher a fábrica com base no meio configurado.
 * Evita que a aplicação principal faça if/else de criação.
 *
 * Observação de projeto:
 * - Centralizar essa decisão aqui mantém o cliente (Main) limpo e simples.
 * - Se no futuro a escolha vier de arquivo .properties, env, BD, basta ajustar aqui.
 */
public final class PagamentoFactoryProvider {

    private PagamentoFactoryProvider() {}

    public static PagamentoFactory por(MeioPagamento meio) {
        if (meio == null) {
            throw new IllegalArgumentException("Meio de pagamento não pode ser nulo.");
        }
        switch (meio) {
            case CARTAO_DE_CREDITO:
                return new CartaoCreditoFactory();
            case BOLETO:
                return new BoletoFactory();
            case PIX:
                return new PixFactory();
            default:
                throw new IllegalArgumentException("Meio de pagamento não suportado: " + meio);
        }
    }
}


