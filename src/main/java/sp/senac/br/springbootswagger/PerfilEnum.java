package sp.senac.br.springbootswagger;

public enum PerfilEnum {

	ADMIN(271, "ROLE_ADMIN", "Perfil Administrador"),
	COLAB(270, "ROLE_COLAB", "Perfil Colaborador"),
	PREST(280, "ROLE_PREST", "Perfil Prestador");

	private int cod;
	private String descricao;
	private String descricaoFront;

	private PerfilEnum(int cod, String descricao, String descricaoFront) {
		this.cod = cod;
		this.descricao = descricao;
		this.descricaoFront = descricaoFront;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao () {
		return descricao;
	}

	public String getDescricaoFront() {
		return descricaoFront;
	}

	public static PerfilEnum toEnum(Integer cod) {

		if (cod == null) {
			return PerfilEnum.COLAB;
		}

		for (PerfilEnum x : PerfilEnum.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
