package Questao_2.src;

/**
 * Produto (Product) do padrão Factory Method.
 * Define a interface comum para todos os processadores de pagamento.
 *
 * Decisão de projeto:
 * - A aplicação cliente depende desta abstração, não das classes concretas,
 *   o que permite trocar o meio de pagamento sem alterar o cliente.
 */
public interface ProcessadorPagamento {

    /**
     * Processa um pagamento com os dados fornecidos.
     * Nesta simulação, apenas imprime o fluxo no console.
     *
     * @param dados dados do pagamento (valor e descrição)
     * @throws IllegalArgumentException se os dados forem inválidos
     */
    void processar(DadosPagamento dados);

    /**
     * Retorna o meio de pagamento deste processador (apenas para logging).
     */
    MeioPagamento meio();
}


