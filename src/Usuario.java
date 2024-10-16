public class Usuario {

	private int codigo;

	private String nome;
	private String senha;
	private final String ADMIN_NOME = "admin";
	private final String ADMIN_SENHA = "0000";
	private Usuario[] usuarios = new Usuario[10];

	public Usuario() {

	}

	public Usuario(String nome, String senha) {
		this.codigo = obterNovoCodigo();
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
				System.out.println("ID: " + usuario.getCodigo());
				System.out.println("NOME: " + usuario.getNome());
				System.out.println("SENHA: " + usuario.getSenha());
				System.out.println("* * * * * * * * * * * * * * * * * * * *");
			}
		}
	}

	private int obterNovoCodigo() {
		Usuario ultimoUsuario = null;

		for (int i = usuarios.length - 1; i >= 0; i--) {
			if (usuarios[i] != null) {
				ultimoUsuario = usuarios[i];
				break;
			}
		}

		if (ultimoUsuario == null) {
			return 1;
		}

		return ultimoUsuario.getCodigo() + 1;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
