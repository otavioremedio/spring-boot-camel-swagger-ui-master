package sp.senac.br.springbootswagger;

import java.io.Serializable;

public class SistemaPerfilDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer codSistemaPerfil;
	private Integer codSistema;


	public Integer getCodSistemaPerfil() {
		return codSistemaPerfil;
	}

	public void setCodSistemaPerfil(Integer codSistemaPerfil) {
		this.codSistemaPerfil = codSistemaPerfil;
	}

	public Integer getCodSistema() {
		return codSistema;
	}

	public void setCodSistema(Integer codSistema) {
		this.codSistema = codSistema;
	}

}
