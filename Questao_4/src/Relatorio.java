import java.util.List;

/**
 * Interface do relatório.
 * 
 * Decisão de projeto: utilizamos o padrão Decorator para permitir a extensão
 * progressiva e flexível de funcionalidades do relatório sem modificar o
 * código do relatório básico. Cada funcionalidade extra será implementada
 * como um decorador que envolve um {@link Relatorio} existente.
 */
public interface Relatorio {

    /**
     * Gera a representação textual do relatório para a lista de pedidos dada.
     * @param pedidos lista de pedidos a serem reportados
     * @return texto do relatório
     */
    String gerar(List<Pedido> pedidos);
}


