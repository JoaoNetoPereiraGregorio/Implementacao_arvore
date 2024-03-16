package ifg;

import java.util.ArrayList;
import java.util.HashMap;

public class Arvore {
	No raiz;
	HashMap<Integer, No> noMap;

	public Arvore() {
		raiz = null;
		noMap = new HashMap<>();
	}

	public void adicionaNo(int id, String nome, String categoria, int paiId) {

		No novoNo = new No(id, nome, categoria);
		noMap.put(id, novoNo);// adiciono o no map

		if (paiId == -1) {// se for -1 e a raiz
			raiz = novoNo;
		} else {
			No pai = noMap.get(paiId);
			// busco o pai no map
			if (pai != null) {
				novoNo.pai = pai;// defino um pai para o no
				pai.filhos.add(novoNo);// e para o pai um novo filho
				if (categoria == "") {// verifico se ta sem categoria se tiver pego a do pai
					novoNo.setCategoria(pai.getCategoria());
				}
			}
		}

	}

	public void criaArvore(Object[][] data) {
		for (Object[] noData : data) {
			int id = (int) noData[0];
			String nome = (String) noData[1];
			String categoria = (String) noData[2];
			int paiId = (int) noData[3];
			adicionaNo(id, nome, categoria, paiId);
		}
	}

	public int nivel(int categoriaId) {
		No no = noMap.get(categoriaId);// busco o no map
		if (no == null) {
			return -1; // Se o nó não existir, retorna -1 indicando que o ID não foi encontrado
		}

		int nivel = 0; // Começa do nível 1 para a categoria raiz verificar com o professor

		while (no.pai != null) {// verifico ate ter um pai
			nivel++;
			no = no.pai;
		}

		return nivel;
	}

	ArrayList<String[]> categoriasPorPalavraChave(String palavraChave) {
		ArrayList<String[]> resultado = new ArrayList<>();
		for (No no : noMap.values()) {
			// toLowerCse coloca tudo em minusculo
			// contains verifica se tem a palavra dentro da String
			if (no.categoria.toLowerCase().contains(palavraChave.toLowerCase())) {
				int nivelCategoria = nivel(no.id);
				String[] categoria = new String[3 + no.categoria.split(", ").length];// split corta a String separa
				categoria[0] = Integer.toString(no.id).replace("", "\"");
				categoria[1] = Integer.toString(nivelCategoria).replace("", "\"");
				categoria[2] = "\"" + no.nome + "\"";
				String[] palavrasChave = no.categoria.split(", ");
				// for para percorrer array de palavras chave e adicionar em cada uma as aspas
				for (int i = 0; i < palavrasChave.length; i++) {
					palavrasChave[i] = "\"" + palavrasChave[i] + "\"";
				}
				// coloca um array dentro de outro
				System.arraycopy(palavrasChave, 0, categoria, 3, palavrasChave.length);
				// 1 array que quero adicionar
				// 2 indice inicial do array adicionado
				// 3 array de destino,
				// 4 indice inicial do array de destino
				// 5 numero de elementos a ser copiado
				resultado.add(categoria);
			}
		}
		return resultado;
	}

	String[] obter(int categoriaId) {
		No no = noMap.get(categoriaId);
		if (no == null) {
			return new String[] { "Categoria não encontrada" };
		}

		int nivelCategoria = nivel(categoriaId);
		String[] categoria = new String[no.categoria.split(", ").length + 1];
		categoria[0] = Integer.toString(nivelCategoria).replace("", "\"");

		String[] palavrasChave = no.categoria.split(", ");
		// for para percorrer array de palavras chave e adicionar em cada uma as aspas
		for (int i = 0; i < palavrasChave.length; i++) {
			palavrasChave[i] = "\"" + palavrasChave[i] + "\"";
		}
		// coloca um array dentro de outro
		System.arraycopy(palavrasChave, 0, categoria, 1, palavrasChave.length);
		// 1 array que quero adicionar
		// 2 indice inicial do array adicionado
		// 3 array de destino,
		// 4 indice inicial do array de destino
		// 5 numero de elementos a ser copiado
		return categoria;
	}

	void percorreArvore(No no) {
		if (no != null) {
			System.out.println("ID: " + no.id + ", Name: " + no.nome + ", Category: " + no.categoria);
			for (No filho : no.filhos) {
				percorreArvore(filho);
			}
		}
	}

}
