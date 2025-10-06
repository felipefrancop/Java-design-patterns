package Questao_3.src;

import java.util.Set;

/**
 * Demonstração do recurso de inscrição em tópicos com notificação automática.
 *
 * Padrão de Projeto escolhido: Observer
 * Justificativa:
 * - Precisamos notificar automaticamente diversos leitores (observadores) quando um tópico (assunto) muda.
 * - O Observer desacopla quem muda o estado (TopicoNoticias) de quem reage à mudança (Leitor).
 * - Permite múltiplos tópicos e múltiplos leitores, sem que o site mantenha manualmente listas externas.
 */
public class Main {

    public static void main(String[] args) {
        TopicoNoticias sistema = new TopicoNoticias();

        Leitor ana = new Leitor("Ana");
        Leitor bruno = new Leitor("Bruno");
        Leitor carla = new Leitor("Carla");

        // Inscrições
        sistema.inscrever(ana, Set.of("politica", "tecnologia"));
        sistema.inscrever(bruno, Set.of("esportes"));
        sistema.inscrever(carla, Set.of("politica", "esportes"));

        // Publicações
        sistema.publicar("politica", new Noticia("Reforma aprovada", "Detalhes da votacao..."));
        sistema.publicar("esportes", new Noticia("Final do campeonato", "Time X vence por 2 a 1"));
        sistema.publicar("tecnologia", new Noticia("Novo smartphone lançado", "Especificacoes e preco"));

        // Remover inscricao e publicar novamente
        sistema.desinscrever(carla, Set.of("politica"));
        sistema.publicar("politica", new Noticia("Medida provisoria editada", "Impactos economicos"));
    }
}


