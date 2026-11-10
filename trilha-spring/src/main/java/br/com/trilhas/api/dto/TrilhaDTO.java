package br.com.trilhas.api.dto;

public class TrilhaDTO {
	
	private String nome;
	private String descricao;
	private double distanciaMetros;
	
	
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
