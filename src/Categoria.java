import java.util.UUID;

public class Categoria {
	
	private String id;
	private String nome;
	
	public Categoria(String nome) {
		this.id = UUID.randomUUID().toString();
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
