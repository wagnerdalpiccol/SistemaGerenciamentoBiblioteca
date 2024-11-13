import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Biblioteca {
	private List<Livro> livros = new ArrayList<Livro>();
	private List<Categoria> categorias = new ArrayList<Categoria>();
	private List<Leitor> leitores = new ArrayList<Leitor>();

	public Biblioteca() {

	}

	// LIVRO

	public void adicionarLivro(Livro livro) {
		this.livros.add(livro);
	}

	public void removerLivro(int codigo) throws IndexOutOfBoundsException {
		for (int i = 0; i < this.livros.size(); i++) {
			if (this.livros.get(i).getCodigo() == codigo) {
				this.livros.remove(i);
				return;
			}
		}
		throw new NoSuchElementException("Livro com código " + codigo + " não encontrada.");
	}

	public void editarLivro(Livro livro) {
		for (int i = 0; i < this.livros.size(); i++) {
			if (this.livros.get(i).getCodigo() == livro.getCodigo()) {
				this.livros.set(i, livro);
				return;
			}
		}
		throw new NoSuchElementException("Categoria com código " + livro.getCodigo() + " não encontrada.");
	}

	public Livro consultarLivroCodigo(int codigo) throws NoSuchElementException {
		for (Livro livro : livros) {
			if (livro.getCodigo() == codigo) {
				return livro;
			}
		}

		throw new NoSuchElementException("Livro com código " + codigo + " não encontrado.");
	}

	public Livro consultarLivroTitulo(String titulo) throws NoSuchElementException {
		for (Livro l : livros) {
			if (l.getTitulo().equals(titulo)) {
				return l;
			}
		}

		throw new NoSuchElementException("Livro " + titulo + " não encontrado.");
	}

	public List<Livro> consultarLivros() {
		return this.livros;
	}

	public boolean livroExiste(int codigo) {
		for (Livro l : livros) {
			if (l.getCodigo() == codigo) {
				return true;
			}
		}
		return false;
	}

	// CATEGORIA

	public void adicionarCategoria(Categoria categoria) {
		this.categorias.add(categoria);
	}

	public void removerCategoria(int codigo) throws NoSuchElementException {
		for (int i = 0; i < this.categorias.size(); i++) {
			if (this.categorias.get(i).getCodigo() == codigo) {
				this.categorias.remove(i);
				return;
			}
		}
		throw new NoSuchElementException("Categoria com código " + codigo + " não encontrada.");
	}

	public void editarCategoria(Categoria categoria) throws NoSuchElementException {
		for (int i = 0; i < this.categorias.size(); i++) {
			if (this.categorias.get(i).getCodigo() == categoria.getCodigo()) {
				this.categorias.set(i, categoria);
				return;
			}
		}
		throw new NoSuchElementException("Categoria com código " + categoria.getCodigo() + " não encontrada.");
	}

	public Categoria consultarCategoriaCodigo(int codigo) throws NoSuchElementException {
		for (Categoria c : categorias) {
			if (c.getCodigo() == codigo) {
				return c;
			}
		}
		throw new NoSuchElementException("Categoria com código " + codigo + " não encontrada.");
	}

	public Categoria consultarCategoriaDescricao(String descricao) throws NoSuchElementException {
		for (Categoria c : categorias) {
			if (c.getDescricao().equals(descricao)) {
				return c;
			}
		}
		throw new NoSuchElementException("Categoria com descrição '" + descricao + "' não encontrada.");
	}

	public List<Categoria> consultarCategorias() {
		return this.categorias;
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
		leitores.add(leitor);
	}

	public void removerLeitor(String usuario) throws NoSuchElementException {
		Leitor leitorRemover = null;
		for (Leitor l : leitores) {
			if (l.getUsuario().equals(usuario)) {
				leitorRemover = l;
				break;
			}
		}
		if (leitorRemover != null) {
			leitores.remove(leitorRemover);
		} else {
			throw new NoSuchElementException("Leitor com usuário " + usuario + " não encontrado.");
		}
	}

	public void editarLeitor(Leitor leitor) throws NoSuchElementException {
		for (int i = 0; i < this.leitores.size(); i++) {
			if (this.leitores.get(i).getUsuario().equals(leitor.getUsuario())) {
				this.leitores.set(i, leitor);
				return;
			}
		}
		throw new NoSuchElementException("Leitor com usuário " + leitor.getUsuario() + " não encontrado.");
	}

	public Leitor consultarLeitorUsuario(String usuario) throws NoSuchElementException {
		for (Leitor l : leitores) {
			if (l.getUsuario().equals(usuario)) {
				return l;
			}
		}
		throw new NoSuchElementException("Leitor com usuário " + usuario + " não encontrado.");
	}

	public List<Leitor> consultarLeitores() {
		return leitores;
	}

	public boolean leitorExiste(String usuario) {
		for (Leitor l : leitores) {
			if (l.getUsuario().equals(usuario)) {
				return true;
			}
		}
		return false;
	}

	// AUTENTICAÇÂO

	public boolean autenticacao(String usuario, String senha) {
		if (Administrador.getUsuario().equals(usuario) && Administrador.getSenha().equals(senha)) {
			return true;
		}

		for (Leitor l : leitores) {
			if (l.getUsuario().equals(usuario) && l.getSenha().equals(senha)) {
				return true;
			}
		}

		return false;
	}

}
