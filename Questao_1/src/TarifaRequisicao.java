/**
 * DTO imutável que carrega os dados necessários para cálculo de tarifas.
 * Nem todos os campos são usados por todas as modalidades. Cada calculadora
 * irá validar e usar apenas os campos pertinentes à sua regra.
 *
 * Decisão de design:
 * - Builder evita construtores telescópicos e torna explícitos os campos relevantes
 *   para cada cenário, melhorando a legibilidade no ponto de uso (Main).
 */
public final class TarifaRequisicao {
    private final double distanciaKm; // Usado no transporte terrestre
    private final double pesoKg;      // Usado no transporte aéreo
    private final double volumeM3;    // Usado no transporte marítimo

    private TarifaRequisicao(Builder builder) {
        this.distanciaKm = builder.distanciaKm;
        this.pesoKg = builder.pesoKg;
        this.volumeM3 = builder.volumeM3;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public double getVolumeM3() {
        return volumeM3;
    }

    /**
     * Builder simples para facilitar a construção do DTO, evitando múltiplos construtores.
     */
    public static class Builder {
        private double distanciaKm;
        private double pesoKg;
        private double volumeM3;

        public Builder comDistanciaKm(double distanciaKm) {
            this.distanciaKm = distanciaKm;
            return this;
        }

        public Builder comPesoKg(double pesoKg) {
            this.pesoKg = pesoKg;
            return this;
        }

        public Builder comVolumeM3(double volumeM3) {
            this.volumeM3 = volumeM3;
            return this;
        }

        public TarifaRequisicao build() {
            return new TarifaRequisicao(this);
        }
    }
}


