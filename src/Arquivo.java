import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Arquivo {
	
	public static final String arquivoLeitor = "leitor.json";
	public static final String arquivoLivro = "livro.json";
	public static final String arquivoCategoria = "categoria.json";
	public static final String arquivoEmprestimo = "emprestimo.json";
	public static String nomeArquivo;
	
	public Arquivo() {

	}

	public static <T> List<T> lerArquivo(Class<T> clazz) {
		Gson gson = new Gson();
		List<T> objetos = null;

		if (clazz == Leitor.class) {
			nomeArquivo = arquivoLeitor;
		} else if (clazz == Livro.class) {
			nomeArquivo = arquivoLivro;
		} else if (clazz == Categoria.class) {
			nomeArquivo = arquivoCategoria;
		} else if (clazz == Emprestimo.class) {
			nomeArquivo = arquivoEmprestimo;
		} else {
			throw new IllegalArgumentException("Tipo de classe não suportado: " + clazz.getName());
		}

		try (FileReader reader = new FileReader(nomeArquivo)) {
			Type listType = TypeToken.getParameterized(List.class, clazz).getType();
			objetos = gson.fromJson(reader, listType);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return (objetos != null) ? objetos : new ArrayList<>();
	}

	public static <T> void escreverArquivo(List<T> lista, Class<T> clazz) {
		Gson gson = new Gson();

		if (clazz == Leitor.class) {
			nomeArquivo = arquivoLeitor;
		} else if (clazz == Livro.class) {
			nomeArquivo = arquivoLivro;
		} else if (clazz == Categoria.class) {
			nomeArquivo = arquivoCategoria;
		} else if (clazz == Emprestimo.class) {
			nomeArquivo = arquivoEmprestimo;
		} else {
			throw new IllegalArgumentException("Tipo de classe não suportado: " + clazz.getName());
		}

		try (FileWriter writer = new FileWriter(nomeArquivo)) {
			gson.toJson(lista, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
