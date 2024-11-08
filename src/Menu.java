import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu {
	private static Scanner sc;
	private Biblioteca biblioteca = new Biblioteca();

	public Menu() {

	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.menuGeral();
	}

	public void menuGeral() {
		int op;
		sc = new Scanner(System.in);

		do {
			System.out.println("----------------------------------------");
			System.out.println(" 1 - Livros");
			System.out.println(" 2 - Categorias");
			System.out.println(" 0 - sair ");
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1:
				menuLivros();
				break;
			case 2:
				menuCategorias();
				break;
			}
			System.out.println("----------------------------------------");
		} while (op != 0);

		sc.close();
	}

	public void menuLivros() {
		int op;

		do {
			System.out.println("----------------------------------------");
			System.out.println(" 1 - Adicionar");
			System.out.println(" 2 - Remover");
			System.out.println(" 3 - Editar");
			System.out.println(" 4 - Consultar");
			System.out.println(" 0 - sair ");
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1:
				adicionarLivro();
				break;
			case 2:
				removerLivro();
				break;
			case 3:
				editarLivro();
				break;
			case 4:
				consultarLivro();
				break;
			}
			System.out.println("----------------------------------------");
		} while (op != 0);
	}

	public void menuCategorias() {

	}

	// LIVROS

	public void adicionarLivro() {

	}

	public void removerLivro() {

	}

	public void editarLivro() {

	}

	public void consultarLivro() {
		int op;

		System.out.println(" 1 - Consultar Por Código");
		System.out.println(" 2 - Consultar Por Título");
		System.out.println(" 3 - Consultar Todos");

		op = sc.nextInt();
		sc.nextLine();

		switch (op) {
		case 1:
			try {
				System.out.println("Digite o código do livro:");
				int codigo = sc.nextInt();
				sc.nextLine();
				biblioteca.consultarLivroCodigo(codigo);
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 2:
			try {
				System.out.println("Digite o título do livro:");
				String titulo = sc.next().trim();
				biblioteca.consultarLivroTitulo(titulo);
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
			}

			break;
		case 3:
			try {
				biblioteca.consultarLivros();
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
			}

			break;
		}
	}
}
