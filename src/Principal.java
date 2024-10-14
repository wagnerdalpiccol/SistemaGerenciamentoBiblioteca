import java.util.Scanner;

public class Principal {

	private static Scanner sc;
	private Categoria[] categorias = new Categoria[10];
	private Livro[] livros = new Livro[10];
	private Usuario[] usuarios = new Usuario[10];

	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.autenticacao();
		principal.menu();
	}

	public void autenticacao() {

	}

	public void menu() {

		int op;
		sc = new Scanner(System.in);

		do {
			System.out.println("* * * * * * * * * * * * * * * * * * * *");
			System.out.println("* 1. Cadastrar Categoria");
			System.out.println("* 2. Cadastrar Livro");
			System.out.println("* 3. Cadastrar Usuário");
			System.out.println("* 4. Consultar Categoria");
			System.out.println("* 5. Consultar Livro");
			System.out.println("* 6. Consultar Usuário");
			System.out.println("* 7. Finalizar Execução do Programa");
			System.out.println("* * * * * * * * * * * * * * * * * * * *");
			System.out.print("Selecione uma das operações: ");
			op = sc.nextInt();
			sc.nextLine();
			switch (op) {
			case 1:
				cadastrarCategoria();
				break;
			case 2:
				cadastrarLivro();
				break;
			case 3:
				cadastrarUsuario();
				break;
			case 4:
				consultarCategorias();
				break;
			case 5:
				consultarLivros();
				break;
			case 6:
				consultarUsuarios();
				break;
			case 7:
				System.out.println("Programa Finalizado...");
				System.exit(0);
			}

		} while (op != 4);
		sc.close();
	}

	public void cadastrarCategoria() {
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

	public void cadastrarLivro() {
		int index = -1, indexCategoria = -1;

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
			String categoria = sc.nextLine();

			for (int i = 0; i < categorias.length; i++) {
				if (categorias[i].getNome().equals(categoria)) {
					indexCategoria = i;
					break;
				}
			}
			System.out.println("A categoria informada não existe. Tente novamente");
		} while (indexCategoria == -1);

		System.out.print("Digite a quantidade em acervo do livro: ");
		int quantidadeAcervo = sc.nextInt();

		livros[index] = new Livro(titulo, autor, categorias[indexCategoria], quantidadeAcervo);
	}

	public void cadastrarUsuario() {
		int index = -1;

		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] == null) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			System.out.println("Não há espaço para cadastrar mais usuários.");
			return;
		}

		System.out.print("Digite o nome do usuário: ");
		String nome = sc.nextLine();

		System.out.print("Digite a senha do usuário: ");
		String senha = sc.nextLine();

		usuarios[index] = new Usuario(nome, senha);
	}

	public void consultarCategorias() {

	}

	public void consultarLivros() {

	}

	public void consultarUsuarios() {

	}
}
