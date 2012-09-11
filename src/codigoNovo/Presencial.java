package codigoNovo;

import java.util.List;

import codigoAntigo.Candidato;
import codigoAntigo.Prova;



public class Presencial extends TipoFase{

	@Override
	public List<Candidato> carregarCandidatos(VestibularFase fase) {
		FaseDAO faseDAO = new FaseDAO();
		return faseDAO.listarCandidatos(fase);		
	}

	@Override
	public List<Prova> listarProvasDaFase(VestibularFase fase) {
		FaseDAO faseDAO = new FaseDAO();
		return faseDAO.listarProvas(fase);
	}

}
