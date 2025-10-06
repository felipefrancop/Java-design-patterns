// Documento concreto: Proposta Comercial
// Papel no Prototype: permite criar rapidamente uma nova proposta a partir de
// um modelo (prototipo) base, alterando apenas cliente/valor e personalizações
// visuais, sem reconfigurar o objeto do zero.

public class PropostaComercial extends DocumentoBase {
	private String cliente;
	private double valorProposta;

	public PropostaComercial(String tituloPadrao, String cliente, double valorProposta) {
		super(tituloPadrao);
		this.cliente = cliente;
		this.valorProposta = valorProposta;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public void setValorProposta(double valorProposta) {
		this.valorProposta = valorProposta;
	}

	@Override
	protected DocumentoBase criarCopiaVazia() {
		return new PropostaComercial(this.titulo, this.cliente, this.valorProposta);
	}

	@Override
	protected void copiarCamposEspecificosPara(DocumentoBase destino) {
		PropostaComercial p = (PropostaComercial) destino;
		p.cliente = this.cliente;
		p.valorProposta = this.valorProposta;
	}

	@Override
	public String resumo() {
		return super.resumo() + " | Tipo: Proposta | Cliente: " + cliente + " | Valor: R$ " + valorProposta;
	}
}


