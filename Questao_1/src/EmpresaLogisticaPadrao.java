/**
 * Concrete Creator do Factory Method.
 * Decide qual implementação de CalculadoraTarifa instanciar.
 *
 * Notas:
 * - A lógica de escolha está centralizada aqui (único ponto de mudança ao adicionar novo tipo).
 * - O cliente continua simples e limpo, pedindo apenas "uma calculadora para X".
 */
public class EmpresaLogisticaPadrao extends EmpresaLogistica {

    @Override
    protected CalculadoraTarifa criarCalculadora(TransporteTipo tipo) {
        switch (tipo) {
            case TERRESTRE:
                return new CalculadoraTarifaTerrestre();
            case AEREO:
                return new CalculadoraTarifaAerea();
            case MARITIMO:
                return new CalculadoraTarifaMaritima();
            default:
                throw new IllegalArgumentException("Tipo de transporte não suportado: " + tipo);
        }
    }
}


