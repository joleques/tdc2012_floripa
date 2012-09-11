package codigoAntigo;

import java.util.List;


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


	/**
	 * Adiciona o Candidato na sala da Prova passada por parametro
	 * 
	 */
	public boolean addCandProva(Prova prova){
		List<Sala> listaSalas = prova.getSalas();
		boolean retorno = false;
		if(listaSalas != null){
			for (Sala sala : listaSalas) {
				//adiciona o candidato se possuir vaga
				if(sala.getCapacidade() != null && sala.getCapacidade() > 0 && (sala.getCapacidade() > sala.getTotalOcupada())){
					SalaDAO dao = new SalaDAO();
					dao.add(sala,this);
					sala.addCandidato(this);
					sala.setTotalOcupada(sala.getTotalOcupada()+1);
					retorno = true;
					break;
				}
			}
		}		
		return retorno;
	}
	
	/**
	 * Validação das Regras de Negocio da Fase
	 * @throws Exception 
	 */
	public void validar(VestibularFase fase) throws Exception{
		//validar cpf
		if(cpf == null || cpf.equals("")){
			throw new Exception("CPF esta vazio.");
		}

		if(cpf.length() != 11){
			throw new Exception("CPF deve ter 11 caracteres.");
		}

		if(!ValidadrCPF.validador(cpf)){
			throw new Exception("CPF é invalido.");
		}
		
		//validar nome com no minimo 5 caracteres
		if(nome.length() < 5 ){
			throw new Exception("O nome tem que ter no minimo 5 caracteres.");
		}
		
		//Candidato tem que estar pelo menos inscrito em uma prova
		ProvaDAO provaDAO = new ProvaDAO();
		Candidato candidato = provaDAO.buscarCandidato(fase,this);
		if(candidato == null){
			throw new Exception("O Candidato "+nome+" já esta inscrito nessa fase");
		}
		
	}

}
