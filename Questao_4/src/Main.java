import java.util.List;


/**
 * Demonstra a extensão progressiva de funcionalidades com o padrão Decorator.
 */
public class Main {
    public static void main(String[] args) {
        List<Pedido> pedidos = DadosExemplo.gerarPedidosExemplo();

        RelatorioVendas basico = new RelatorioBasico();
        System.out.println("[BÁSICO]\n" + basico.gerar(pedidos));

        RelatorioVendas comEstatisticas = new RelatorioComEstatisticas(basico);
        System.out.println("\n[BÁSICO + ESTATÍSTICAS]\n" + comEstatisticas.gerar(pedidos));

        RelatorioVendas comGraficos = new RelatorioComGraficos(comEstatisticas);
        System.out.println("\n[BÁSICO + ESTATÍSTICAS + GRÁFICOS]\n" + comGraficos.gerar(pedidos));

        String caminhoPdf = "Questao_4/bin/relatorio.pdf";
        RelatorioVendas comPdf = new RelatorioExportarPdf(comGraficos, caminhoPdf);
        String conteudoFinal = comPdf.gerar(pedidos);
        System.out.println("\n[BÁSICO + ESTATÍSTICAS + GRÁFICOS + PDF]\n" + conteudoFinal);
    }
}


