// Classe base com atributos e lógica comuns aos documentos.
// Mantém campos de personalização e implementa o mecanismo de clone do Prototype.
// Decisões de projeto:
// - Os campos são Strings (imutáveis), então o clone superficial via super.clone()
//   já cria cópias seguras. Caso existissem listas/objetos mutáveis, deveríamos
//   implementar uma cópia profunda.
// - Fornecemos métodos abstratos para permitir que cada subclasse crie uma cópia
//   do seu próprio tipo e mantenha a autonomia de copiar campos específicos.

public abstract class DocumentoBase implements DocumentoPrototype {
	protected String titulo;
	protected String corPrincipal;
	protected String fontePrincipal;
	protected String logoCliente;

	public DocumentoBase(String tituloPadrao) {
		this.titulo = tituloPadrao;
		this.corPrincipal = "Preto";
		this.fontePrincipal = "Arial";
		this.logoCliente = "";
	}

	@Override
	public void setCorPrincipal(String corPrincipal) {
		this.corPrincipal = corPrincipal;
	}

	@Override
	public void setFontePrincipal(String fontePrincipal) {
		this.fontePrincipal = fontePrincipal;
	}

	@Override
	public void setLogoCliente(String logoCliente) {
		this.logoCliente = logoCliente;
	}

	@Override
	public DocumentoPrototype clonar() {
		try {
			// Como os campos são Strings (imutáveis), clone superficial é suficiente.
			return (DocumentoPrototype) super.clone();
		} catch (CloneNotSupportedException e) {
			// Fallback: criar uma nova instância via método de fábrica abstrato.
			// Esse caminho deve raramente ocorrer, pois Cloneable está implementado.
			DocumentoBase copia = this.criarCopiaVazia();
			copia.titulo = this.titulo;
			copia.corPrincipal = this.corPrincipal;
			copia.fontePrincipal = this.fontePrincipal;
			copia.logoCliente = this.logoCliente;
			this.copiarCamposEspecificosPara(copia);
			return copia;
		}
	}

	// Cada subclasse deve fornecer uma "cópia vazia" do seu tipo concreto
	protected abstract DocumentoBase criarCopiaVazia();

	// Permite que subclasses copiem seus próprios campos específicos para a nova cópia
	protected abstract void copiarCamposEspecificosPara(DocumentoBase destino);

	@Override
	public String resumo() {
		StringBuilder sb = new StringBuilder();
		sb.append("Titulo: ").append(titulo)
			.append(" | Cor: ").append(corPrincipal)
			.append(" | Fonte: ").append(fontePrincipal)
			.append(" | Logo: ").append(logoCliente);
		return sb.toString();
	}
}


