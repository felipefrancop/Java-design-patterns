package Questao_2.src;

/**
 * Creator (Fabricante) do padrão Factory Method.
 * Define o método de fábrica que retorna um ProcessadorPagamento.
 *
 * Justificativa do padrão:
 * - A aplicação precisa instanciar dinamicamente o processador correto sem conhecer os detalhes de criação.
 * - Com Factory Method, encapsulamos a lógica de criação em subclasses, reduzindo acoplamento ao cliente.
 * - Segue OCP (Aberto/Fechado): para um novo meio de pagamento, cria-se uma nova fábrica concreta
 *   sem alterar o cliente.
 * - Segue SRP (Responsabilidade Única): a responsabilidade de "criar" fica concentrada nas fábricas,
 *   enquanto o cliente foca só em "usar" o processador.
 *
 * Como extender:
 * - Crie uma nova classe que estenda PagamentoFactory (ex.: CriptomoedaFactory) e retorne
 *   o novo Processador no método criarProcessador().
 * - Atualize o PagamentoFactoryProvider para mapear o novo MeioPagamento para sua fábrica.
 */
public abstract class PagamentoFactory {

    /**
     * Factory Method a ser implementado pelas fábricas concretas.
     */
    protected abstract ProcessadorPagamento criarProcessador();

    /**
     * Método template que pode realizar passos comuns antes/depois da criação.
     * Aqui apenas retorna o processador criado pelo Factory Method.
     * Em cenários reais, poderia configurar logs, métricas ou validações comuns.
     */
    public ProcessadorPagamento obterProcessador() {
        return criarProcessador();
    }
}


