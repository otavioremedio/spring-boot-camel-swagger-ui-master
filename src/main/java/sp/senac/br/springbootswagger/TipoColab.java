package sp.senac.br.springbootswagger;

public enum TipoColab {

	PRESTADOR('P', "Prestador de Serviço"),
	FUNCIONARIO('F', "Funcionario");

	private Character cod;
	private String descricao;

	private TipoColab(Character cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Character getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoColab toEnum(Character cod) {

		if (cod == null) {
			return null;
		}

		for (TipoColab x : TipoColab.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Tipo inválido: " + cod);
	}
}
