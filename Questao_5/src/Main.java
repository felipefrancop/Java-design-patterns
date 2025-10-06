// Demonstração do padrão Prototype: registramos modelos (prototipos) e, a
// partir deles, geramos cópias independentes e personalizáveis para clientes.
// Focus do trabalho: sem bibliotecas externas/GUI; apenas lógica do padrão.
public class Main {
	public static void main(String[] args) {
		// Criando modelos (prototypes) iniciais
		Curriculo modeloCurriculo = new Curriculo("Modelo de Curriculo", "Joao da Silva", "Profissional com 5 anos em desenvolvimento Java.");
		PropostaComercial modeloProposta = new PropostaComercial("Modelo de Proposta", "Cliente XYZ", 15000.0);
		Relatorio modeloRelatorio = new Relatorio("Modelo de Relatorio", "2024-Q4", "Resumo executivo e metricas de desempenho.");

		// Personalizações padrão do estúdio
		modeloCurriculo.setCorPrincipal("Azul");
		modeloCurriculo.setFontePrincipal("Calibri");
		modeloProposta.setCorPrincipal("Verde");
		modeloRelatorio.setCorPrincipal("Cinza");

		// Registro de modelos
		RegistroModelos registro = new RegistroModelos();
		registro.registrarModelo("curriculo", modeloCurriculo);
		registro.registrarModelo("proposta", modeloProposta);
		registro.registrarModelo("relatorio", modeloRelatorio);

		// Cliente solicita uma cópia de currículo personalizada
		Curriculo curriculoCliente = (Curriculo) registro.obterClone("curriculo");
		curriculoCliente.setLogoCliente("logo_acme.png");
		curriculoCliente.setNomeCandidato("Maria Oliveira");
		curriculoCliente.setResumoProfissional("Engenheira de Software focada em qualidade e automacao de testes.");
		curriculoCliente.setCorPrincipal("Roxo");

		// Cliente solicita proposta com ajustes
		PropostaComercial propostaCliente = (PropostaComercial) registro.obterClone("proposta");
		propostaCliente.setLogoCliente("logo_beta.png");
		propostaCliente.setCliente("Beta Ltda");
		propostaCliente.setValorProposta(18990.0);

		// Cliente solicita um relatório com novo período e conteúdo
		Relatorio relatorioCliente = (Relatorio) registro.obterClone("relatorio");
		relatorioCliente.setLogoCliente("logo_omega.png");
		relatorioCliente.setPeriodo("2025-Q1");
		relatorioCliente.setConteudo("KPIs atualizados, pipeline e roadmap.");

		// Saída
		System.out.println("=== MODELOS ===");
		System.out.println(modeloCurriculo.resumo());
		System.out.println(modeloProposta.resumo());
		System.out.println(modeloRelatorio.resumo());

		System.out.println("\n=== COPIAS PERSONALIZADAS ===");
		System.out.println(curriculoCliente.resumo());
		System.out.println(propostaCliente.resumo());
		System.out.println(relatorioCliente.resumo());
	}
}


