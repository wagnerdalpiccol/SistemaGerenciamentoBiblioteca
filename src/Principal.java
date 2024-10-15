import java.util.Scanner;

public class Principal {

	private static Scanner sc;
	public Categoria categoria = new Categoria();
	public Livro livro = new Livro();
	public Usuario usuario = new Usuario();

	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.autenticacao();
		principal.menu();
	}

	public void autenticacao() {
		sc = new Scanner(System.in);
		System.out.println("Digite o nome: ");
		String nome = sc.nextLine();
		System.out.println("Digite a senha: ");
		String senha = sc.nextLine();
		
		if(nome.equals(usuario.getAdminNome()) && senha.equals(usuario.getAdminSenha())) {
			return;
		} else {
			for (Usuario u : usuario.getUsuarios()) {
				if(u != null) {
					if(u.getNome().equals(nome) && u.getSenha().equals(senha)) {
						return;
					}
				}
			}
		}
		
		System.out.println("O nome ou a senha informados está incorreta.");
	}

	public void menu() {

		int op;
		sc = new Scanner(System.in);

		do {
			System.out.println("* * * * * * * * * * * * * * * * * * * *");
			System.out.println("* 1. Cadastrar Categoria");
			System.out.println("* 2. Cadastrar Livro");
			System.out.println("* 3. Cadastrar Usuário");
			System.out.println("* 4. Consultar Categorias");
			System.out.println("* 5. Consultar Livros");
			System.out.println("* 6. Consultar Usuários");
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

		} while (op != 7);
		sc.close();
	}

	public void cadastrarCategoria() {
		categoria.cadastrar();
	}

	public void cadastrarLivro() {
		livro.cadastrar();
	}

	public void cadastrarUsuario() {
		usuario.cadastrar();
	}

	public void consultarCategorias() {
		categoria.consultar();
	}

	public void consultarLivros() {
		livro.consultar();
	}

	public void consultarUsuarios() {
		usuario.consultar();
	}
}
