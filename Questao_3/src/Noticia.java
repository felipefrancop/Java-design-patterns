package Questao_3.src;

/**
 * Entidade simples representando uma notícia.
 *
 * Decisão de projeto:
 * - Classe imutável para evitar alterações após a publicação.
 * - Validação mínima no construtor para garantir integridade dos dados.
 * - Pode ser estendida futuramente com autor, data/hora, tags etc., sem
 *   impactar o contrato Observer.
 */
public class Noticia {

    private final String titulo;
    private final String conteudo;

    /**
     * Cria uma notícia com título e conteúdo.
     * @param titulo   título da notícia
     * @param conteudo conteúdo da notícia
     * @throws IllegalArgumentException se campos forem nulos ou vazios
     */
    public Noticia(String titulo, String conteudo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Titulo nao pode ser vazio");
        }
        if (conteudo == null || conteudo.isBlank()) {
            throw new IllegalArgumentException("Conteudo nao pode ser vazio");
        }
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudo() {
        return conteudo;
    }
}


