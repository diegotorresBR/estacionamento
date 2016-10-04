package com.example.vagasfaciluninorte;

public class Estacionameto {
	
	private int numero_unidade;
	private String endereco;
	
	public Estacionameto() {
		// TODO Auto-generated constructor stub
	}
	
	public Estacionameto(int num, String end) {
		super();
		this.endereco = end;
		this.numero_unidade = num;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public int getNumero_unidade() {
		return numero_unidade;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setNumero_unidade(int numero_unidade) {
		this.numero_unidade = numero_unidade;
	}
	
}
