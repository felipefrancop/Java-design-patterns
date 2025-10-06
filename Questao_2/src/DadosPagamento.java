package Questao_2.src;

import java.math.BigDecimal;

/**
 * DTO simples para representar os dados mínimos de um pagamento.
 * Mantido genérico para não acoplar o domínio a um meio específico.
 *
 * Observação de projeto:
 * - Este DTO é intencionalmente minimalista para permitir reuso por todos os
 *   processadores. Campos específicos (ex.: número do cartão) ficariam em
 *   objetos mais especializados, caso necessário, para não quebrar OCP.
 */
public class DadosPagamento {
    private final BigDecimal valor;
    private final String descricao;

    public DadosPagamento(BigDecimal valor, String descricao) {
        if (valor == null || valor.signum() <= 0) {
            throw new IllegalArgumentException("Valor do pagamento deve ser maior que zero.");
        }
        this.valor = valor;
        this.descricao = descricao == null ? "" : descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
}


