import java.util.UUID;

public class Usuario {
	
	private String id;
	private String nome;
	private String senha;
	
	public Usuario(String nome, String senha) {
		this.id = UUID.randomUUID().toString();
		this.nome  = nome;
		this.senha = senha;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogin() {
		return nome;
	}

	public void setLogin(String login) {
		this.nome = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
