package Questao_3.src;

/**
 * Observador (Observer) do padrão Observer.
 *
 * Responsável por receber notificações de um Assunto (Subject) quando
 * ocorrerem mudanças relevantes (ex.: publicação de uma nova notícia).
 *
 * Decisão de projeto:
 * - O contrato usa tipos simples (String para tópico e {@link Noticia}) para
 *   manter baixo acoplamento com o sujeito e facilitar testes.
 * - O método é "pull-light": o sujeito envia dados suficientes para o
 *   observador reagir sem precisar consultar o sujeito novamente.
 * - Thread-safety não é abordado neste trabalho acadêmico; a implementação
 *   atual assume chamadas síncronas no mesmo thread.
 */
public interface Observador {

    /**
     * Método chamado pelo Assunto para notificar este Observador.
     *
     * @param topico  nome do tópico em que a notícia foi publicada
     * @param noticia dados da notícia publicada
     */
    void atualizar(String topico, Noticia noticia);
}


