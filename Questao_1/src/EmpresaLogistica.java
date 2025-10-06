/**
 * Creator do Factory Method.
 * Define o método fábrica que retorna uma CalculadoraTarifa para o tipo de transporte solicitado.
 * Esta classe pode conter lógica comum de negócio da empresa de logística.
 *
 * Decisão de design:
 * - Centralizar a criação em um ponto único reduz acoplamento no cliente.
 * - Mantém o sistema aberto para extensão (novas calculadoras) e fechado para modificação
 *   (cliente não muda ao incluir novas modalidades).
 */
public abstract class EmpresaLogistica {

    /**
     * Factory Method: cria a calculadora apropriada para o TransporteTipo.
     */
    protected abstract CalculadoraTarifa criarCalculadora(TransporteTipo tipo);

    /**
     * Método de alto nível que ilustra possível lógica comum antes/depois de usar a calculadora criada.
     * Mantém o cliente desacoplado das classes concretas de calculadora.
     * Poderia, por exemplo, registrar métricas ou aplicar políticas de auditoria.
     */
    public CalculadoraTarifa obterCalculadora(TransporteTipo tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("Tipo de transporte não pode ser nulo");
        }
        return criarCalculadora(tipo);
    }
}


