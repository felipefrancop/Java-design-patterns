import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Calculadora específica para transporte marítimo.
 * Regra exemplo: tarifa = (volumeM3 * 200.00) + 80.00
 *
 * Pontos de validação:
 * - Volume deve ser maior que zero; a taxa portuária é aplicada uma única vez.
 */
public class CalculadoraTarifaMaritima implements CalculadoraTarifa {

    private static final BigDecimal VALOR_POR_M3 = BigDecimal.valueOf(200.00);
    private static final BigDecimal TAXA_PORTUARIA = BigDecimal.valueOf(80.00);

    @Override
    public BigDecimal calcular(TarifaRequisicao requisicao) {
        if (requisicao == null || requisicao.getVolumeM3() <= 0) {
            throw new IllegalArgumentException("Volume (m3) deve ser maior que zero para transporte marítimo.");
        }
        BigDecimal volume = BigDecimal.valueOf(requisicao.getVolumeM3());
        BigDecimal valor = volume.multiply(VALOR_POR_M3).add(TAXA_PORTUARIA);
        return valor.setScale(2, RoundingMode.HALF_UP);
    }
}


