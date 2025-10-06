import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Calculadora específica para transporte aéreo.
 * Regra exemplo: tarifa = (pesoKg * 12.00) + 50.00
 *
 * Pontos de validação:
 * - Peso deve ser maior que zero; tarifa mínima já contempla a taxa fixa do aeroporto.
 */
public class CalculadoraTarifaAerea implements CalculadoraTarifa {

    private static final BigDecimal VALOR_POR_KG = BigDecimal.valueOf(12.00);
    private static final BigDecimal TAXA_AEROPORTO = BigDecimal.valueOf(50.00);

    @Override
    public BigDecimal calcular(TarifaRequisicao requisicao) {
        if (requisicao == null || requisicao.getPesoKg() <= 0) {
            throw new IllegalArgumentException("Peso (kg) deve ser maior que zero para transporte aéreo.");
        }
        BigDecimal peso = BigDecimal.valueOf(requisicao.getPesoKg());
        BigDecimal valor = peso.multiply(VALOR_POR_KG).add(TAXA_AEROPORTO);
        return valor.setScale(2, RoundingMode.HALF_UP);
    }
}


