package ifg;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Object[][] data = { { 1, "Raiz", "Produtos", -1 }, { 2, "Móveis", "Móveis", 1 },
				{ 3, "Eletrônicos", "Eletrônicos, Gadgets", 1 },
				{ 4, "Casa e Eletrodomésticos", "Casa, Eletrodomésticos", 1 },
				{ 5, "Eletrodomésticos Principais", "", 4 }, { 6, "Eletrodomésticos Secundários", "", 4 },
				{ 7, "Gramado e Jardim", "Gramado, Jardim", 4 }, { 8, "Eletrodomésticos de Cozinha", "", 5 },
				{ 9, "Eletrodomésticos em Geral", "", 5 } ,{10,"prova","ava",1}};

		Arvore arvore = new Arvore();
       
		//Exercios descritos no arquivo PDF
		//Exercicio 1
		arvore.criaArvore(data);

		// arvore.percorreArvore(arvore.raiz);

		//Exercicio 2
//		int nivelCategoria = arvore.nivel(10);
//		if (nivelCategoria != -1) {
//			System.out.println("O nível da categoria é: " + nivelCategoria);
//		} else {
//			System.out.println("Categoria não encontrada!");
//		}

		//Exercio 3
		ArrayList<String[]> categoriasCasa = arvore.categoriasPorPalavraChave("ava");
		for (String[] categoria : categoriasCasa) {
			System.out.println(Arrays.toString(categoria));
		}

        //Exercicio 4
//		String[] dadosCategoria = arvore.obter(10);
//		System.out.println(Arrays.toString(dadosCategoria));
	}

}
