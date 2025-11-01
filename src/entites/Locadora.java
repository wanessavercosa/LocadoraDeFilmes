package entites;

import java.util.ArrayList;
import java.util.List;

public class Locadora {

	/** Classe que vai gerar o sistema da locadora */

	private static List<Filmes> lista_deFilmes = new ArrayList<>();

	public void addFilme(Filmes filme_Usuario) {// método para cadastrar o filme
		lista_deFilmes.add(filme_Usuario);
	}

	public void exibirFilmes() {// exibir os filmes cadastrado na locadora

		if (lista_deFilmes.isEmpty()) {// programação defensiva
			System.out.println("Nenhum filme cadastrado!");
			return;
		}

		for (Filmes f : lista_deFilmes) {
			System.out.println(f);
		}

	}

	// método que retorna a quantidade de filmes por Genero
	public int pesquisar_porGenero(String genero_Usuario) {
		int contador_porGenero = 0;

		for (Filmes f : lista_deFilmes) {
			if (f.getGenero().equalsIgnoreCase(genero_Usuario)) {
				contador_porGenero++;
			}
		}

		return contador_porGenero;
	}

	// método que retorna a quantidade de filmes pelo valor pedido do usuário
	public int pesquisar_porPreco(double precoIni_Usuario, double precoFin_Usuario) {
		int quant_noValor = 0;

		for (Filmes f : lista_deFilmes) {
			if (f.getPreco() >= precoIni_Usuario && f.getPreco() <= precoFin_Usuario) {
				quant_noValor++;
			}
		}

		return quant_noValor;
	}

	// método para atualizar o valor de um filme
	public String atualizar_valorFilme(String titulo_Usuario, double novoValor) {

		for (Filmes f : lista_deFilmes) {
			if (f.getTitulo().equalsIgnoreCase(titulo_Usuario)) {
				f.setPreco(novoValor);
				return "Valor atualizado!";
			} 
		}
		return "Filme não encontrado!";
	}

	public boolean removerFilme(String titulo_Usuario) {// método para remover um filme da coleção

		for (Filmes f : lista_deFilmes) {
			if (f.getTitulo().equalsIgnoreCase(titulo_Usuario)) {
				lista_deFilmes.remove(f);
				return true;
			}
		}

		return false;

	}

	public double calcularTotal_deAcervo() {
		double total = 0.0;
		for (Filmes f : lista_deFilmes) {
			total += f.getPreco();
		}
		return total;
	}

}
