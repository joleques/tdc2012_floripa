package codigoNovo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import codigoAntigo.Candidato;
import codigoAntigo.Prova;



public class PoloDAO {

	public List<Candidato> listarCandidatos(VestibularFase vestibularFase) {
		List<Candidato> listaCandidatos = new ArrayList<Candidato>();		

		Candidato primeiroCandidato = new Candidato();
		primeiroCandidato.setCodigo(1L);
		primeiroCandidato.setCpf("98765432112");
		primeiroCandidato.setNome("Primeiro Candidato");
		listaCandidatos.add(primeiroCandidato);
		
		Candidato segundoCandidato = new Candidato();
		segundoCandidato.setCodigo(2L);
		segundoCandidato.setCpf("12345678998");
		segundoCandidato.setNome("Segundo Candidato");
		listaCandidatos.add(segundoCandidato);
		
		return listaCandidatos;
	}

	public List<Polo> listarPolos(VestibularFase vestibularFase) {
		List<Polo> listaPolos = new ArrayList<Polo>();
		

		Polo poloCacapava = new Polo();
		poloCacapava.setCodigo(1L);
		poloCacapava.setNome("Polo de Caçapava do Sul");
		
		Prova provaCacapava = new Prova();
		provaCacapava.setDataFinal(new Date(2012,8,24));
		provaCacapava.setDataInical(new Date(2012,8,24));
		poloCacapava.setProva(provaCacapava);		
		listaPolos.add(poloCacapava);
		
		Polo poloPortoAlegre = new Polo();
		poloPortoAlegre.setCodigo(2L);
		poloPortoAlegre.setNome("Polo de Porto Alegre");
		
		Prova provaPortoAlegre = new Prova();
		provaPortoAlegre.setDataFinal(new Date(2012,8,28));
		provaPortoAlegre.setDataInical(new Date(2012,8,28));
		poloPortoAlegre.setProva(provaPortoAlegre);
		
		listaPolos.add(poloPortoAlegre);
		
		return listaPolos;
	}

}
