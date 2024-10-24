import java.util.Scanner;

public class Principal {

	private static Scanner sc = new Scanner(System.in);;
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
		boolean autenticado = false;

		while (!autenticado) {
			System.out.println("Digite o nome: ");
			String nome = sc.nextLine();
			System.out.println("Digite a senha: ");
			String senha = sc.nextLine();

			if (nome.equals(usuario.getAdminNome()) && senha.equals(usuario.getAdminSenha())) {
				autenticado = true;
			} else {

				for (Usuario u : usuario.getUsuarios()) {
					if (u != null && u.getNome().equals(nome) && u.getSenha().equals(senha)) {
						autenticado = true;
						break;
					}
				}
			}

			if (!autenticado) {
				System.out.println("O nome ou a senha informados estão incorretos. Tente novamente.");
			}
		}
	}

	public void menu() {
		int op;

		do {
			System.out.println("* * * * MENU PRINCIPAL * * * *");
			System.out.println("* 1. Categoria");
			System.out.println("* 2. Livro");
			System.out.println("* 3. Usuário");
			System.out.println("* 4. Finalizar Execução do Programa");
			System.out.println("* * * * * * * * * * * * * * * * * * * *");
			System.out.print("Selecione uma das opções: ");
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
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

		} while (op != 4);
		sc.close();
	}

	public void menuCategoria() {
		int op;
		do {
			System.out.println("* * * * MENU CATEGORIA * * * *");
			System.out.println("* 1. Cadastrar");
			System.out.println("* 2. Consultar");
			System.out.println("* 3. Consultar específica");
			System.out.println("* 4. Alterar");
			System.out.println("* 5. Remover");
			System.out.println("* 6. Voltar ao Menu Principal");
			System.out.println("* * * * * * * * * * * * * * * * * * * *");
			System.out.print("Selecione uma das opções: ");
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1:
				cadastrarCategoria();
				break;
			case 2:
				categoria.consultar();
				break;
			case 3:
				System.out.println("Digite o código da categoria: ");
				String codigoConsulta = sc.nextLine();
				categoria.consultar_esp(codigoConsulta);
           
				break;
			case 4:
				alterarCategoria();
				break;
			case 5:
				removerCategoria();
				break;
			case 6:
				break;
			default:
				System.out.println("Opção inválida! Tente novamente.");
			}
		} while (op != 6);
	}

	public void menuLivro() {
		int opLivro;
		do {
			System.out.println("* * * * MENU LIVRO * * * *");
			System.out.println("* 1. Cadastrar");
			System.out.println("* 2. Consultar");
			System.out.println("* 3. Consultar específico");
			System.out.println("* 4. Alterar");
			System.out.println("* 5. Remover");
			System.out.println("* 6. Voltar ao Menu Principal");
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
				System.out.println("Digite o código do livro: ");
				String codigoLivro = sc.nextLine();
				livro.consultar_esp(codigoLivro);
				break;
			case 4:
				alterarLivro();
				break;
			case 5:
				removerLivro();
				break;
			case 6:
				break;
			default:
				System.out.println("Opção inválida! Tente novamente.");
			}
		} while (opLivro != 6);
	}

	public void menuUsuario() {
		int op;
		do {
			System.out.println("* * * * MENU USUÁRIO * * * *");
			System.out.println("* 1. Cadastrar");
			System.out.println("* 2. Consultar");
			System.out.println("* 3. Consultar específico");
			System.out.println("* 4. Alterar");
			System.out.println("* 5. Remover");
			System.out.println("* 6. Voltar ao Menu Principal");
			System.out.println("* * * * * * * * * * * * * * * * * * * *");
			System.out.print("Selecione uma das opções: ");
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1:
				cadastrarUsuario();
				break;
			case 2:
				usuario.consultar();
				break;
			
			case 3:
				System.out.println("Digite o nome do usuário: ");
				String nomeUsuario = sc.nextLine();
				usuario.consultar_esp(nomeUsuario);
				break;
				
			case 4:
				alterarUsuario();
				break;
			case 5:
				removerUsuario();
				break;
			case 6:
				break;
			default:
				System.out.println("Opção inválida! Tente novamente.");
			}
		} while (op != 6);
	}

	public void cadastrarCategoria() {
		String codigo = null;

		while (codigo == null) {
			System.out.println("Digite o código da categoria: ");
			codigo = sc.nextLine();

			for (Categoria c : categoria.getCategorias()) {

				if (c != null && c.getCodigo().equalsIgnoreCase(codigo)) {
					codigo = null;
					System.out.println("O código informado já pertence a outro registro.");
				}

			}
		}

		System.out.println("Digite o nome da categoria: ");
		String nome = sc.nextLine();
		categoria.cadastrar(codigo, nome);
	}

	public void cadastrarLivro() {
		String codigo = null;
		Boolean vazio = true;
		
		for (Categoria c : categoria.getCategorias()) {
			if(c != null) {
				vazio = false;
			}
		}
		
		if(vazio) {
			System.out.println("Antes de cadastrar um livro, é necessário cadastrar uma categoria.");
			return;
		}
		

		while (codigo == null) {
			System.out.println("Digite o código do livro: ");
			codigo = sc.nextLine();

			for (Livro l : livro.getLivros()) {

				if (l != null && l.getCodigo().equalsIgnoreCase(codigo)) {
					codigo = null;
					System.out.println("O código informado já pertence a outro registro.");
				}

			}
		}

		System.out.println("Digite o título do livro: ");
		String titulo = sc.nextLine();

		System.out.println("Digite o autor do livro: ");
		String autor = sc.nextLine();

		System.out.println("Digite a quantidade em acervo: ");
		int quantidadeAcervo = sc.nextInt();
		
		sc.nextLine();
		
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

		livro.cadastrar(codigo, titulo, autor, categoriaEscolhida, quantidadeAcervo);
	}

	public void cadastrarUsuario() {

		String nome = null;

		while (nome == null) {
			System.out.println("Digite o nome de usuário: ");
			nome = sc.nextLine();

			for (Usuario u : usuario.getUsuarios()) {

				if (u != null && u.getNome().equalsIgnoreCase(nome)) {
					nome = null;
					System.out.println("O nome informado já pertence a outro usuário.");
				}

			}
		}

		System.out.print("Digite a senha do usuário: ");
		String senha = sc.nextLine();
		
		System.out.print("Digite o email do usuário: ");
		String email = sc.nextLine();

		usuario.cadastrar(nome, senha, email);
	}

	public void alterarCategoria() {
		System.out.println("Digite o código da categoria: ");
		String codigo = sc.nextLine();

		System.out.println("Digite o nome da categoria: ");
		String nome = sc.nextLine();

		categoria.alterar(codigo, nome);
	}

	public void alterarLivro() {

		String codigo = null;

		while (codigo == null) {
			System.out.println("Digite o código do livro: ");
			codigo = sc.nextLine();

			for (Livro l : livro.getLivros()) {

				if (l != null && l.getCodigo().equalsIgnoreCase(codigo)) {
					codigo = null;
					System.out.println("O código informado já pertence a outro registro.");
				}

			}
		}

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

		livro.alterar(codigo, titulo, autor, categoriaEscolhida, quantidadeAcervo);
	}

	public void alterarUsuario() {
		System.out.print("Digite o nome do usuário: ");
		String nome = sc.nextLine();

		System.out.print("Digite a senha do usuário: ");
		String senha = sc.nextLine();
		
		System.out.print("Digite o email do usuário: ");
		String email = sc.nextLine();
		usuario.alterar(nome, senha, email);
	}

	public void removerCategoria() {
		System.out.println("Digite o código da categoria: ");
		String codigo = sc.nextLine();
		categoria.remover(codigo);
	}

	public void removerLivro() {
		System.out.println("Digite o código do livro: ");
		String codigo = sc.nextLine();
		livro.remover(codigo);
	}

	public void removerUsuario() {
		System.out.println("Digite o nome do usuário: ");
		String nome = sc.nextLine();
		usuario.remover(nome);
	}
}
