import java.math.BigDecimal;

/**
 * Produto do Factory Method.
 * Define o contrato para cálculo de tarifa em diferentes modalidades.
 *
 * Observação de design:
 * - O contrato único permite polimorfismo no uso (cliente não sabe a classe concreta).
 */
public interface CalculadoraTarifa {
    BigDecimal calcular(TarifaRequisicao requisicao);
}


