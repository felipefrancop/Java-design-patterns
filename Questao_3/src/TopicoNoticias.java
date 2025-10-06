package Questao_3.src;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Sujeito concreto (Concrete Subject) do padrão Observer.
 *
 * Mantém o mapeamento de tópicos para seus observadores e realiza a notificação
 * automática quando uma nova notícia é publicada.
 *
 * Justificativa do padrão Observer neste contexto:
 * - O site publica notícias (eventos) e leitores reagem a esses eventos.
 * - O Observer desacopla a publicação da reação, permitindo inscrição dinâmica
 *   em múltiplos tópicos sem o site manter listas manuais em código cliente.
 *
 * Decisões de projeto:
 * - Estrutura interna: {@code Map<String, Set<Observador>>} para rápida
 *   localização dos observadores por tópico.
 * - Notificação usa um snapshot (cópia do Set) para evitar
 *   ConcurrentModificationException caso um observador altere inscrições
 *   durante a notificação.
 * - Complexidade: inscrever/remover é O(1) amortizado; notificar é O(n) no
 *   número de observadores do tópico, adequado ao objetivo do trabalho.
 * - Sem dependências externas e sem UI, conforme exigido.
 */
public class TopicoNoticias implements Assunto {

    private final Map<String, Set<Observador>> topicoParaObservadores = new HashMap<>();

    @Override
    public void inscrever(Observador observador, Set<String> topicos) {
        if (observador == null) {
            throw new IllegalArgumentException("Observador nao pode ser nulo");
        }
        if (topicos == null || topicos.isEmpty()) {
            throw new IllegalArgumentException("Informe ao menos um topico");
        }
        for (String topico : topicos) {
            if (topico == null || topico.isBlank()) {
                continue;
            }
            topicoParaObservadores
                .computeIfAbsent(topico, k -> new HashSet<>())
                .add(observador);
        }
    }

    @Override
    public void desinscrever(Observador observador, Set<String> topicos) {
        if (observador == null || topicos == null || topicos.isEmpty()) {
            return;
        }
        for (String topico : topicos) {
            Set<Observador> grupo = topicoParaObservadores.get(topico);
            if (grupo != null) {
                grupo.remove(observador);
                if (grupo.isEmpty()) {
                    topicoParaObservadores.remove(topico);
                }
            }
        }
    }

    @Override
    public void publicar(String topico, Noticia noticia) {
        if (topico == null || topico.isBlank()) {
            throw new IllegalArgumentException("Topico invalido");
        }
        if (noticia == null) {
            throw new IllegalArgumentException("Noticia nao pode ser nula");
        }
        Set<Observador> grupo = topicoParaObservadores.get(topico);
        if (grupo == null || grupo.isEmpty()) {
            return; // sem inscritos neste topico
        }
        // Evita ConcurrentModificationException caso algum observador altere inscricoes durante notificacao
        Set<Observador> snapshot = new HashSet<>(grupo);
        for (Observador obs : snapshot) {
            obs.atualizar(topico, noticia);
        }
    }
}


