import java.util.Scanner;
import java.util.UUID;

public class Categoria {

	private String id;
	private String nome;
	private Categoria[] categorias = new Categoria[10];
	private static Scanner sc;

	public Categoria(String nome) {
		this.id = UUID.randomUUID().toString();
		this.nome = nome;
	}

	public Categoria[] getCategorias() {
		return categorias;
	}

	public void setCategorias(Categoria[] categorias) {
		this.categorias = categorias;
	}

	public Categoria() {

	}

	public void cadastrar() {
		sc = new Scanner(System.in);
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

		System.out.print("Digite o nome da categoria: ");
		String nome = sc.nextLine();

		categorias[index] = new Categoria(nome);
	}

	public void consultar() {
		for (Categoria categoria : categorias) {
			if (categoria != null) {
				System.out.println("ID: " + categoria.getId());
				System.out.println("NOME: " + categoria.getNome());
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
