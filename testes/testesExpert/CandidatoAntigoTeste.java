package testesExpert;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import codigoAntigo.Candidato;
import codigoAntigo.Prova;
import codigoAntigo.Sala;



public class CandidatoAntigoTeste {

	private static final Date DATA_INICAL = new Date(2012,8, 24,17,40);
	private static final Long CODIGO_INSCRICAO = 1L;
	private static final String CNPJ = "12345678909";
	private static final Date DATA_FINAL = new Date(2012,8, 24,18,30);
	
	private Candidato candidato;
	private Prova prova;
	
	@Before
	public void setUp() throws Exception {
		candidato = new Candidato();
		candidato.setCodigo(CODIGO_INSCRICAO);
		candidato.setCpf(CNPJ);
		candidato.setNome("Candidato teste para o TDC 2012");
		
		prova = new Prova();
		prova.setDataInical(DATA_INICAL);
		prova.setDataFinal(DATA_FINAL);
	}
	
	private Sala criarSala(Long codigo,Integer capacidade,Integer total){
		Sala sala = new Sala();
		sala.setCodigo(codigo);
		sala.setCapacidade(capacidade);
		sala.setTotalOcupada(total);
		return sala;
	}

	@After
	public void tearDown() throws Exception {
		candidato = null;
		prova = null;
	}
	
	@Test
	public void adicionarCandidatoNaSalaComSucesso(){
		//DADO QUE
		List<Sala> listaSalas = new ArrayList<Sala>();
		Sala primeiraSala = criarSala(1L, 50, 20);
		listaSalas.add(primeiraSala);
		Sala segundaSala = criarSala(2L, 50, 0);
		listaSalas.add(segundaSala);
		prova.setSalas(listaSalas);
		
		//QUANDO
		boolean retorno = candidato.addCandProva(prova);
		
		//ENTÃO
		Assert.assertTrue(retorno);
		Assert.assertEquals(primeiraSala.getTotalOcupada(), Integer.valueOf(21));
		Assert.assertEquals(segundaSala.getTotalOcupada(), Integer.valueOf(0));
	}
	
	@Test
	public void adicionarCandidatoSemVagaNasSalas(){
		//DADO QUE
		List<Sala> listaSalas = new ArrayList<Sala>();
		Sala primeiraSala = criarSala(1L, 50, 50);
		listaSalas.add(primeiraSala);
		Sala segundaSala = criarSala(2L, 50, 50);
		listaSalas.add(segundaSala);
		prova.setSalas(listaSalas);
		
		//QUANDO
		boolean retorno = candidato.addCandProva(prova);

		//ENTÃO
		Assert.assertFalse(retorno);
		Assert.assertEquals(primeiraSala.getTotalOcupada(), Integer.valueOf(50));
		Assert.assertEquals(segundaSala.getTotalOcupada(), Integer.valueOf(50));
	}
	
	@Test
	public void adicionarCandidatoEmProvaSemSala(){
		// DADO QUE
		prova.setSalas(null);
		
		//QUANDO
		boolean retorno = candidato.addCandProva(prova);

		//ENTÃO
		Assert.assertFalse(retorno);
	}
	
	@Test
	public void adicionarCandidatoComCapacidadeZerada(){
		//DADO QUE
		List<Sala> listaSalas = new ArrayList<Sala>();
		Sala primeiraSala = criarSala(1L, 0, 0);
		listaSalas.add(primeiraSala);
		Sala segundaSala = criarSala(2L, 0, 0);
		listaSalas.add(segundaSala);
		prova.setSalas(listaSalas);
		
		//QUANDO
		boolean retorno = candidato.addCandProva(prova);

		//ENTÃO
		Assert.assertFalse(retorno);
		Assert.assertEquals(primeiraSala.getTotalOcupada(), Integer.valueOf(0));
		Assert.assertEquals(segundaSala.getTotalOcupada(), Integer.valueOf(0));
	}

	@Test
	public void adicionarCandidatoComCapacidadeNula(){
		//DADO QUE
		List<Sala> listaSalas = new ArrayList<Sala>();
		Sala primeiraSala = criarSala(1L, null, 0);
		listaSalas.add(primeiraSala);
		Sala segundaSala = criarSala(2L, null, 0);
		listaSalas.add(segundaSala);
		prova.setSalas(listaSalas);
		
		//QUANDO
		boolean retorno = candidato.addCandProva(prova);

		//ENTÃO
		Assert.assertFalse(retorno);
		Assert.assertEquals(primeiraSala.getTotalOcupada(), Integer.valueOf(0));
		Assert.assertEquals(segundaSala.getTotalOcupada(), Integer.valueOf(0));
	}

}
