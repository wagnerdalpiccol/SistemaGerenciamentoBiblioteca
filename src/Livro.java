import java.util.UUID;

public class Livro {

	private String id;
	private String titulo;
	private String autor;
	private Categoria categoria;
	private int quantidadeAcervo;

	public Livro(String titulo, String autor, Categoria categoria, int quantidadeAcervo) {
		this.id = UUID.randomUUID().toString();
		this.titulo = titulo;
		this.autor = autor;
		this.categoria = categoria;
		this.quantidadeAcervo = quantidadeAcervo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getQuantidadeAcervo() {
		return quantidadeAcervo;
	}

	public void setQuantidadeAcervo(int quantidadeAcervo) {
		this.quantidadeAcervo = quantidadeAcervo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
