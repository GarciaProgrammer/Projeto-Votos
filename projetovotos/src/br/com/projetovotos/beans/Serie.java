package br.com.projetovotos.beans;

public class Serie {

	private int id;
	private String titulo;
	private int votos;
	
	public Serie () {}
	
	public Serie(int id, String titulo, int votos) {
		this.id = id;
		this.titulo = titulo;
		this.votos = votos;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getVotos() {
		return votos;
	}
	public void setVotos(int votos) {
		this.votos = votos;
	}
	
	
}
