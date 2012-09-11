package codigoNovo;

import codigoNovo.Candidato;
import codigoNovo.ProvaDAO;
import codigoAntigo.ValidadrCPF;

public class ValidadorCandidato implements IValidador{

	private Candidato candidato;
	private VestibularFase fase;
	
	
	
	public ValidadorCandidato(Candidato candidato, VestibularFase fase) {
		this.candidato = candidato;
		this.fase = fase;
	}



	@Override
	public void validar() throws Exception {
		validarCpf();
		validarNome();
		verificarSeCandidatoJaInscrito();
	}
	private void verificarSeCandidatoJaInscrito() throws Exception {
		ProvaDAO provaDAO = new ProvaDAO();
		Candidato candidatoRetorno = provaDAO.buscarCandidato(this.fase,this.candidato);
		if(candidatoRetorno == null){
			throw new Exception("O Candidato "+candidato.getNome()+" já esta inscrito nessa fase");
		}
	}
	private void validarNome() throws Exception {
		if(candidato.getNome().length() < 5 ){
			throw new Exception("O nome tem que ter no minimo 5 caracteres.");
		}
	}
	private void validarCpf() throws Exception {
		if(candidato.getCpf() == null || candidato.getCpf().equals("")){
			throw new Exception("CPF esta vazio.");
		}

		if(candidato.getCpf().length() != 11){
			throw new Exception("CPF deve ter 11 caracteres.");
		}

		if(!ValidadrCPF.validador(candidato.getCpf())){
			throw new Exception("CPF é invalido.");
		}
	}

}
