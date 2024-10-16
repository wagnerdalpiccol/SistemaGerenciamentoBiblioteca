public class Usuario {

	private String nome;
	private String senha;
	private final String ADMIN_NOME = "admin";
	private final String ADMIN_SENHA = "0000";
	private Usuario[] usuarios = new Usuario[10];

	public Usuario() {

	}

	public Usuario(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}

	public void cadastrar(String nome, String senha) {
		int index = -1;

		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] == null) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			System.out.println("Não há espaço para cadastrar mais usuários.");
			return;
		}

		usuarios[index] = new Usuario(nome, senha);
	}

	public void consultar() {
		for (Usuario usuario : usuarios) {
			if (usuario != null) {
				System.out.println("* * * * * * * * * * * * * * * * * * * *");
				System.out.println("NOME: " + usuario.getNome());
				System.out.println("SENHA: " + usuario.getSenha());
				System.out.println("* * * * * * * * * * * * * * * * * * * *");
			}
		}
	}

	public void alterar(String nome, String senha) {
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null && usuarios[i].getNome().equalsIgnoreCase(nome)) {
				usuarios[i] = new Usuario(nome, senha);
				break;
			}
		}
	}

	public void remover(String nome) {
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null && usuarios[i].getNome().equalsIgnoreCase(nome)) {
				usuarios[i] = null;
				break;
			}
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String login) {
		this.nome = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getAdminNome() {
		return ADMIN_NOME;
	}

	public String getAdminSenha() {
		return ADMIN_SENHA;
	}

	public Usuario[] getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario[] usuarios) {
		this.usuarios = usuarios;
	}
}
