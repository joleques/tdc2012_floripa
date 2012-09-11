package testesInvencaoPura;


import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import codigoNovo.Candidato;
import codigoNovo.FaseDAO;
import codigoNovo.VestibularFase;
import codigoNovo.ValidadorCandidato;




public class ValidadorCandidatoTeste {
	
	Candidato candidato;
	VestibularFase fase;
	VestibularFase fasePolo;

	@Before
	public void setUp() throws Exception {
		fase = new VestibularFase("PRE");
		fase.setCodigoFase(1L);
		
		fasePolo = new VestibularFase("EAD");
		fasePolo.setCodigoFase(2L);
	}

	@After
	public void tearDown() throws Exception {
		candidato = null;
	}
	
	@Test
	public void validarCpfVazioComSucesso(){
		try {
			candidato = new Candidato();
			candidato.setNome("Teste Validador");
			ValidadorCandidato validadorCandidato = new ValidadorCandidato(candidato, fase);
			validadorCandidato.validar();
			Assert.fail("A validação falhou");
		} catch (Exception excessao) {
			Assert.assertEquals(excessao.getMessage(), "CPF esta vazio.");
		}
	}

	@Test
	public void validarCpfComNumeroInvalidoComSucesso(){
		try {
			candidato = new Candidato();
			candidato.setNome("Teste Validador");
			candidato.setCpf("123456789");
			ValidadorCandidato validadorCandidato = new ValidadorCandidato(candidato, fase);
			validadorCandidato.validar();
			Assert.fail("A validação falhou");
		} catch (Exception excessao) {
			Assert.assertEquals(excessao.getMessage(), "CPF deve ter 11 caracteres.");
		}
	}

	@Test
	public void validarCpfComInvalidoComSucesso(){
		try {
			candidato = new Candidato();
			candidato.setNome("Teste Validador");
			candidato.setCpf("11111111111");
			ValidadorCandidato validadorCandidato = new ValidadorCandidato(candidato, fase);
			validadorCandidato.validar();
			Assert.fail("A validação falhou");
		} catch (Exception excessao) {
			Assert.assertEquals(excessao.getMessage(), "CPF é invalido.");
		}
	}

	@Test
	public void validarNomeComMenosQue5CaracteresComSucesso(){
		try {
			candidato = new Candidato();
			candidato.setNome("Test");
			candidato.setCpf("12345678901");
			ValidadorCandidato validadorCandidato = new ValidadorCandidato(candidato, fase);
			validadorCandidato.validar();
			Assert.fail("A validação falhou");
		} catch (Exception excessao) {
			Assert.assertEquals(excessao.getMessage(), "O nome tem que ter no minimo 5 caracteres.");
		}
	}

	@Test
	public void validarComCandidatoJaInscrito(){
		try {
			candidato = new Candidato();
			candidato.setNome("Teste de validador");
			candidato.setCpf("12345678901");
			ValidadorCandidato validadorCandidato = new ValidadorCandidato(candidato, fase);
			validadorCandidato.validar();
			Assert.fail("A validação falhou");
		} catch (Exception excessao) {
			Assert.assertEquals(excessao.getMessage(), "O Candidato Teste de validador já esta inscrito nessa fase");
		}
	}

	@Test
	public void validarCandidatoOk(){
		try {
			candidato = new Candidato();
			candidato.setNome("Teste de validador");
			candidato.setCpf("12345678901");
			ValidadorCandidato validadorCandidato = new ValidadorCandidato(candidato, fasePolo);
			validadorCandidato.validar();
		} catch (Exception excessao) {
			Assert.fail("A validação falhou");
		}
	}

}
