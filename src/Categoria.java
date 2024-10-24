public class Categoria {

	private String codigo;
	private String nome;
	private Categoria[] categorias = new Categoria[10];

	public Categoria() {

	}

	public Categoria(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public void cadastrar(String codigo, String nome) {
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

		categorias[index] = new Categoria(codigo, nome);
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
	
	public void consultar_esp(String codigo) {
	    boolean encontrada = false;
	    
	    for (Categoria categoria : categorias) {
	        if (categoria != null && categoria.getCodigo().equalsIgnoreCase(codigo)) {
	            System.out.println("CÓDIGO: " + categoria.getCodigo());
	            System.out.println("NOME: " + categoria.getNome());
	            System.out.println("* * * * * * * * * * * * * * * * * * * *");
	            encontrada = true;
	            break;
	        }
	    }
	    
	    if (!encontrada) {
	        System.out.println("Categoria com código " + codigo + " não foi encontrada.");
	    }
	}


	public void alterar(String codigo, String nome) {
		for (int i = 0; i < categorias.length; i++) {
			if (categorias[i] != null && categorias[i].getCodigo().equalsIgnoreCase(codigo)) {
				categorias[i] = new Categoria(codigo, nome);
				break;
			}
		}
	}

	public void remover(String codigo) {
		for (int i = 0; i < categorias.length; i++) {
			if (categorias[i] != null && categorias[i].getCodigo().equalsIgnoreCase(codigo)) {
				categorias[i] = null;
				break;
			}
		}
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
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
