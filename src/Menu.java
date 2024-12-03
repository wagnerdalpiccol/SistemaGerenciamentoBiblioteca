import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu {
	private static Scanner sc;
	private Biblioteca biblioteca = new Biblioteca();

	public Menu() {

	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		sc = new Scanner(System.in);
		menu.menuGeral(menu.autenticacao());
		sc.close();
	}

	// MENU

	public void menuGeral(int nivelUsuario) {
		int op = -1;

		if (biblioteca.getUsuarioAtual() == "") {
			System.out.println("Execução do programa finalizada.");
			return;
		}

		do {
			System.out.println(" 1 - Livros");
			System.out.println(" 2 - Categorias");
			if (nivelUsuario != 2) {
				System.out.println(" 3 - Leitores");
			}
			System.out.println(" 4 - Empréstimo");
			System.out.println(" 0 - sair ");

			if (sc.hasNextInt()) {
				op = sc.nextInt();
				sc.nextLine();

				switch (op) {
				case 1:
					menuLivros(nivelUsuario);
					break;
				case 2:
					menuCategorias(nivelUsuario);
					break;
				case 3:
					if (nivelUsuario != 2) {
						menuLeitores();
					}
					break;
				case 4:
					menuEmprestimo(nivelUsuario);
					break;
				case 0:
					System.out.println("Saindo...");
					menuGeral(autenticacao());
					break;
				default:
					System.out.println("Opção inválida, tente novamente.");
					break;
				}
			} else {
				System.out.println("Por favor, digite um número válido.");
				sc.nextLine();
			}
		} while (op != 0);
	}

	public void menuLivros(int nivelUsuario) {
		int op = -1;

		do {
			if (nivelUsuario != 2) {
				System.out.println(" 1 - Adicionar");
				System.out.println(" 2 - Remover");
				System.out.println(" 3 - Editar");
			}
			System.out.println(" 4 - Consultar");
			System.out.println(" 0 - sair ");

			if (sc.hasNextInt()) {
				op = sc.nextInt();
				sc.nextLine();

				switch (op) {
				case 1:
					if (nivelUsuario != 2) {
						adicionarLivro();
					}
					break;
				case 2:
					if (nivelUsuario != 2) {
						removerLivro();
					}
					break;
				case 3:
					if (nivelUsuario != 2) {
						editarLivro();
					}
					break;
				case 4:
					consultarLivro();
					break;
				case 0:
					System.out.println("Saindo...");
					break;
				default:
					System.out.println("Opção inválida, tente novamente.");
					break;
				}
			} else {
				System.out.println("Por favor, digite um número válido.");
				sc.nextLine();
			}
		} while (op != 0);
	}

	public void menuCategorias(int nivelUsuario) {
		int op = -1;

		do {
			if (nivelUsuario != 2) {
				System.out.println(" 1 - Adicionar");
				System.out.println(" 2 - Remover");
				System.out.println(" 3 - Editar");
			}
			System.out.println(" 4 - Consultar");
			System.out.println(" 0 - sair ");

			if (sc.hasNextInt()) {
				op = sc.nextInt();
				sc.nextLine();

				switch (op) {
				case 1:
					if (nivelUsuario != 2) {
						adicionarCategoria();
					}
					break;
				case 2:
					if (nivelUsuario != 2) {
						removerCategoria();
					}
					break;
				case 3:
					if (nivelUsuario != 2) {
						editarCategoria();
					}
					break;
				case 4:
					consultarCategoria();
					break;
				case 0:
					System.out.println("Saindo...");
					break;
				default:
					System.out.println("Opção inválida, tente novamente.");
					break;
				}
			} else {
				System.out.println("Por favor, digite um número válido.");
				sc.nextLine();
			}
		} while (op != 0);
	}

	public void menuLeitores() {
		int op = -1;

		do {
			System.out.println(" 1 - Adicionar");
			System.out.println(" 2 - Remover");
			System.out.println(" 3 - Editar");
			System.out.println(" 4 - Consultar");
			System.out.println(" 0 - sair ");

			if (sc.hasNextInt()) {
				op = sc.nextInt();
				sc.nextLine();

				switch (op) {
				case 1:
					adicionarLeitor();
					break;
				case 2:
					removerLeitor();
					break;
				case 3:
					editarLeitor();
					break;
				case 4:
					consultarLeitor();
					break;
				case 0:
					System.out.println("Saindo...");
					break;
				default:
					System.out.println("Opção inválida, tente novamente.");
					break;
				}
			} else {
				System.out.println("Por favor, digite um número válido.");
				sc.nextLine();
			}
		} while (op != 0);
	}

	public void menuEmprestimo(int nivelUsuario) {
		int op = -1;

		do {
			if (nivelUsuario != 1) {
				System.out.println(" 1 - Realizar Empréstimo");
			}
			System.out.println(" 2 - Consultar");
			if (nivelUsuario != 1) {
				System.out.println(" 3 - Devolução");
			}
			if (nivelUsuario != 2) {
				System.out.println(" 4 - Alterar empréstimo de um leitor");
			}
			System.out.println(" 0 - sair ");

			if (sc.hasNextInt()) {
				op = sc.nextInt();
				sc.nextLine();

				switch (op) {
				case 1:
					if (nivelUsuario != 1) {
						realizarEmprestimo();
					}
					break;
				case 2:
					consultarEmprestimo();
					break;
				case 3:
					if (nivelUsuario != 1) {
						devolucao();
					}
					break;
				case 4:
					if (nivelUsuario != 2) {
						alterarEmprestimoLeitor();
					}
				case 0:
					System.out.println("Saindo...");
					break;
				default:
					System.out.println("Opção inválida, tente novamente.");
					break;
				}
			} else {
				System.out.println("Por favor, digite um número válido.");
				sc.nextLine();
			}
		} while (op != 0);
	}

	// CATEGORIA

	public void adicionarCategoria() {
		try {
			boolean categoriaExiste;
			int codigo;

			do {
				categoriaExiste = false;
				System.out.println("Digite o código da categoria: ");
				codigo = sc.nextInt();
				sc.nextLine();

				categoriaExiste = biblioteca.categoriaExiste(codigo);

				if (categoriaExiste) {
					System.out.println("O código informado já pertence a outra categoria.");
				}

			} while (categoriaExiste);

			System.out.println("Digite a descrição da categoria: ");
			String descricao = sc.nextLine();

			biblioteca.adicionarCategoria(new Categoria(codigo, descricao));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void removerCategoria() {
		try {
			System.out.println("Digite o código da categoria que deseja remover:");
			int codigo = sc.nextInt();
			sc.nextLine();
			biblioteca.removerCategoria(codigo);

			for (Livro l : biblioteca.consultarLivros()) {
				if (l.getCategoria().getCodigo() == codigo) {
					l.setCategoria(null);
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void editarCategoria() {

		try {

			System.out.println("Digite o código da categoria que deseja editar:");
			int codigo = sc.nextInt();
			sc.nextLine();

			biblioteca.consultarCategoriaCodigo(codigo);

			System.out.println("Digite a descrição da categoria");
			String descricao = sc.nextLine();

			biblioteca.editarCategoria(new Categoria(codigo, descricao));

			for (Livro l : biblioteca.consultarLivros()) {
				if (l.getCategoria().getCodigo() == codigo) {
					l.getCategoria().setDescricao(descricao);
					biblioteca.editarLivro(l);
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void consultarCategoria() {
		int op;

		System.out.println(" 1 - Consultar Por Código");
		System.out.println(" 2 - Consultar Por Descrição");
		System.out.println(" 3 - Consultar Todos");

		op = sc.nextInt();
		sc.nextLine();

		switch (op) {
		case 1:
			try {
				System.out.println("Digite o código da categoria:");
				int codigo = sc.nextInt();
				sc.nextLine();

				Categoria categoria = biblioteca.consultarCategoriaCodigo(codigo);

				System.out.println(" Código - " + categoria.getCodigo());
				System.out.println(" Descrição - " + categoria.getDescricao());

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			break;
		case 2:
			try {
				System.out.println("Digite a descrição da categoria:");
				String descricao = sc.next().trim();
				Categoria categoria = biblioteca.consultarCategoriaDescricao(descricao);

				System.out.println(" Código - " + categoria.getCodigo());
				System.out.println(" Descrição - " + categoria.getDescricao());

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			break;
		case 3:
			try {
				List<Categoria> categorias = biblioteca.consultarCategorias();
				System.out.println("Código\t\tDescrição");
				for (Categoria c : categorias) {
					System.out.println(c.getCodigo() + "\t\t" + c.getDescricao());
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			break;
		}
	}

	// LIVRO

	public void adicionarLivro() {

		try {
			boolean livroExiste;
			int codigo;

			do {
				System.out.println("Digite o código do livro: ");
				codigo = sc.nextInt();
				sc.nextLine();

				livroExiste = biblioteca.livroExiste(codigo);

				if (livroExiste) {
					System.out.println("O código informado já pertence a outro livro.");
				}

			} while (livroExiste);

			System.out.println("Digite o título do livro: ");
			String titulo = sc.nextLine();

			System.out.println("Deseja vincular uma categoria ao livro?");
			System.out.println(" 0 - Não");
			System.out.println(" 1 - Sim");

			int vincularCategoria = sc.nextInt();
			sc.nextLine();

			Categoria categoria = null;
			if (vincularCategoria == 1) {
				System.out.println("Digite o código da categoria do livro: ");
				int codigoCategoria = sc.nextInt();
				sc.nextLine();
				categoria = biblioteca.consultarCategoriaCodigo(codigoCategoria);
			}

			System.out.println("Digite a quantidade disponível do livro: ");
			int quantidadeDisponivel = sc.nextInt();
			sc.nextLine();

			System.out.println("Digite o nome do autor do livro: ");
			String autor = sc.nextLine();

			biblioteca.adicionarLivro(new Livro(codigo, titulo, categoria, quantidadeDisponivel, autor));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void removerLivro() {
		try {
			System.out.println("Digite o código do livro que deseja remover:");
			int codigo = sc.nextInt();
			sc.nextLine();
			biblioteca.removerLivro(codigo);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void editarLivro() {
		System.out.println("Digite o código do livro que deseja editar:");
		int codigo = sc.nextInt();
		sc.nextLine();

		Livro livro = biblioteca.consultarLivroCodigo(codigo);

		System.out.println(" Selecione a opção que deseja editar:");
		System.out.println(" 1 - Título");
		System.out.println(" 2 - Autor");
		System.out.println(" 3 - Categoria");
		System.out.println(" 4 - Quantidade Disponível");

		int op = sc.nextInt();
		sc.nextLine();

		switch (op) {
		case 1:
			System.out.println("Digite o título do livro:");
			String titulo = sc.nextLine();
			livro.setTitulo(titulo);
			break;
		case 2:
			System.out.println("Digite o autor do livro:");
			String autor = sc.nextLine();
			livro.setAutor(autor);
			break;
		case 3:
			System.out.println("Digite o código da categoria:");
			int codigoCategoria = sc.nextInt();
			sc.nextLine();
			Categoria categoria = biblioteca.consultarCategoriaCodigo(codigoCategoria);
			livro.setCategoria(categoria);
			break;
		case 4:
			System.out.println("Digite a quantidade disponível: ");
			int quantidadeDisponivel = sc.nextInt();
			sc.nextLine();
			livro.setQuantidadeDisponivel(quantidadeDisponivel);
			break;
		}

		biblioteca.editarLivro(livro);
	}

	public void consultarLivro() {
		int op;

		System.out.println(" 1 - Consultar Por Código");
		System.out.println(" 2 - Consultar Por Título");
		System.out.println(" 3 - Consultar Todos");
		System.out.println(" 4 - Consultar Leitores");
		if (sc.hasNextInt()) {
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1:
				try {
					int codigo = 0;

					System.out.println("Digite o código do livro:");

					try {
						codigo = sc.nextInt();
						sc.nextLine();
					} catch (InputMismatchException e) {
						System.out.println("Entrada inválida! Por favor, insira um número inteiro.");
						sc.nextLine();
						return;
					}

					Livro livro = biblioteca.consultarLivroCodigo(codigo);

					System.out.println(" Código - " + livro.getCodigo());
					System.out.println(" Título - " + livro.getTitulo());
					System.out.println(" Autor - " + livro.getAutor());
					System.out.println("Categoria - "
							+ (livro.getCategoria() != null ? livro.getCategoria().getDescricao() : "Sem categoria"));
					System.out.println(" Quantidade Disponível - " + livro.getQuantidadeDisponivel());

				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 2:
				try {
					System.out.println("Digite o título do livro:");
					String titulo = sc.next().trim();
					Livro livro = biblioteca.consultarLivroTitulo(titulo);

					System.out.println(" Código - " + livro.getCodigo());
					System.out.println(" Título - " + livro.getTitulo());
					System.out.println(" Autor - " + livro.getAutor());
					System.out.println("Categoria - "
							+ (livro.getCategoria() != null ? livro.getCategoria().getDescricao() : "Sem categoria"));
					System.out.println(" Quantidade Disponível - " + livro.getQuantidadeDisponivel());

				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 3:
				try {
					System.out.println("Código\t\tTítulo\t\tAutor\t\tCategoria\t\tQuantidade Disponível");
					for (Livro l : biblioteca.consultarLivros()) {
						System.out.println(l.getCodigo() + "\t\t" + l.getTitulo() + "\t\t" + l.getAutor() + "\t\t"
								+ (l.getCategoria() != null ? l.getCategoria().getDescricao() : "Sem categoria")
								+ "\t\t" + l.getQuantidadeDisponivel());
					}

				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
				}

				break;

			case 4:
				try {
					System.out.println("Código\t\tTítulo\t\tAutor\t\tCategoria\t\tQuantidade Disponível");
					for (Livro l : biblioteca.consultarLivros()) {
						System.out.println(l.getCodigo() + "\t\t" + l.getTitulo() + "\t\t" + l.getAutor() + "\t\t"
								+ (l.getCategoria() != null ? l.getCategoria().getDescricao() : "Sem categoria")
								+ "\t\t" + l.getQuantidadeDisponivel());
					}

					System.out.println("Digite o código do livro que deseja ver os leitores: ");
					int codigo = sc.nextInt();
					sc.nextLine();

					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

					for (Emprestimo e : biblioteca.consultarEmpresitmosPorCodigoLivro(codigo)) {
						System.out.println(e.getLeitor().getUsuario() + "\t\t" + e.getLivro().getTitulo() + "\t\t"
								+ sdf.format(e.getDataInicio()) + "\t\t" + sdf.format(e.getDataFim()));
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			}

		} else {
			System.out.println("Número válido digitado.");
			sc.nextLine();
		}
	}

	// LEITOR

	public void adicionarLeitor() {
		try {
			boolean leitorExiste;
			String usuario;
			do {

				System.out.println("Digite o nome de usuário do leitor: ");
				usuario = sc.nextLine();

				leitorExiste = biblioteca.leitorExiste(usuario);

				if (leitorExiste) {
					System.out.println("O usuário de nome " + usuario + " já existe");
				}

			} while (leitorExiste);

			System.out.println("Digite a senha do leitor: ");
			String senha = sc.nextLine();

			biblioteca.adicionarLeitor(new Leitor(usuario, senha));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void removerLeitor() {
		System.out.println("Digite o nome de usuário do leitor que deseja remover:");
		String usuario = sc.nextLine();

		for (Leitor l : biblioteca.consultarLeitores()) {
			if (l.getUsuario().equals(usuario)) {
				biblioteca.removerLeitor(usuario);
				return;
			}
		}

		System.out.println("O leitor com nome de usuário " + usuario + " não foi encontrado.");
	}

	public void editarLeitor() {

		try {
			System.out.println("Digite o nome de usuário do leitor que deseja editar:");
			String usuario = sc.nextLine();

			Leitor leitor = biblioteca.consultarLeitorUsuario(usuario);

			System.out.println("Selecione o campo que deseja editar:");
			System.out.println("1 - Usuário");
			System.out.println("2 - Senha");

			if (sc.hasNextInt()) {
				int op = sc.nextInt();
				sc.nextLine();

				switch (op) {
				case 1:
					System.out.println("Digite o novo nome de usuário:");
					String novoUsuario = sc.nextLine();
					leitor.setUsuario(novoUsuario);
					break;
				case 2:
					System.out.println("Digite a nova senha:");
					String novaSenha = sc.nextLine();
					leitor.setSenha(novaSenha);
					break;
				default:
					System.out.println("Opção inválida.");
					return;
				}
			} else {
				System.out.println("Por favor, digite um número válido.");
				sc.nextLine();
			}

			biblioteca.editarLeitor(leitor, usuario);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void consultarLeitor() {
		int op;

		System.out.println(" 1 - Consultar Por Usuário");
		System.out.println(" 2 - Consultar Todos");
		if (sc.hasNextInt()) {
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1:
				System.out.println("Digite o nome de usuário:");
				String usuario = sc.nextLine();
				try {
					Leitor leitor = biblioteca.consultarLeitorUsuario(usuario);
					System.out.println("Usuário: " + leitor.getUsuario());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println("Usuário");
				for (Leitor l : biblioteca.consultarLeitores()) {
					System.out.println(l.getUsuario());
				}
				break;
			default:
				System.out.println("Opção inválida.");
				return;
			}
		} else {
			System.out.println("Por favor, digite um número válido.");
			sc.nextLine();
		}
	}

	// EMPRÉSTIMO

	public void realizarEmprestimo() {

		try {
			List<Livro> livros = biblioteca.consultarLivros();
			System.out.println("Código\t\tTítulo\t\tAutor\t\tCategoria\t\tQuantidade Disponível");
			for (Livro l : livros) {
				System.out.println(l.getCodigo() + "\t\t" + l.getTitulo() + "\t\t" + l.getAutor() + "\t\t"
						+ (l.getCategoria() != null ? l.getCategoria().getDescricao() : "Sem categoria") + "\t\t"
						+ l.getQuantidadeDisponivel());
			}

			System.out.println("Digite o código do livro: ");
			int codigo = sc.nextInt();
			sc.nextLine();
			Livro livro = biblioteca.consultarLivroCodigo(codigo);

			biblioteca.livroDisponivel(livro);

			Leitor leitor = biblioteca.consultarLeitorUsuario(biblioteca.getUsuarioAtual());

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			System.out.println("Digite a data de início do empréstimo do livro (dd/MM/yyyy): ");
			String dataInicio = sc.nextLine();
			System.out.println("Digite a data de fim do empréstimo do livro (dd/MM/yyyy): ");
			String dataFim = sc.nextLine();

			Date dtInicio = sdf.parse(dataInicio);
			Date dtFim = sdf.parse(dataFim);

			biblioteca.verificaDatas(dtInicio, dtFim);

			livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel() - 1);
			biblioteca.editarLivro(livro);
			biblioteca.realizarEmprestimo(new Emprestimo(leitor, livro, dtInicio, dtFim));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void consultarEmprestimo() {
		int op;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println(" 1 - Consultar Por Código do Livro");
		System.out.println(" 2 - Consultar Por Título do Livro");
		System.out.println(" 3 - Consultar Por Datas");
		System.out.println(" 4 - Consultar Por Usuário do Leitor");
		if (sc.hasNextInt()) {
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1:
				try {
					System.out.println("Digite o código do livro: ");
					if (sc.hasNextInt()) {
						int codigo = sc.nextInt();
						sc.nextLine();
						Emprestimo e = biblioteca.consultarEmprestimoPorCodigoLeitor(codigo);
						System.out.println("Leitor: " + e.getLeitor().getUsuario());
						System.out.println("Livro: " + e.getLivro().getTitulo());
						System.out.println(
								"Início: " + sdf.format(e.getDataInicio()) + " Fim:" + sdf.format(e.getDataFim()));

					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;
			case 2:
				try {
					System.out.println("Digite o título do livro: ");
					String titulo = sc.nextLine();

					Emprestimo e = biblioteca.consultarEmprestimoPorTitulo(titulo);
					System.out.println("Leitor: " + e.getLeitor().getUsuario());
					System.out.println("Livro: " + e.getLivro().getTitulo());
					System.out
							.println("Início: " + sdf.format(e.getDataInicio()) + " Fim:" + sdf.format(e.getDataFim()));
				}

				catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;
			case 3:
				try {
					System.out.println("Digite a data de início do empréstimo do livro (dd/MM/yyyy): ");
					String dataInicio = sc.nextLine();
					System.out.println("Digite a data de fim do empréstimo do livro (dd/MM/yyyy): ");
					String dataFim = sc.nextLine();

					Date dtInicio = sdf.parse(dataInicio);
					Date dtFim = sdf.parse(dataFim);

					System.out.println("Leitor\t\tLivro\t\tInício\t\tFim");
					for (Emprestimo e : biblioteca.consultarEmprestimoPorDatas(dtInicio, dtFim)) {
						System.out.println(e.getLeitor().getUsuario() + "\t\t" + e.getLivro().getTitulo() + "\t\t"
								+ sdf.format(e.getDataInicio()) + "\t\t" + sdf.format(e.getDataFim()));
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println("Digite o nome de usuário que deseja ver os empréstimos: ");
				String usuario = sc.nextLine();
				List<Emprestimo> emprestimos = biblioteca.consultarEmprestimoPorLeitor(usuario);
				System.out.println("Usuário\t\tTítulo\t\tInício\t\tFim");
				for (Emprestimo e : emprestimos) {
					System.out.println(e.getLeitor().getUsuario() + "\t\t" + e.getLivro().getTitulo() + "\t\t"
							+ sdf.format(e.getDataInicio()) + "\t\t" + sdf.format(e.getDataFim()));
				}
				break;
			}
		} else

		{
			System.out.println("Número válido digitado.");
			sc.nextLine();
		}
	}

	public void devolucao() {
		System.out.println("Digite o código do livro a ser devolvido: ");
		int codigo = sc.nextInt();
		sc.nextLine();

		Livro livro = biblioteca.consultarLivroCodigo(codigo);
		biblioteca.removerEmprestimo(codigo, biblioteca.getUsuarioAtual());
		livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel() + 1);
		biblioteca.editarLivro(livro);
	}
	
	public void alterarEmprestimoLeitor() {
		try {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Digite o nome de usuário do leitor: ");
		String usuario = sc.nextLine();
		
		List<Emprestimo> emprestimosLeitor = biblioteca.consultarEmprestimoPorLeitor(usuario);
		
		for (Emprestimo e : emprestimosLeitor) {
			System.out.println(e.getLeitor().getUsuario() + "\t\t" + e.getLivro().getTitulo() + "\t\t"
					+ sdf.format(e.getDataInicio()) + "\t\t" + sdf.format(e.getDataFim()));
		}
		
		System.out.println("Digite o código do livro que deseja alterar a data de empréstimo: ");
		int codigo = sc.nextInt();
		sc.nextLine();
		
		biblioteca.consultarEmpresitmosPorCodigoLivro(codigo);
		
		System.out.println("Digite a data de início do empréstimo do livro (dd/MM/yyyy): ");
		String dataInicio = sc.nextLine();
		System.out.println("Digite a data de fim do empréstimo do livro (dd/MM/yyyy): ");
		String dataFim = sc.nextLine();

		Date dtInicio = sdf.parse(dataInicio);
		Date dtFim = sdf.parse(dataFim);
		
		Leitor leitor = biblioteca.consultarLeitorUsuario(usuario);
		Livro livro = biblioteca.consultarLivroCodigo(codigo);
		
		biblioteca.editarEmprestimo(new Emprestimo(leitor, livro, dtInicio, dtFim));
		
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// AUTENTICAÇÂO

	public int autenticacao() {
		int nivelUsuario = 0;
		System.out.println("Para finalizar a execução do programa digite 0 em nome de usuário e senha.\n");
		System.out.println("* Autenticação *\n");
		do {
			System.out.print("Digite o nome de usuário: ");
			String usuario = sc.nextLine();

			System.out.print("Digite a senha: ");
			String senha = sc.nextLine();

			nivelUsuario = biblioteca.autenticacao(usuario, senha);

			if (nivelUsuario == 0) {
				System.out.println("Usuário ou senha incorretos.");
			}

		} while (nivelUsuario == 0);

		return nivelUsuario;
	}
}
