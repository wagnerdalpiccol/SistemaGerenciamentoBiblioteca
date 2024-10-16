public class Livro {

	private int codigo;
	private String titulo;
	private String autor;
	private Categoria categoria;
	private int quantidadeAcervo;
	private Livro[] livros = new Livro[10];

	public Livro() {

	}

	public Livro(String titulo, String autor, Categoria categoria, int quantidadeAcervo) {
		this.codigo = obterNovoCodigo();
		this.titulo = titulo;
		this.autor = autor;
		this.categoria = categoria;
		this.quantidadeAcervo = quantidadeAcervo;
	}

	public void cadastrar(String titulo, String autor, Categoria categoria, int quantidadeAcervo) {
		int index = -1;

		for (int i = 0; i < livros.length; i++) {
			if (livros[i] == null) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			System.out.println("Não há espaço para cadastrar mais livros.");
			return;
		}

		livros[index] = new Livro(titulo, autor, categoria, quantidadeAcervo);
	}

	public void consultar() {
		for (Livro livro : livros) {
			if (livro != null) {
				System.out.println("* * * * * * * * * * * * * * * * * * * *");
				System.out.println("ID: " + livro.getCodigo());
				System.out.println("TÍTULO: " + livro.getTitulo());
				System.out.println("AUTOR: " + livro.getAutor());
				System.out.println("CATEGORIA: " + livro.getCategoria().getNome());
				System.out.println("QUANTIDADE EM ACERVO: " + livro.getQuantidadeAcervo());
				System.out.println("* * * * * * * * * * * * * * * * * * * *");
			}
		}
	}
	
	private int obterNovoCodigo() {
		Livro ultimoLivro = null;

		for (int i = livros.length - 1; i >= 0; i--) {
			if (livros[i] != null) {
				ultimoLivro = livros[i];
				break;
			}
		}

		if (ultimoLivro == null) {
			return 1;
		}

		return ultimoLivro.getCodigo() + 1;
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
