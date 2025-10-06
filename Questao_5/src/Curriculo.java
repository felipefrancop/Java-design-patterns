// Documento concreto: Currículo
// Papel no Prototype: classe concreta que herda a lógica de clonagem de
// DocumentoBase e define seus próprios campos específicos (nome e resumo).
// Assim, a criação de um novo currículo personalizado começa a partir de um
// modelo (prototipo) já configurado e não do zero.

public class Curriculo extends DocumentoBase {
	private String nomeCandidato;
	private String resumoProfissional;

	public Curriculo(String tituloPadrao, String nomeCandidato, String resumoProfissional) {
		super(tituloPadrao);
		this.nomeCandidato = nomeCandidato;
		this.resumoProfissional = resumoProfissional;
	}

	public void setNomeCandidato(String nomeCandidato) {
		this.nomeCandidato = nomeCandidato;
	}

	public void setResumoProfissional(String resumoProfissional) {
		this.resumoProfissional = resumoProfissional;
	}

	@Override
	protected DocumentoBase criarCopiaVazia() {
		return new Curriculo(this.titulo, this.nomeCandidato, this.resumoProfissional);
	}

	@Override
	protected void copiarCamposEspecificosPara(DocumentoBase destino) {
		Curriculo c = (Curriculo) destino;
		c.nomeCandidato = this.nomeCandidato;
		c.resumoProfissional = this.resumoProfissional;
	}

	@Override
	public String resumo() {
		return super.resumo() + " | Tipo: Curriculo | Nome: " + nomeCandidato + " | Resumo: " + resumoProfissional;
	}
}


