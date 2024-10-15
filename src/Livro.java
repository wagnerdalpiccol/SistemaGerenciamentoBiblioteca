import java.util.Scanner;
import java.util.UUID;

public class Livro {

	private String id;
	private String titulo;
	private String autor;
	private Categoria categoria;
	private int quantidadeAcervo;
	private Livro[] livros = new Livro[10];
	private static Scanner sc;

	public Livro() {

	}

	public Livro(String titulo, String autor, Categoria categoria, int quantidadeAcervo) {
		this.id = UUID.randomUUID().toString();
		this.titulo = titulo;
		this.autor = autor;
		this.categoria = categoria;
		this.quantidadeAcervo = quantidadeAcervo;
	}

	public void cadastrar() {
		int index = -1, indexCategoria = -1;

		sc = new Scanner(System.in);

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

		System.out.print("Digite o título do livro: ");
		String titulo = sc.nextLine();

		System.out.print("Digite o autor do livro: ");
		String autor = sc.nextLine();

		do {
			System.out.print("Digite a categoria do livro: ");
			String categoriaLivro = sc.nextLine();

			for (int i = 0; i < categoria.getCategorias().length; i++) {
				if (categoria.getCategorias()[i].getNome().equals(categoriaLivro)) {
					indexCategoria = i;
					break;
				}
			}
			System.out.println("A categoria informada não existe. Tente novamente");
		} while (indexCategoria == -1);

		System.out.print("Digite a quantidade em acervo do livro: ");
		int quantidadeAcervo = sc.nextInt();

		livros[index] = new Livro(titulo, autor, categoria.getCategorias()[indexCategoria], quantidadeAcervo);
	}

	public void consultar() {
		for (Livro livro : livros) {
			if (livro != null) {
				System.out.println("* * * * * * * * * * * * * * * * * * * *");
				System.out.println("ID: " + livro.getId());
				System.out.println("TÍTULO: " + livro.getTitulo());
				System.out.println("AUTOR: " + livro.getAutor());
				System.out.println("CATEGORIA: " + livro.getCategoria().getNome());
				System.out.println("QUANTIDADE EM ACERVO: " + livro.getQuantidadeAcervo());
				System.out.println("* * * * * * * * * * * * * * * * * * * *");
			}
		}
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
