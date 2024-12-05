import java.util.ArrayList;
import java.util.List;

public class Principal {
	public static void main(String[] args) {
		List<String> nomes = new ArrayList<>();
		nomes.add("Alice");
		nomes.add("Bob");
		nomes.add("Charlie");
		
		for(String nome : nomes) {
			if(nome.equals("Aliced")){
				nomes.remove(nome);
			}
		}
		
		for(String nome : nomes) {
			System.out.println(nome.toUpperCase());
		}
		System.out.println("nome no ind 3 " + nomes.get(2));
		
		nomes.add(null);
		
		if(nomes.contains("David")) {
			System.out.println("david esta na list");
		} else if(nomes.contains(null)) {
			System.out.println("a lista contain vaolr null");
		}
		
	}
}
