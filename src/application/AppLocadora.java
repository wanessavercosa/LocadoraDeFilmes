package application;

import java.util.Locale;
import java.util.Scanner;

import entites.Filmes;
import entites.Locadora;

public class AppLocadora {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int menu = 0;
		Locadora locadora = new Locadora();

		do {

			try {

				exibirMenu();
				System.out.print("Escolha uma opção do Menu: ");
				menu = sc.nextInt();

				switch (menu) {
				case 1:
					System.out.print("\nTítulo: ");
					sc.nextLine();
					String titulo = sc.nextLine();
					System.out.print("Dirigido por: ");
					String diretor = sc.nextLine();
					System.out.print("Gênero do filme: ");
					String genero = sc.nextLine();
					System.out.print("Valor do filme: ");
					Double preco = sc.nextDouble();

					locadora.addFilme(new Filmes(titulo, diretor, genero, preco));
					break;
				case 2:
					System.out.println("\n\t ** Lista de Filmes **");
					locadora.exibirFilmes();
					System.out.println();
					break;
				case 3:
					System.out.print("\nDigite o gênero: ");
					sc.nextLine();
					String genero_pesquisa = sc.nextLine();
					int gen_Pesquisado = locadora.pesquisar_porGenero(genero_pesquisa);
					System.out.println("Existem: " + gen_Pesquisado + " filmes neste gênero");
					break;
				case 4:
					System.out.println("\nDigite a faixa de preço ");
					System.out.print("\nPreço Inicial: [R$] ");
					double preco_inicial = sc.nextDouble();
					System.out.print("Preço Final: [R$] ");
					double preco_final = sc.nextDouble();
					int faixa_preco = locadora.pesquisar_porPreco(preco_inicial, preco_final);
					System.out.println("Existem: " + faixa_preco + " filmes nesta faixa de preço");
					break;
				case 5:
					System.out.print("\nQual filme para a atualização? ");
					sc.nextLine();
					String filme_Atualizar = sc.nextLine();
					System.out.print("Novo valor [R$]: ");
					double novoValor = sc.nextDouble();
					String novo = locadora.atualizar_valorFilme(filme_Atualizar, novoValor);
					System.out.println(novo);
					break;
				case 6:
					System.out.print("\nQual filme deseja excluir? ");
					sc.nextLine();
					String excluirFilme = sc.nextLine();
					boolean excluido = locadora.removerFilme(excluirFilme);
					if (excluido) {
						System.out.println("Filme removido com sucesso!");
					} else {
						System.out.println("Filme não encontrado!");
					}
					break;
				case 7:
					double total = locadora.calcularTotal_deAcervo();
					System.out.print("\nTotal [R$] de acervo de filmes: R$" + String.format("%.2f", total));
					System.out.println();
					break;
				case 8:
					System.out.println("\nSaindo...");
					break;
				}

			} catch (Exception e) {
				System.err.println("Error: Digite um número válido do Menu");
				sc.nextLine();
			}

		} while (menu != 8);

		System.out.println("\n\tPrograma encerrado. Até mais =)");

		sc.close();

	}

	public static void exibirMenu() {
		System.out.println("================================");
		System.out.println("\tLocadora de Filmes");
		System.out.println("================================");
		System.out.println("1 - Cadastrar Filme");
		System.out.println("2 - Filmes");
		System.out.println("3 - Pesquisa por gênero");
		System.out.println("4 - Pesquisa por faixa de preço");
		System.out.println("5 - Atualizar preço");
		System.out.println("6 - Excluir Filme");
		System.out.println("7 - Calcular total de Acervo");
		System.out.println("8 - Sair");
	}

}
