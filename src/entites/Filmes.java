package entites;

public class Filmes {

	private String titulo;
	private String diretor;
	private String genero;
	private Double preco;

	public Filmes() {
	}

	public Filmes(String titulo, String diretor, String genero, Double preco) {
		this.titulo = titulo;
		this.diretor = diretor;
		this.genero = genero;
		this.preco = preco;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "\nTitulo: " + titulo + ",\nDiretor: " + diretor + ",\nGenero:" + genero + ",\nPreco: R$"
				+ String.format("%.2f", preco);
	}

}
