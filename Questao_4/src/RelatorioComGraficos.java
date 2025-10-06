import java.util.List;

/**
 * Decorador que acrescenta uma visualização gráfica simples (ASCII) por faixa de valores.
 * Não utiliza bibliotecas externas, apenas uma aproximação textual.
 */
public class RelatorioComGraficos extends RelatorioDecorator {

    public RelatorioComGraficos(RelatorioVendas relatorio) {
        super(relatorio);
    }

    @Override
    public String gerar(List<Pedido> pedidos) {
        String base = super.gerar(pedidos);
        StringBuilder builder = new StringBuilder(base);
        builder.append("\n--- Gráfico (faixas por valor) ---\n");
        if (pedidos == null || pedidos.isEmpty()) {
            builder.append("Sem dados para gráficos.\n");
            return builder.toString();
        }

        int ate100 = 0, ate500 = 0, ate1000 = 0, acima1000 = 0;
        for (Pedido p : pedidos) {
            double v = p.getValorTotal();
            if (v <= 100) ate100++;
            else if (v <= 500) ate500++;
            else if (v <= 1000) ate1000++;
            else acima1000++;
        }

        builder.append(String.format("<= 100:   %s (%d)\n", barra(ate100), ate100));
        builder.append(String.format("<= 500:   %s (%d)\n", barra(ate500), ate500));
        builder.append(String.format("<= 1000:  %s (%d)\n", barra(ate1000), ate1000));
        builder.append(String.format("> 1000:   %s (%d)\n", barra(acima1000), acima1000));
        return builder.toString();
    }

    private String barra(int quantidade) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < quantidade; i++) sb.append('#');
        return sb.toString();
    }
}


