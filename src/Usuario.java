public class Usuario {

	private String nome;
	private String senha;
	private String email;
	private final String ADMIN_NOME = "admin";
	private final String ADMIN_SENHA = "0000";
	private Usuario[] usuarios = new Usuario[10];

	public Usuario() {

	}

	public Usuario(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}
	
	public Usuario(String nome, String senha, String email) {
		this.nome = nome;
		this.senha = senha;
		this.email = email;
	}

	public void cadastrar(String nome, String senha, String email) {
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

		usuarios[index] = new Usuario(nome, senha, email);
	}

	public void consultar() {
		for (Usuario usuario : usuarios) {
			if (usuario != null) {
				System.out.println("* * * * * * * * * * * * * * * * * * * *");
				System.out.println("NOME: " + usuario.getNome());
				System.out.println("SENHA: " + usuario.getSenha());
				System.out.println("EMAIL: " + usuario.getEmail());
				System.out.println("* * * * * * * * * * * * * * * * * * * *");
			}
		}
	}
	
	public void consultar_esp(String nome) {
	    boolean encontrado = false;
	    
	    for (Usuario usuario : usuarios) {
	        if (usuario != null && usuario.getNome().equalsIgnoreCase(nome)) {
	        	System.out.println("* * * * * * * * * * * * * * * * * * * *");
				System.out.println("NOME: " + usuario.getNome());
				System.out.println("SENHA: " + usuario.getSenha());
				System.out.println("EMAIL: " + usuario.getEmail());
				System.out.println("* * * * * * * * * * * * * * * * * * * *");
	            encontrado = true;
	            break;
	        }
	    }
	    
	    if (!encontrado) {
	        System.out.println("Usuário com o nome " + nome + " não foi encontrado.");
	    }
	}

	public void alterar(String nome, String senha, String email) {
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null && usuarios[i].getNome().equalsIgnoreCase(nome)) {
				usuarios[i] = new Usuario(nome, senha, email);
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
