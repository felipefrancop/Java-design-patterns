package Questao_2.src;

/**
 * Fábrica concreta para criar o processador de Cartão de Crédito.
 *
 * Papel no padrão:
 * - Implementa o Factory Method retornando o produto concreto.
 */
public class CartaoCreditoFactory extends PagamentoFactory {

    @Override
    protected ProcessadorPagamento criarProcessador() {
        return new ProcessadorCartaoCredito();
    }
}


