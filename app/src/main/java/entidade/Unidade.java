package entidade;

public class Unidade {
	
	int numero_unidade;
	String endereco_unidade;
	
	
	
	public Unidade(int num, String end) {
		// TODO Auto-generated constructor stub
		super();
		this.numero_unidade = num;
		this.endereco_unidade = end;
	}
	
	public Unidade() {
		// TODO Auto-generated constructor stub
	}
	
	public void setEndereco_unidade(String endereco_unidade) {
		this.endereco_unidade = endereco_unidade;
	}
	
	public void setNumero_unidade(int numero_unidade) {
		this.numero_unidade = numero_unidade;
	}
	
	public String getEndereco_unidade() {
		return endereco_unidade;
	}
	
	public int getNumero_unidade() {
		return numero_unidade;
	}
	
	

}
