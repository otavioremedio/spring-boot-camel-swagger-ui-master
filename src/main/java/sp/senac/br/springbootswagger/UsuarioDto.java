package sp.senac.br.springbootswagger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class UsuarioDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer chapa;
	private String nmUsuario;
	private String codUnidade;
	private String tipoColab;
	private String ativo;
	private String sigla;
	private String email;
	private String nomeUO;
	private Integer usuarioSq;
	private String identificacaoUsuario;

	private List<SistemaPerfilDto> sistemasPerfis = new ArrayList<>();
	
	private PerfilEnum perfil;

	private Integer codSistema;

	public Integer getChapa() {
		return chapa;
	}
	public void setChapa(Integer chapa) {
		this.chapa = chapa;
	}
	public String getNmUsuario() {
		return nmUsuario;
	}
	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}
	public String getCodUnidade() {
		return codUnidade;
	}
	public void setCodUnidade(String codUnidade) {
		this.codUnidade = codUnidade;
	}
	public String getTipoColab() {
		return tipoColab;
	}
	public void setTipoColab(String tipoColab) {
		this.tipoColab = tipoColab;
	}
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomeUO() {
		return nomeUO;
	}
	public void setNomeUO(String nomeUO) {
		this.nomeUO = nomeUO;
	}
	public Integer getUsuarioSq() {
		return usuarioSq;
	}
	public void setUsuarioSq(Integer usuarioSq) {
		this.usuarioSq = usuarioSq;
	}
	public String getIdentificacaoUsuario() {
		return identificacaoUsuario;
	}
	public void setIdentificacaoUsuario(String identificacaoUsuario) {
		this.identificacaoUsuario = identificacaoUsuario;
	}
	public List<SistemaPerfilDto> getSistemasPerfis() {
		return sistemasPerfis.stream()
				.filter(perfil -> perfil.getCodSistema().equals(this.getCodSistema()))
				.collect(Collectors.toList());
	}
	public void setSistemasPerfis(List<SistemaPerfilDto> sistemasPerfis) {
		this.sistemasPerfis = sistemasPerfis;
	}

	@Enumerated(EnumType.STRING)
	public PerfilEnum getPerfil() {
		if(this.getSistemasPerfis().size() > 0)
			return PerfilEnum.toEnum(getSistemasPerfis().get(0).getCodSistemaPerfil());

		if(this.getTipoColab().equals(TipoColab.PRESTADOR.getDescricao().toUpperCase()))
			return PerfilEnum.PREST;
		
		return PerfilEnum.COLAB;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}

	public Integer getCodSistema() {
		return codSistema;
	}
	public void setCodSistema(Integer codSistema) {
		this.codSistema = codSistema;
	}

}
