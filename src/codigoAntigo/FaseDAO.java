package codigoAntigo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class FaseDAO {

	public List<Candidato> listarCandidatos(VestibularFase vestibularFase) {
		List<Candidato> listaCandidatos = new ArrayList<Candidato>();		

		Candidato terceiroCandidato = new Candidato();
		terceiroCandidato.setCodigo(3L);
		terceiroCandidato.setCpf("1111111111");
		terceiroCandidato.setNome("Terceiro Candidato");
		listaCandidatos.add(terceiroCandidato);
		
		Candidato quartoCandidato = new Candidato();
		quartoCandidato.setCodigo(4L);
		quartoCandidato.setCpf("2222222222");
		quartoCandidato.setNome("Quarto Candidato");
		listaCandidatos.add(quartoCandidato);
		
		return listaCandidatos;
	}

	public List<Prova> listarProvas(VestibularFase vestibularFase) {
		List<Prova> listaProvas = new ArrayList<Prova>();
		
		Prova primeiraProva = new Prova();
		primeiraProva.setDataFinal(new Date(2012,8,25));
		primeiraProva.setDataInical(new Date(2012,8,25));
		
		listaProvas.add(primeiraProva);

		Prova segundaProva = new Prova();
		segundaProva.setDataFinal(new Date(2012,8,26));
		segundaProva.setDataInical(new Date(2012,8,26));
		
		listaProvas.add(segundaProva);
		
		return listaProvas;
	}

}
