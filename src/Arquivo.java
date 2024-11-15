import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Arquivo {

	public Arquivo() {

	}

	public static <T> List<T> lerArquivo(Class<T> clazz) {
		Gson gson = new Gson();
		List<T> objetos = null;
		String nomeArquivo = "";

		if (clazz == Leitor.class) {
			nomeArquivo = "leitor.json";
		} else if (clazz == Livro.class) {
			nomeArquivo = "livro.json";
		} else if (clazz == Categoria.class) {
			nomeArquivo = "categoria.json";
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
		String nomeArquivo = "";

		if (clazz == Leitor.class) {
			nomeArquivo = "leitor.json";
		} else if (clazz == Livro.class) {
			nomeArquivo = "livro.json";
		} else if (clazz == Categoria.class) {
			nomeArquivo = "categoria.json";
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
