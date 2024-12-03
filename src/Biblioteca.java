import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

public class Biblioteca {
	private List<Livro> livros = new ArrayList<Livro>();
	private List<Categoria> categorias = new ArrayList<Categoria>();
	private List<Leitor> leitores = new ArrayList<Leitor>();
	private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
	private String usuarioAtual;

	public Biblioteca() {

	}

	// LIVRO

	public void adicionarLivro(Livro livro) {
		List<Livro> livros = Arquivo.lerArquivo(Livro.class);
		livros.add(livro);
		Arquivo.escreverArquivo(livros, Livro.class);
	}

	public void removerLivro(int codigo) throws NoSuchElementException {
		List<Livro> livros = Arquivo.lerArquivo(Livro.class);
		Livro livroRemover = null;

		for (Livro livro : livros) {
			if (livro.getCodigo() == codigo) {
				livroRemover = livro;
				break;
			}
		}

		if (livroRemover != null) {
			livros.remove(livroRemover);
			Arquivo.escreverArquivo(livros, Livro.class);
		} else {
			throw new NoSuchElementException("Livro com código " + codigo + " não encontrado.");
		}
	}

	public void editarLivro(Livro livro) throws NoSuchElementException {
		List<Livro> livros = Arquivo.lerArquivo(Livro.class);

		for (int i = 0; i < livros.size(); i++) {
			if (livros.get(i).getCodigo() == livro.getCodigo()) {
				livros.set(i, livro);
				Arquivo.escreverArquivo(livros, Livro.class);
				return;
			}
		}

		throw new NoSuchElementException("Livro com código " + livro.getCodigo() + " não encontrado.");
	}

	public Livro consultarLivroCodigo(int codigo) throws NoSuchElementException {
		List<Livro> livros = Arquivo.lerArquivo(Livro.class);

		for (Livro livro : livros) {
			if (livro.getCodigo() == codigo) {
				return livro;
			}
		}

		throw new NoSuchElementException("Livro com código " + codigo + " não encontrado.");
	}

	public Livro consultarLivroTitulo(String titulo) throws NoSuchElementException {
		List<Livro> livros = Arquivo.lerArquivo(Livro.class);

		for (Livro livro : livros) {
			if (livro.getTitulo().equals(titulo)) {
				return livro;
			}
		}

		throw new NoSuchElementException("Livro com título '" + titulo + "' não encontrado.");
	}

	public List<Livro> consultarLivros() {
		return Arquivo.lerArquivo(Livro.class);
	}

	public boolean livroExiste(int codigo) {
		for (Livro l : livros) {
			if (l.getCodigo() == codigo) {
				return true;
			}
		}
		return false;
	}

	public void livroDisponivel(Livro livro) throws IllegalStateException {
		if (livro.getQuantidadeDisponivel() == 0) {
			throw new IllegalStateException("O livro não está disponível no momento.");
		}
	}

	// CATEGORIA

	public void adicionarCategoria(Categoria categoria) {
		List<Categoria> categorias = Arquivo.lerArquivo(Categoria.class);
		categorias.add(categoria);
		Arquivo.escreverArquivo(categorias, Categoria.class);
	}

	public void removerCategoria(int codigo) throws NoSuchElementException {
		List<Categoria> categorias = Arquivo.lerArquivo(Categoria.class);
		Categoria categoriaRemover = null;

		for (Categoria categoria : categorias) {
			if (categoria.getCodigo() == codigo) {
				categoriaRemover = categoria;
				break;
			}
		}

		if (categoriaRemover != null) {
			categorias.remove(categoriaRemover);
			Arquivo.escreverArquivo(categorias, Categoria.class);
		} else {
			throw new NoSuchElementException("Categoria com código " + codigo + " não encontrada.");
		}
	}

	public void editarCategoria(Categoria categoria) throws NoSuchElementException {
		List<Categoria> categorias = Arquivo.lerArquivo(Categoria.class);

		for (int i = 0; i < categorias.size(); i++) {
			if (categorias.get(i).getCodigo() == categoria.getCodigo()) {
				categorias.set(i, categoria);
				Arquivo.escreverArquivo(categorias, Categoria.class);
				return;
			}
		}

		throw new NoSuchElementException("Categoria com código " + categoria.getCodigo() + " não encontrada.");
	}

	public Categoria consultarCategoriaCodigo(int codigo) throws NoSuchElementException {
		List<Categoria> categorias = Arquivo.lerArquivo(Categoria.class);

		for (Categoria categoria : categorias) {
			if (categoria.getCodigo() == codigo) {
				return categoria;
			}
		}

		throw new NoSuchElementException("Categoria com código " + codigo + " não encontrada.");
	}

	public Categoria consultarCategoriaDescricao(String descricao) throws NoSuchElementException {
		List<Categoria> categorias = Arquivo.lerArquivo(Categoria.class);

		for (Categoria categoria : categorias) {
			if (categoria.getDescricao().equals(descricao)) {
				return categoria;
			}
		}

		throw new NoSuchElementException("Categoria com descrição '" + descricao + "' não encontrada.");
	}

	public List<Categoria> consultarCategorias() {
		return Arquivo.lerArquivo(Categoria.class);
	}

	public boolean categoriaExiste(int codigo) {
		for (Categoria c : categorias) {
			if (c.getCodigo() == codigo) {
				return true;
			}
		}
		return false;
	}

	// LEITOR

	public void adicionarLeitor(Leitor leitor) {
		leitores = Arquivo.lerArquivo(Leitor.class);
		leitores.add(leitor);
		Arquivo.escreverArquivo(leitores, Leitor.class);
	}

	public void removerLeitor(String usuario) throws NoSuchElementException {
		leitores = Arquivo.lerArquivo(Leitor.class);
		Leitor leitorRemover = null;

		for (Leitor l : leitores) {
			if (l.getUsuario().equals(usuario)) {
				leitorRemover = l;
				break;
			}
		}

		if (leitorRemover != null) {
			leitores.remove(leitorRemover);
			Arquivo.escreverArquivo(leitores, Leitor.class);
		} else {
			throw new NoSuchElementException("Leitor com usuário " + usuario + " não encontrado.");
		}
	}

	public void editarLeitor(Leitor leitor, String usuario) throws NoSuchElementException {
		leitores = Arquivo.lerArquivo(Leitor.class);
		boolean encontrado = false;

		for (int i = 0; i < leitores.size(); i++) {
			if (leitores.get(i).getUsuario().equals(usuario)) {
				leitores.set(i, leitor);
				encontrado = true;
				break;
			}
		}

		if (!encontrado) {
			throw new NoSuchElementException("Leitor com usuário " + leitor.getUsuario() + " não encontrado.");
		}

		Arquivo.escreverArquivo(leitores, Leitor.class);
	}

	public Leitor consultarLeitorUsuario(String usuario) throws NoSuchElementException {
		leitores = consultarLeitores();

		for (Leitor l : leitores) {
			if (l.getUsuario().equals(usuario)) {
				return l;
			}
		}
		throw new NoSuchElementException("Leitor com usuário " + usuario + " não encontrado.");
	}

	public List<Leitor> consultarLeitores() {
		return Arquivo.lerArquivo(Leitor.class);
	}

	public boolean leitorExiste(String usuario) {
		leitores = consultarLeitores();

		for (Leitor l : leitores) {
			if (l.getUsuario().equals(usuario)) {
				return true;
			}
		}
		return false;
	}

	// EMPRÉSTIMO

	public void realizarEmprestimo(Emprestimo emprestimo) {

		emprestimos = Arquivo.lerArquivo(Emprestimo.class);
		emprestimos.add(emprestimo);
		Arquivo.escreverArquivo(emprestimos, Emprestimo.class);
	}

	public List<Emprestimo> consultarEmpresitmosPorCodigoLivro(int codigo) {
		List<Emprestimo> todosEmprestimos = Arquivo.lerArquivo(Emprestimo.class);

		for (Emprestimo e : todosEmprestimos) {
			if (e.getLivro().getCodigo() == codigo) {
				emprestimos.add(e);
			}
		}

		return emprestimos;
	}

	public Emprestimo consultarEmprestimoPorCodigoLeitor(int codigo) {
		List<Emprestimo> todosEmprestimos = Arquivo.lerArquivo(Emprestimo.class);

		for (Emprestimo emprestimo : todosEmprestimos) {
			if (emprestimo.getLivro().getCodigo() == codigo
					&& emprestimo.getLeitor().getUsuario().equals(getUsuarioAtual())) {
				return emprestimo;
			}
		}
		throw new NoSuchElementException("Empréstimo não encontrado.");
	}

	public Emprestimo consultarEmprestimoPorTitulo(String titulo) {
		List<Emprestimo> todosEmprestimos = Arquivo.lerArquivo(Emprestimo.class);

		for (Emprestimo emprestimo : todosEmprestimos) {
			if (emprestimo.getLivro().getTitulo().equalsIgnoreCase(titulo)
					&& emprestimo.getLeitor().getUsuario().equals(getUsuarioAtual())) {
				return emprestimo;
			}
		}

		throw new NoSuchElementException("Empréstimo não encontrado.");
	}

	public List<Emprestimo> consultarEmprestimoPorDatas(Date dataInicio, Date dataFim) {
		List<Emprestimo> todosEmprestimos = Arquivo.lerArquivo(Emprestimo.class);

		for (Emprestimo emprestimo : todosEmprestimos) {
			if (!emprestimo.getDataFim().before(dataInicio) && !emprestimo.getDataInicio().after(dataFim)) {
				emprestimos.add(emprestimo);
			}
		}

		return emprestimos;
	}

	public void verificaDatas(Date dataInicio, Date dataFim) throws IllegalArgumentException {
		if (dataInicio.after(dataFim)) {
			throw new IllegalArgumentException("A data de início é posterior à data de fim.");
		}
	}

	public List<Emprestimo> consultarEmprestimoPorLeitor(String usuario) {
		List<Emprestimo> todosEmprestimos = Arquivo.lerArquivo(Emprestimo.class);

		for (Emprestimo e : todosEmprestimos) {
			if (e.getLeitor().getUsuario().equals(usuario)) {
				emprestimos.add(e);
			}
		}
		return emprestimos;
	}

	public void devolucao() {

	}

	public void removerEmprestimo(int codigo, String usuario) throws NoSuchElementException {
		List<Emprestimo> emprestimos = Arquivo.lerArquivo(Emprestimo.class);
		Emprestimo emprestimoRemover = null;

		for (Emprestimo e : emprestimos) {
			if (e.getLivro().getCodigo() == codigo && e.getLeitor().getUsuario().equals(usuario)) {
				emprestimoRemover = e;
				break;
			}
		}

		if (emprestimoRemover != null) {
			emprestimos.remove(emprestimoRemover);
			Arquivo.escreverArquivo(emprestimos, Emprestimo.class);
			return;
		}
		throw new NoSuchElementException("Empréstimo não encontrado.");
	}

	// AUTENTICAÇÂO

	public int autenticacao(String usuario, String senha) {
		List<Leitor> leitores = consultarLeitores();
		usuarioAtual = usuario;

		if (usuario.equals("0") && senha.equals("0")) {
			usuarioAtual = "";
			return 1;
		}

		if (Administrador.getUsuario().equals(usuario) && Administrador.getSenha().equals(senha)) {
			return 1;
		}

		for (Leitor l : leitores) {
			if (l.getUsuario().equals(usuario) && l.getSenha().equals(senha)) {
				return 2;
			}
		}

		return 0;
	}

	public String getUsuarioAtual() {
		return usuarioAtual;
	}

}
