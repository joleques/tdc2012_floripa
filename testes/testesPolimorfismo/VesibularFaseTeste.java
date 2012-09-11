package testesPolimorfismo;


import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import codigoAntigo.Candidato;
import codigoAntigo.Prova;
import codigoAntigo.VestibularFase;




public class VesibularFaseTeste {
	
	private static final String FASE_INVALIDA = "INVALIDO";
	private static final String FASE_EAD = "EAD";
	private static final String FASE_PRESENCIAL = "PRE";
	VestibularFase fase;

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		fase = null;
	}
	
	@Test
	public void listarCandidatosDaFasePresencial(){
		// Dado que eu saiba o tipo de fase, 
		fase = new VestibularFase(FASE_PRESENCIAL);
		
		// Quando eu carregar os condidatos,
		fase.carregarCandidatos();
		
		// Então eu posso gerar um relatório com os candidatos inscritos
		List<Candidato> listaCandidatos = fase.getListaCandidatos();		
		assertsDadosCandidato(listaCandidatos.get(0),new Long(3),"1111111111");
		assertsDadosCandidato(listaCandidatos.get(1),new Long(4),"2222222222");
	}

	@Test
	public void listarCandidatosDaFaseEAD(){
		// Dado que eu saiba o tipo de fase, 
		fase = new VestibularFase(FASE_EAD);
		
		// Quando eu carregar os condidatos,
		fase.carregarCandidatos();
		
		// Então eu posso gerar um relatório com os candidatos inscritos
		List<Candidato> listaCandidatos = fase.getListaCandidatos();		
		assertsDadosCandidato(listaCandidatos.get(0),new Long(1),"98765432112");
		assertsDadosCandidato(listaCandidatos.get(1),new Long(2),"12345678998");
	}

	@Test
	public void listarCandidatosDaFaseInvalida(){
		// Dado que eu saiba o tipo de fase, 
		fase = new VestibularFase(FASE_INVALIDA);
		
		// Quando eu carregar os condidatos,
		fase.carregarCandidatos();
		
		// Então eu posso gerar um relatório com os candidatos inscritos
		Assert.assertNull(fase.getListaCandidatos());
	}
	
	@Test
	public void listarProvasDaFasePresencial(){
		// Dado que eu saiba o tipo de fase, 
		fase = new VestibularFase(FASE_PRESENCIAL);
		
		// Quando eu listar as Provas
		List<Prova> listaDeProvas = fase.listarProvasDaFase();
		
		// Então o sistema pode apresentar as provas para o candidato escolher
		assertsDeProva(listaDeProvas.get(0),new Date(2012,8,25));
		assertsDeProva(listaDeProvas.get(1),new Date(2012,8,26));
		
	}

	@Test
	public void listarProvasDaFaseEAD(){
		// Dado que eu saiba o tipo de fase, 
		fase = new VestibularFase(FASE_EAD);
		
		// Quando eu listar as Provas
		List<Prova> listaDeProvas = fase.listarProvasDaFase();
		
		// Então o sistema pode apresentar as provas para o candidato escolher
		assertsDeProva(listaDeProvas.get(0),new Date(2012,8,24));
		assertsDeProva(listaDeProvas.get(1),new Date(2012,8,28));
		
	}

	@Test
	public void listarProvasDaFaseInvalida(){
		// Dado que eu saiba o tipo de fase, 
		fase = new VestibularFase(FASE_INVALIDA);
		
		// Quando eu listar as Provas
		List<Prova> listaDeProvas = fase.listarProvasDaFase();
		
		// Então o sistema pode apresentar as provas para o candidato escolher
		Assert.assertTrue(listaDeProvas.size() == 0);
		
	}

	private void assertsDeProva(Prova primairaProva, Date dataProva) {
		Assert.assertEquals(primairaProva.getDataInical(), dataProva);
		Assert.assertEquals(primairaProva.getDataFinal(), dataProva);
	}

	private void assertsDadosCandidato(Candidato primeiroCandidato,Long codigo, String cnpj) {
		Assert.assertEquals(primeiroCandidato.getCodigo(), codigo);
		Assert.assertEquals(primeiroCandidato.getCpf(), cnpj);
	}

}
