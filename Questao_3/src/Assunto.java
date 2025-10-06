package Questao_3.src;

import java.util.Set;

/**
 * Assunto (Subject) do padrão Observer.
 *
 * Define operações para cadastrar e remover observadores, além de notificar
 * todos os observadores quando uma nova notícia for publicada em um tópico.
 *
 * Decisão de projeto:
 * - API explícita por tópico permite suportar múltiplos canais (política,
 *   esportes, tecnologia) sem que o cliente gerencie listas manualmente.
 * - Inscrições são idempotentes no sujeito concreto: inscrever duas vezes o
 *   mesmo observador no mesmo tópico não duplica notificações.
 * - O contrato não dita detalhes de persistência/armazenamento; isso fica a
 *   cargo do sujeito concreto (ex.: {@code TopicoNoticias}).
 */
public interface Assunto {

    /**
     * Inscreve um observador em um ou mais tópicos.
     *
     * @param observador observador interessado
     * @param topicos    conjunto de tópicos de interesse
     */
    void inscrever(Observador observador, Set<String> topicos);

    /**
     * Cancela a inscrição de um observador em um ou mais tópicos.
     *
     * @param observador observador a ser removido
     * @param topicos    conjunto de tópicos a remover
     */
    void desinscrever(Observador observador, Set<String> topicos);

    /**
     * Publica uma nova notícia em um tópico e notifica os observadores inscritos.
     *
     * @param topico  nome do tópico
     * @param noticia notícia publicada
     */
    void publicar(String topico, Noticia noticia);
}


