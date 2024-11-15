import java.util.Date;

public class Emprestimo {
	private Leitor leitor;
	private Livro livro;
	private Date dataInicio;
	private Date dataFim;

	public Emprestimo(Leitor leitor, Livro livro, Date dataInicio, Date dataFim) {
		this.leitor = leitor;
		this.livro = livro;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public Leitor getLeitor() {
		return leitor;
	}

	public void setLeitor(Leitor leitor) {
		this.leitor = leitor;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

}
