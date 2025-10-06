package Questao_2.src;

/**
 * Fábrica concreta para criar o processador de Boleto.
 *
 * Papel no padrão:
 * - Implementa o Factory Method retornando o produto concreto.
 */
public class BoletoFactory extends PagamentoFactory {

    @Override
    protected ProcessadorPagamento criarProcessador() {
        return new ProcessadorBoleto();
    }
}


