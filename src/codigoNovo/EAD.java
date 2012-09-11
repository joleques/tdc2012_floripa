package codigoNovo;

import java.util.ArrayList;
import java.util.List;

import codigoAntigo.Candidato;
import codigoAntigo.Prova;



public class EAD extends TipoFase{

	@Override
	public List<Candidato> carregarCandidatos(VestibularFase fase) {
		PoloDAO poloDAO = new PoloDAO();
		return poloDAO.listarCandidatos(fase);
	}

	@Override
	public List<Prova> listarProvasDaFase(VestibularFase fase) {
		List<Prova> retorno = new ArrayList<Prova>();
		PoloDAO poloDAO = new PoloDAO();
		List<Polo> listaDePolos = poloDAO.listarPolos(fase);
		for (Polo polo : listaDePolos) {
			retorno.add(polo.getProva());
		}
		return retorno;
	}

}
