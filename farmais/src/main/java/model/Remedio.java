package model;

public class Remedio {
	
	private String idrem;
	private String nome_tec;
	private String tipo_tarja;
	private String nome_com;
	private String nome_fab;
	private String data_atual;
	
	public Remedio() {
		super();
	}
	
	public Remedio(String idrem, String nome_tec, String tipo_tarja, String nome_com, String nome_fab, String data_atual) {
		super();
		this.idrem = idrem;
		this.nome_tec = nome_tec;
		this.tipo_tarja = tipo_tarja;
		this.nome_com = nome_com;
		this.nome_fab = nome_fab;
		this.data_atual= data_atual;
	}
	
	
	public String getData_atual() {
		return data_atual;
	}

	public void setData_atual(String data_atual) {
		this.data_atual = data_atual;
	}

	public String getIdrem() {
		return idrem;
	}

	public void setIdrem(String idrem) {
		this.idrem = idrem;
	}

	public String getNome_tec() {
		return nome_tec;
	}
	public void setNome_tec(String nome_tec) {
		this.nome_tec = nome_tec;
	}
	public String getTipo_tarja() {
		return tipo_tarja;
	}
	public void setTipo_tarja(String tipo_tarja) {
		this.tipo_tarja = tipo_tarja;
	}
	public String getNome_com() {
		return nome_com;
	}
	public void setNome_com(String nome_com) {
		this.nome_com = nome_com;
	}
	public String getNome_fab() {
		return nome_fab;
	}
	public void setNome_fab(String nome_fab) {
		this.nome_fab = nome_fab;
	}
	
	
}
