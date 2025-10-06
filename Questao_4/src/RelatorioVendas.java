import java.util.List;

/**
 * Interface do relatório de vendas.
 * 
 * Padrão Decorator: permite adicionar funcionalidades (estatísticas, gráficos,
 * exportação) sem alterar o relatório básico.
 */
public interface RelatorioVendas {

    /**
     * Gera a representação textual do relatório para a lista de pedidos dada.
     * @param pedidos lista de pedidos a serem reportados
     * @return texto do relatório
     */
    String gerar(List<Pedido> pedidos);
}


