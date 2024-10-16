public class Categoria {

	private int codigo;
	private String nome;
	private Categoria[] categorias = new Categoria[10];

	public Categoria() {

	}

	public Categoria(String nome) {
		this.codigo = obterNovoCodigo();
		this.nome = nome;
	}

	public void cadastrar(String nome) {
		int index = -1;

		for (int i = 0; i < categorias.length; i++) {
			if (categorias[i] == null) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			System.out.println("Não há espaço para cadastrar mais categorias.");
			return;
		}

		categorias[index] = new Categoria(nome);
	}

	public void consultar() {
		for (Categoria categoria : categorias) {
			if (categoria != null) {
				System.out.println("CÓDIGO: " + categoria.getCodigo());
				System.out.println("NOME: " + categoria.getNome());
				System.out.println("* * * * * * * * * * * * * * * * * * * *");
			}
		}
	}
	
	private int obterNovoCodigo() {
		Categoria ultimaCategoria = null;

		for (int i = categorias.length - 1; i >= 0; i--) {
			if (categorias[i] != null) {
				ultimaCategoria = categorias[i];
				break;
			}
		}

		if (ultimaCategoria == null) {
			return 1;
		}

		return ultimaCategoria.getCodigo() + 1;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria[] getCategorias() {
		return categorias;
	}

	public void setCategorias(Categoria[] categorias) {
		this.categorias = categorias;
	}
}
