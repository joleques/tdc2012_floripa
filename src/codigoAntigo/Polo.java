package codigoAntigo;


public class Polo {
	
	private Long codigo;
	private String nome;
	private Prova prova;
	
	

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public Prova getProva() {
		return prova;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
