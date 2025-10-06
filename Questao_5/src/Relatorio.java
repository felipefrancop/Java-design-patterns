// Documento concreto: Relatório
// Papel no Prototype: o relatorio é clonado a partir de um modelo com
// periodo/conteudo padrão; o cliente só altera os campos necessários e
// personalizações visuais (cor/fonte/logo).

public class Relatorio extends DocumentoBase {
	private String periodo;
	private String conteudo;

	public Relatorio(String tituloPadrao, String periodo, String conteudo) {
		super(tituloPadrao);
		this.periodo = periodo;
		this.conteudo = conteudo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	@Override
	protected DocumentoBase criarCopiaVazia() {
		return new Relatorio(this.titulo, this.periodo, this.conteudo);
	}

	@Override
	protected void copiarCamposEspecificosPara(DocumentoBase destino) {
		Relatorio r = (Relatorio) destino;
		r.periodo = this.periodo;
		r.conteudo = this.conteudo;
	}

	@Override
	public String resumo() {
		return super.resumo() + " | Tipo: Relatorio | Periodo: " + periodo + " | Conteudo: " + conteudo;
	}
}


