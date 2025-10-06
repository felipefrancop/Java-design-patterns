// Padrão utilizado: Prototype
// Justificativa: Precisamos gerar rapidamente novas cópias personalizáveis
// de documentos a partir de modelos existentes, evitando recriar toda a
// estrutura. O Prototype permite clonar (cópia) de objetos complexos com
// estado inicial padronizado, reduzindo acoplamento e custo de construção.

public interface DocumentoPrototype extends Cloneable {
	// Retorna uma cópia independente do documento
	DocumentoPrototype clonar();

	// Personalizações comuns a qualquer documento
	void setCorPrincipal(String corPrincipal);
	void setFontePrincipal(String fontePrincipal);
	void setLogoCliente(String logoCliente);

	// Visualização simples do conteúdo/estado do documento
	String resumo();
}


