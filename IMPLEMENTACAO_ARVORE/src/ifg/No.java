package ifg;

import java.util.ArrayList;

public class No {
	int id;
	String nome;
	String categoria;

	No pai;
	ArrayList<No> filhos;

	public No(int id, String nome, String categoria) {
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.filhos = new ArrayList<>();
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
