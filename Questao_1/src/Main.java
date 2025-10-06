import java.math.BigDecimal;

/**
 * Main apenas para demonstração de uso e validação manual.
 *
 * Comentários de design:
 * - O cliente (esta classe) permanece desacoplado das classes concretas de cálculo.
 *   Ele interage apenas com a abstração (CalculadoraTarifa) e solicita ao criador
 *   (EmpresaLogistica) a calculadora apropriada via Factory Method.
 * - Cada modalidade encapsula sua regra, mantendo o código organizado e fácil de estender.
 */
public class Main {
    public static void main(String[] args) {
        // Criador concreto que sabe qual produto concreto devolver
        EmpresaLogistica empresa = new EmpresaLogisticaPadrao();

        // Exemplo Terrestre: regra baseada em distância
        CalculadoraTarifa calcTerrestre = empresa.obterCalculadora(TransporteTipo.TERRESTRE);
        BigDecimal valorTerrestre = calcTerrestre.calcular(
            new TarifaRequisicao.Builder()
                .comDistanciaKm(120.5)
                .build()
        );
        System.out.println("Terrestre: R$ " + valorTerrestre);

        // Exemplo Aéreo: regra baseada em peso
        CalculadoraTarifa calcAereo = empresa.obterCalculadora(TransporteTipo.AEREO);
        BigDecimal valorAereo = calcAereo.calcular(
            new TarifaRequisicao.Builder()
                .comPesoKg(8.75)
                .build()
        );
        System.out.println("Aéreo: R$ " + valorAereo);

        // Exemplo Marítimo: regra baseada em volume
        CalculadoraTarifa calcMaritimo = empresa.obterCalculadora(TransporteTipo.MARITIMO);
        BigDecimal valorMaritimo = calcMaritimo.calcular(
            new TarifaRequisicao.Builder()
                .comVolumeM3(2.3)
                .build()
        );
        System.out.println("Marítimo: R$ " + valorMaritimo);
    }
}


