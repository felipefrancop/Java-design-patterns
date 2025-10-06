import java.util.List;

/**
 * Implementação básica do relatório que apenas lista pedidos.
 * 
 * Por separar a funcionalidade mínima em uma classe concreta simples, permite-se
 * decorar (estender) o comportamento sem alterar este código, atendendo ao
 * requisito de extensão progressiva.
 */
public class RelatorioBasico implements RelatorioVendas {

    @Override
    public String gerar(List<Pedido> pedidos) {
        StringBuilder builder = new StringBuilder();
        builder.append("=== Relatório de Vendas (Básico) ===\n");
        if (pedidos == null || pedidos.isEmpty()) {
            builder.append("Sem pedidos.\n");
            return builder.toString();
        }

        builder.append("ID | Cliente | Data | Valor\n");
        for (Pedido p : pedidos) {
            builder
                .append(p.getId()).append(" | ")
                .append(p.getCliente()).append(" | ")
                .append(p.getData()).append(" | ")
                .append(String.format("R$ %.2f", p.getValorTotal()))
                .append('\n');
        }
        return builder.toString();
    }
}


