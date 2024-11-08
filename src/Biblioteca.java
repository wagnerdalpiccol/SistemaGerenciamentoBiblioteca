import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Biblioteca {
	private List<Livro> livros = new ArrayList<Livro>();
	private Map<Integer, Categoria> categorias = new HashMap<Integer, Categoria>();
	
	public Biblioteca() {
		
	}

	// LIVROS

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

	public void editarLivro(int index, Livro livro) throws IndexOutOfBoundsException {
		if (index < 0 || index >= this.livros.size()) {
			throw new IndexOutOfBoundsException("Índice inválido: " + index);
		}

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

	public List<Livro> consultarLivros() throws NoSuchElementException {
		if (this.livros.isEmpty()) {
			throw new NoSuchElementException("Nenhum livro encontrado.");
		}
		return this.livros;
	}

	// CATEGORIAS

	public void adicionarCategoria(Categoria categoria) throws IllegalArgumentException {
		if (!this.categorias.containsKey(categoria.getCodigo())) {
			this.categorias.put(categoria.getCodigo(), categoria);
		}

		throw new IllegalArgumentException("Categoria com código " + categoria.getCodigo() + " já existe.");
	}

	public void removerCategoria(int codigo) throws NoSuchElementException {
		if (categorias.remove(codigo) == null) {
			throw new NoSuchElementException("Categoria com código " + codigo + " não encontrada.");
		}
	}

	public void editarCategoria(int codigo, Categoria categoria) throws NoSuchElementException {
		if (categorias.containsKey(codigo)) {
			this.categorias.put(codigo, categoria);
		}

		throw new NoSuchElementException("Categoria com código " + codigo + " não encontrada.");
	}

	public Categoria consultarCategoriaCodigo(int codigo) throws NoSuchElementException {
		Categoria categoria = categorias.get(codigo);
		if (categoria != null) {
			return categoria;
		}

		throw new NoSuchElementException("Categoria com código " + codigo + " não encontrada.");
	}

	public Categoria consultarCategoriaDescricao(String descricao) throws NoSuchElementException {
		for (Categoria categoria : categorias.values()) {
			if (categoria.getDescricao().equals(descricao)) {
				return categoria;
			}
		}

		throw new NoSuchElementException("Categoria com descrição '" + descricao + "' não encontrada.");
	}

	public List<Categoria> consultarCategorias() throws NoSuchElementException {
		List<Categoria> listaCategorias = new ArrayList<>(categorias.values());

		if (listaCategorias.isEmpty()) {
			throw new NoSuchElementException("Nenhuma categoria encontrada.");
		}

		return listaCategorias;
	}

}
