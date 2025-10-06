import java.util.HashMap;
import java.util.Map;

// Registro simples de modelos (prototypes) por nome.
// Motivação de projeto: centraliza os modelos disponíveis e oferece um ponto
// único para obter clones. Ajuda a manter o código do Main enxuto e desacopla
// o cliente do conhecimento de como construir cada documento do zero.

public class RegistroModelos {
	private final Map<String, DocumentoPrototype> modelos = new HashMap<>();

	public void registrarModelo(String nome, DocumentoPrototype documento) {
		modelos.put(nome, documento);
	}

	public DocumentoPrototype obterClone(String nome) {
		DocumentoPrototype prototipo = modelos.get(nome);
		if (prototipo == null) {
			throw new IllegalArgumentException("Modelo nao encontrado: " + nome);
		}
		return prototipo.clonar();
	}
}


