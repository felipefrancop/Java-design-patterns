package Questao_3.src;

/**
 * Observador concreto (Concrete Observer) que representa um leitor do site.
 * Ao ser notificado, imprime uma mensagem no console.
 *
 * Decisão de projeto:
 * - Saída no console para simplificar a demonstração (sem interfaces gráficas).
 * - Poderíamos adicionar outros observadores (ex.: envio de e‑mail, push,
 *   log estruturado) sem alterar o sujeito, mantendo o sistema aberto à
 *   extensão (OCP) e fechado à modificação.
 */
public class Leitor implements Observador {

    private final String nome;

    public Leitor(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome nao pode ser vazio");
        }
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void atualizar(String topico, Noticia noticia) {
        System.out.println("[Notificacao] Leitor: " + nome
                + " | Topico: " + topico
                + " | Titulo: " + noticia.getTitulo());
    }
}


