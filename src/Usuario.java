import java.util.Scanner;
import java.util.UUID;

public class Usuario {

	private static Scanner sc;
	private String id;
	private String nome;
	private String senha;
	private Usuario[] usuarios = new Usuario[10];

	public Usuario() {

	}

	public Usuario(String nome, String senha) {
		this.id = UUID.randomUUID().toString();
		this.nome = nome;
		this.senha = senha;
	}

	public void cadastrar() {
		int index = -1;
		
		sc = new Scanner(System.in);
		
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

		System.out.print("Digite o nome do usuário: ");
		String nome = sc.nextLine();

		System.out.print("Digite a senha do usuário: ");
		String senha = sc.nextLine();

		usuarios[index] = new Usuario(nome, senha);
	}

	public void consultar() {
		for (Usuario usuario : usuarios) {
			if (usuario != null) {
				System.out.println("* * * * * * * * * * * * * * * * * * * *");
				System.out.println("ID: " + usuario.getId());
				System.out.println("NOME: " + usuario.getNome());
				System.out.println("SENHA: " + usuario.getSenha());
				System.out.println("* * * * * * * * * * * * * * * * * * * *");
			}
		}
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

	public void setNome(String login) {
		this.nome = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
