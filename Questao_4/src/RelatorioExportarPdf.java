import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Decorador que simula exportação do conteúdo do relatório para PDF.
 * Para não usar bibliotecas, grava um arquivo .pdf com texto simples.
 */
public class RelatorioExportarPdf extends RelatorioDecorator {

    private final String caminhoArquivo;

    public RelatorioExportarPdf(RelatorioVendas relatorio, String caminhoArquivo) {
        super(relatorio);
        this.caminhoArquivo = caminhoArquivo;
    }

    @Override
    public String gerar(List<Pedido> pedidos) {
        String conteudo = super.gerar(pedidos);
        // Simulação: escreve o conteúdo em um arquivo com extensão .pdf
        File file = new File(caminhoArquivo);
        File parent = file.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(conteudo.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            conteudo += "\n[ERRO] Falha ao exportar PDF: " + e.getMessage();
            return conteudo;
        }
        return conteudo + "\n[OK] Relatório exportado para PDF em: " + file.getAbsolutePath();
    }
}


