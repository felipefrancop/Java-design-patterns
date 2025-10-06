package Questao_2.src;

/**
 * Fábrica concreta para criar o processador de PIX.
 *
 * Papel no padrão:
 * - Implementa o Factory Method retornando o produto concreto.
 */
public class PixFactory extends PagamentoFactory {

    @Override
    protected ProcessadorPagamento criarProcessador() {
        return new ProcessadorPix();
    }
}


