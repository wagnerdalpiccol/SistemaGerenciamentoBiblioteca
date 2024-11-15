import com.google.gson.annotations.SerializedName;

public class Categoria {
	@SerializedName("codigo")
	private int codigo;
	@SerializedName("descricao")
	private String descricao;

	public Categoria() {

	}

	public Categoria(int codigo, String descricao) {

		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
