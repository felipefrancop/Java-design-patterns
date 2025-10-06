import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Utilitário simples para gerar pedidos de exemplo.
 */
public final class DadosExemplo {
    private DadosExemplo() {}

    public static List<Pedido> gerarPedidosExemplo() {
        return Arrays.asList(
                new Pedido(1, "Alice", 95.50, LocalDate.of(2025, 10, 1)),
                new Pedido(2, "Bruno", 450.00, LocalDate.of(2025, 10, 2)),
                new Pedido(3, "Carla", 780.90, LocalDate.of(2025, 10, 3)),
                new Pedido(4, "Diego", 1250.00, LocalDate.of(2025, 10, 4)),
                new Pedido(5, "Eva", 35.20, LocalDate.of(2025, 10, 5))
        );
    }
}


