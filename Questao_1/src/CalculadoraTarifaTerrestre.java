import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Calculadora específica para transporte terrestre.
 * Regra exemplo: tarifa = (distanciaKm * 1.50) + 10.00
 *
 * Pontos de validação:
 * - Distância deve ser maior que zero para evitar resultados inválidos.
 */
public class CalculadoraTarifaTerrestre implements CalculadoraTarifa {

    private static final BigDecimal VALOR_POR_KM = BigDecimal.valueOf(1.50);
    private static final BigDecimal TAXA_FIXA = BigDecimal.valueOf(10.00);

    @Override
    public BigDecimal calcular(TarifaRequisicao requisicao) {
        if (requisicao == null || requisicao.getDistanciaKm() <= 0) {
            throw new IllegalArgumentException("Distância (km) deve ser maior que zero para transporte terrestre.");
        }
        BigDecimal distancia = BigDecimal.valueOf(requisicao.getDistanciaKm());
        BigDecimal valor = distancia.multiply(VALOR_POR_KM).add(TAXA_FIXA);
        return valor.setScale(2, RoundingMode.HALF_UP);
    }
}


