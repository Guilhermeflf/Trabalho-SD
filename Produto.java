package Servidor;

public class Produto {
	public int id;
	public String nome;
	public float valor;
	
	
	
	
	public Produto(int id2, String nome2, float valor2) {
		// TODO Auto-generated constructor stub
		this.id = id2;
		this.nome = nome2;
		this.valor = valor2;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
