import java.util.Scanner;

public class Principal {

	private static Scanner sc = new Scanner(System.in);;
	public Categoria categoria = new Categoria();
	public Livro livro = new Livro();
	public Usuario usuario = new Usuario();

	public static void main(String[] args) {
		Principal principal = new Principal();
		//principal.autenticacao();
		principal.menu();
	}

	public void autenticacao() {
		sc = new Scanner(System.in);
		System.out.println("Digite o nome: ");
		String nome = sc.nextLine();
		System.out.println("Digite a senha: ");
		String senha = sc.nextLine();

		if (nome.equals(usuario.getAdminNome()) && senha.equals(usuario.getAdminSenha())) {
			return;
		} else {
			for (Usuario u : usuario.getUsuarios()) {
				if (u != null) {
					if (u.getNome().equals(nome) && u.getSenha().equals(senha)) {
						return;
					}
				}
			}
		}

		System.out.println("O nome ou a senha informados está incorreta.");
	}

	public void menu() {
	    int opPrincipal;

	    do {
	        System.out.println("* * * * MENU PRINCIPAL * * * *");
	        System.out.println("* 1. Categoria");
	        System.out.println("* 2. Livro");
	        System.out.println("* 3. Usuário");
	        System.out.println("* 4. Finalizar Execução do Programa");
	        System.out.println("* * * * * * * * * * * * * * * * * * * *");
	        System.out.print("Selecione uma das opções: ");
	        opPrincipal = sc.nextInt();
	        sc.nextLine();

	        switch (opPrincipal) {
	            case 1:
	                menuCategoria();
	                break;
	            case 2:
	                menuLivro();
	                break;
	            case 3:
	                menuUsuario();
	                break;
	            case 4:
	                System.out.println("Programa Finalizado...");
	                System.exit(0);
	            default:
	                System.out.println("Opção inválida! Tente novamente.");
	        }

	    } while (opPrincipal != 4);
	    sc.close();
	}

	public void menuCategoria() {
	    int opCategoria;
	    do {
	        System.out.println("* * * * MENU CATEGORIA * * * *");
	        System.out.println("* 1. Cadastrar Categoria");
	        System.out.println("* 2. Consultar Categorias");
	        System.out.println("* 3. Voltar ao Menu Principal");
	        System.out.println("* * * * * * * * * * * * * * * * * * * *");
	        System.out.print("Selecione uma das opções: ");
	        opCategoria = sc.nextInt();
	        sc.nextLine();

	        switch (opCategoria) {
	            case 1:
	                cadastrarCategoria();
	                break;
	            case 2:
	                categoria.consultar();
	                break;
	            case 3:
	                break;
	            default:
	                System.out.println("Opção inválida! Tente novamente.");
	        }
	    } while (opCategoria != 3);
	}

	public void menuLivro() {
	    int opLivro;
	    do {
	        System.out.println("* * * * MENU LIVRO * * * *");
	        System.out.println("* 1. Cadastrar Livro");
	        System.out.println("* 2. Consultar Livros");
	        System.out.println("* 3. Voltar ao Menu Principal");
	        System.out.println("* * * * * * * * * * * * * * * * * * * *");
	        System.out.print("Selecione uma das opções: ");
	        opLivro = sc.nextInt();
	        sc.nextLine();

	        switch (opLivro) {
	            case 1:
	                cadastrarLivro();
	                break;
	            case 2:
	                livro.consultar();
	                break;
	            case 3:
	                break;
	            default:
	                System.out.println("Opção inválida! Tente novamente.");
	        }
	    } while (opLivro != 3);
	}

	public void menuUsuario() {
	    int opUsuario;
	    do {
	        System.out.println("* * * * MENU USUÁRIO * * * *");
	        System.out.println("* 1. Cadastrar Usuário");
	        System.out.println("* 2. Consultar Usuários");
	        System.out.println("* 3. Voltar ao Menu Principal");
	        System.out.println("* * * * * * * * * * * * * * * * * * * *");
	        System.out.print("Selecione uma das opções: ");
	        opUsuario = sc.nextInt();
	        sc.nextLine();

	        switch (opUsuario) {
	            case 1:
	                cadastrarUsuario();
	                break;
	            case 2:
	                usuario.consultar();
	                break;
	            case 3:
	                break;
	            default:
	                System.out.println("Opção inválida! Tente novamente.");
	        }
	    } while (opUsuario != 3);
	}


	public void cadastrarCategoria() {
		System.out.println("Digite o nome da categoria: ");
		String nome = sc.nextLine();
		categoria.cadastrar(nome);
	}

	public void cadastrarLivro() {
		
		System.out.println("Digite o título do livro: ");
		String titulo = sc.nextLine();

		System.out.println("Digite o autor do livro: ");
		String autor = sc.nextLine();

		System.out.println("Digite a quantidade em acervo: ");
		int quantidadeAcervo = sc.nextInt();

		Categoria categoriaEscolhida = null;
		while (categoriaEscolhida == null) {
			System.out.println("Digite a categoria do livro: ");
			String nomeCategoria = sc.nextLine();

			for (Categoria c : categoria.getCategorias()) {
				if (c != null && c.getNome().equalsIgnoreCase(nomeCategoria)) {
					categoriaEscolhida = c;
					break;
				}
			}

			if (categoriaEscolhida == null) {
				System.out.println("Categoria não encontrada. Tente novamente.");
			}
		}

		livro.cadastrar(titulo, autor, categoriaEscolhida, quantidadeAcervo);
	}

	public void cadastrarUsuario() {
		System.out.print("Digite o nome do usuário: ");
		String nome = sc.nextLine();

		System.out.print("Digite a senha do usuário: ");
		String senha = sc.nextLine();
		
		usuario.cadastrar(nome, senha);
	}
}
