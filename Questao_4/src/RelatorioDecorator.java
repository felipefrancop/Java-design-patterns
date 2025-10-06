import java.util.List;

/**
 * Classe base para todos os decoradores de relatório.
 * 
 * Decisão de projeto: padrão Decorator. Cada funcionalidade adicional é um
 * decorador que recebe um {@link Relatorio} e adiciona comportamento sem
 * modificar a implementação existente. Isso favorece o princípio aberto-fechado
 * (SOLID) sem heranças múltiplas complexas.
 */
public abstract class RelatorioDecorator implements RelatorioVendas {
    protected final RelatorioVendas relatorio;

    protected RelatorioDecorator(RelatorioVendas relatorio) {
        this.relatorio = relatorio;
    }

    @Override
    public String gerar(List<Pedido> pedidos) {
        // Por padrão, delega ao relatório interno; subclasses acrescentam conteúdo
        return relatorio.gerar(pedidos);
    }
}


