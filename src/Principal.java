import java.util.Scanner;

public class Principal {

	private static Scanner sc;
	private Categoria categoria;
	private Livro livro;
	private Usuario usuario;

	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.autenticacao();
		principal.menu();
	}

	public void autenticacao() {

	}

	public void menu() {

		int op;
		sc = new Scanner(System.in);

		do {
			System.out.println("* * * * * * * * * * * * * * * * * * * *");
			System.out.println("* 1. Cadastrar Categoria");
			System.out.println("* 2. Cadastrar Livro");
			System.out.println("* 3. Cadastrar Usuário");
			System.out.println("* 4. Finalizar Execução do Programa");
			System.out.println("* * * * * * * * * * * * * * * * * * * *");
			System.out.print("Selecione uma das operações: ");
			op = sc.nextInt();
			sc.nextLine();
			switch (op) {
			case 1:
				cadastrarCategoria();
				break;
			case 2:
				cadastrarLivro();
				break;
			case 3:
				cadastrarUsuario();
				break;
			case 4:
				System.out.println("Programa Finalizado...");
				System.exit(0);
			}

		} while (op != 4);
		sc.close();
	}
	
	public void cadastrarCategoria() {
		
	}
	
	public void cadastrarLivro() {
		
	}
	
	public void cadastrarUsuario() {
		
	}
}
