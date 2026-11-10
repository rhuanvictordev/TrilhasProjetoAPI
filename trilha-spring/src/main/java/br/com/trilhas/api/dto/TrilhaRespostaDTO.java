package br.com.trilhas.api.dto;

public class TrilhaRespostaDTO {
	
	private Long id;
	private String nome;
	private String descricao;
	private double distanciaMetros;
	
	
	public TrilhaRespostaDTO(long id, String nome, String descricao, double distanciaMetros)
	{
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.distanciaMetros = distanciaMetros;
	}
	
	public Long getId()
	{
		return this.id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getDistanciaMetros() {
		return distanciaMetros;
	}
	
	public void setDistanciaMetros(double distanciaMetros) {
		this.distanciaMetros = distanciaMetros;
	}

}
