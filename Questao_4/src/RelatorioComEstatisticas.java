import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * Decorador que acrescenta estatísticas de faturamento ao relatório.
 */
public class RelatorioComEstatisticas extends RelatorioDecorator {

    public RelatorioComEstatisticas(RelatorioVendas relatorio) {
        super(relatorio);
    }

    @Override
    public String gerar(List<Pedido> pedidos) {
        String base = super.gerar(pedidos);
        StringBuilder builder = new StringBuilder(base);
        builder.append("\n--- Estatísticas ---\n");
        if (pedidos == null || pedidos.isEmpty()) {
            builder.append("Sem dados para estatísticas.\n");
            return builder.toString();
        }

        DoubleSummaryStatistics stats = pedidos.stream()
                .mapToDouble(Pedido::getValorTotal)
                .summaryStatistics();

        builder.append("Quantidade de pedidos: ").append(stats.getCount()).append('\n');
        builder.append("Faturamento total: ")
                .append(String.format("R$ %.2f", stats.getSum())).append('\n');
        builder.append("Ticket médio: ")
                .append(String.format("R$ %.2f", stats.getAverage())).append('\n');
        builder.append("Menor pedido: ")
                .append(String.format("R$ %.2f", stats.getMin())).append('\n');
        builder.append("Maior pedido: ")
                .append(String.format("R$ %.2f", stats.getMax())).append('\n');

        return builder.toString();
    }
}


