import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class Biblioteca {
	private List<Livro> livros = new ArrayList<Livro>();
	private Map<Integer, String> categorias = new HashMap<Integer, String>();
	private List<Leitor> leitores = new ArrayList<Leitor>();

	public Biblioteca() {

	}

	// LIVRO

	public void adicionarLivro(Livro livro) throws IllegalArgumentException {
		for (Livro l : this.livros) {
			if (l.getCodigo() == livro.getCodigo()) {
				throw new IllegalArgumentException("Livro com o código " + livro.getCodigo() + " já existe.");
			}
		}

		this.livros.add(livro);
	}

	public void removerLivro(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= this.livros.size()) {
			throw new IndexOutOfBoundsException("Índice inválido: " + index);
		}

		this.livros.remove(index);
	}

	public void editarLivro(int index, Livro livro) {
		this.livros.set(index, livro);
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
		for (Livro livro : livros) {
			if (livro.getTitulo().equals(titulo)) {
				return livro;
			}
		}

		throw new NoSuchElementException("Livro " + titulo + " não encontrado.");
	}

	public List<Livro> consultarLivros() {
		return this.livros;
	}

	// CATEGORIA

	public void adicionarCategoria(int codigo, String descricao) throws IllegalArgumentException {
		if (this.categorias.containsKey(codigo)) {
			throw new IllegalArgumentException("Categoria com código " + codigo + " já existe.");
		}
		this.categorias.put(codigo, descricao);
	}

	public void removerCategoria(int codigo) throws NoSuchElementException {
		if (categorias.remove(codigo) == null) {
			throw new NoSuchElementException("Categoria com código " + codigo + " não encontrada.");
		}
	}

	public void editarCategoria(int codigo, String descricao) {
		this.categorias.put(codigo, descricao);
	}

	public Map.Entry<Integer, String> consultarCategoriaCodigo(int codigo) throws NoSuchElementException {
		if (categorias.containsKey(codigo)) {
			return Map.entry(codigo, categorias.get(codigo));
		}
		throw new NoSuchElementException("Categoria com código " + codigo + " não encontrada.");
	}

	public Map.Entry<Integer, String> consultarCategoriaDescricao(String descricao) throws NoSuchElementException {
		for (Map.Entry<Integer, String> entry : categorias.entrySet()) {
			if (entry.getValue().equals(descricao)) {
				return entry;
			}
		}
		throw new NoSuchElementException("Categoria com descrição '" + descricao + "' não encontrada.");
	}

	public Set<Map.Entry<Integer, String>> consultarCategorias() {
		return categorias.entrySet();
	}

	// LEITOR

	public void adicionarLeitor(Leitor leitor) throws IllegalArgumentException {
		for (Leitor l : leitores) {
			if (l.getUsuario().equals(leitor.getUsuario())) {
				throw new IllegalArgumentException("Leitor com o usuário " + leitor.getUsuario() + " já existe.");
			}
		}
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

	public void editarLeitor(int index, Leitor leitor) throws NoSuchElementException {

		if (index < 0 || index >= this.leitores.size()) {
			throw new IndexOutOfBoundsException("Índice inválido: " + index);
		}

		leitores.set(index, leitor);
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
