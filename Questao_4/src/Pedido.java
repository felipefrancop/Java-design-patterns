import java.time.LocalDate;

/**
 * Modelo de domínio simples representando um pedido de venda.
 * Mantém apenas os dados essenciais para geração de relatórios.
 */
public class Pedido {
    private final int id;
    private final String cliente;
    private final double valorTotal;
    private final LocalDate data;

    public Pedido(int id, String cliente, double valorTotal, LocalDate data) {
        this.id = id;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente='" + cliente + '\'' +
                ", valorTotal=" + valorTotal +
                ", data=" + data +
                '}';
    }
}


