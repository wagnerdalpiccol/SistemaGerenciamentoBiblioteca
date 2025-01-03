import com.google.gson.annotations.SerializedName;

public class Livro {
	@SerializedName("codigo")
	private int codigo;
	@SerializedName("titulo")
	private String titulo;
	@SerializedName("categoria")
	private Categoria categoria;
	@SerializedName("quantidadeDisponivel")
	private int quantidadeDisponivel;
	@SerializedName("autor")
	private String autor;

	public Livro() {

	}

	public Livro(int codigo, String titulo, Categoria categoria, int quantidadeDisponivel, String autor) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.categoria = categoria;
		this.quantidadeDisponivel = quantidadeDisponivel;
		this.autor = autor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}

	public void setQuantidadeDisponivel(int quantidadeDisponivel) {
		this.quantidadeDisponivel = quantidadeDisponivel;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
}
