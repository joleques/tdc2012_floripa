package codigoNovo;


public class Candidato {
	
	private Long codigo;
	private String cpf;
	private String nome;
	
	
	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean AdicionarCandidatoNaSalaDaProva(Prova prova){
		if(prova.possuiSala()){
			for (Sala sala : prova.getSalas()) {
				if(sala.temVagasDisponiveis()){
					return sala.adicionarCandidato(this);
				}
			}
		}		
		return false;
	}

}
