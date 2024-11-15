import com.google.gson.annotations.SerializedName;

public class Leitor {
	@SerializedName("usuario")
	private String usuario;
	@SerializedName("senha")
	private String senha;

	public Leitor() {

	}

	public Leitor(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
