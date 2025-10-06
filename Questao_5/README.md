# Questao 5 - Padrao Prototype

## Justificativa do Padrao
- Requisito central: gerar rapidamente uma nova copia personalizavel a partir de um modelo existente (cores, fontes, logotipo), sem recriar a estrutura do documento do zero.
- O Prototype atende diretamente esse requisito: permite clonar objetos ja configurados (modelos), garantindo consistencia e baixo custo de criacao.
- Cada clone e independente do modelo original, evitando efeitos colaterais ao personalizar.

## Arquitetura
- `DocumentoPrototype` (interface): define `clonar()` e as personalizacoes comuns (`setCorPrincipal`, `setFontePrincipal`, `setLogoCliente`) e `resumo()` para visualizacao.
- `DocumentoBase` (abstrata): concentra os campos comuns e implementa a logica de clonagem do Prototype. Como os campos sao `String` (imutaveis), o clone superficial e suficiente.
- Concretos: `Curriculo`, `PropostaComercial`, `Relatorio` — representam tipos de documentos com campos especificos e herdam a clonagem da base.
- `RegistroModelos`: registro simples que guarda modelos e devolve clones por nome (ex.: "curriculo", "proposta", "relatorio").
- `Main`: demonstra o fluxo completo — criar modelos, registrar, clonar e personalizar para o cliente.

## Consideracoes de Projeto
- Se houvesse colecoes/objetos mutaveis, implementar-se-ia copia profunda (deep copy) na `DocumentoBase` e/ou nos concretos.
- O registro evita que o cliente saiba construir documentos do zero; basta pedir um clone pelo nome.
- Nao ha GUI nem bibliotecas externas, conforme o enunciado. O foco ficou na logica do padrao.

## Como compilar e executar (Windows PowerShell)
```bash
cd "c:\Users\FelipeFrancoPinheiro\Documents\Padroes de Projeto\Questao_5"
javac -d bin src\*.java
java -cp bin Main
```

## Saida esperada (exemplo)
- Listagem dos modelos padrao
- Listagem das copias personalizadas (com cor/fonte/logo/atributos alterados)

## Por que nao outros padroes?
- Factory Method / Abstract Factory: criam do zero; aqui queremos partir de um modelo pronto.
- Decorator: adiciona responsabilidades; o foco aqui e criacao/clonagem.
- Observer: reacao a eventos, nao aplicavel a clonagem de documentos.
- Singleton: uma unica instancia global; precisamos de varias copias independentes.
- Heranca/Polimorfismo: utilizada nos tipos concretos, mas nao resolve a necessidade de clonar rapidamente um estado base.
- SOLID: principios gerais; seguimos-os onde possivel, mas a necessidade e de um padrao de criacao (Prototype).
