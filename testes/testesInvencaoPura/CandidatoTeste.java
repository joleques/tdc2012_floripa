package testesInvencaoPura;


import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import codigoAntigo.Candidato;
import codigoAntigo.FaseDAO;
import codigoAntigo.VestibularFase;




public class CandidatoTeste {
	
	Candidato candidato;
	VestibularFase fase;
	VestibularFase fasePolo;

	@Before
	public void setUp() throws Exception {
		fase = new VestibularFase("PRE");
		fase.setCodigoFase(1L);
		
		fasePolo = new VestibularFase("EAD");
		fasePolo.setCodigoFase(2L);

		candidato = new Candidato();
	}

	@After
	public void tearDown() throws Exception {
		candidato = null;
	}	
	@Test
	public void validarCpfVazioComSucesso(){
		try {
			candidato.setNome("Teste Validador");
			candidato.validar(fase);
			Assert.fail("A validação falhou");
		} catch (Exception excessao) {
			Assert.assertEquals(excessao.getMessage(), "CPF esta vazio.");
		}
	}
	@Test
	public void validarCpfComNumeroInvalidoComSucesso(){
		try {
			candidato.setNome("Teste Validador");
			candidato.setCpf("123456789");
			candidato.validar(fase);
			Assert.fail("A validação falhou");
		} catch (Exception excessao) {
			Assert.assertEquals(excessao.getMessage(), "CPF deve ter 11 caracteres.");
		}
	}
	@Test
	public void validarCpfComInvalidoComSucesso(){
		try {
			candidato.setNome("Teste Validador");
			candidato.setCpf("11111111111");
			candidato.validar(fase);
			Assert.fail("A validação falhou");
		} catch (Exception excessao) {
			Assert.assertEquals(excessao.getMessage(), "CPF é invalido.");
		}
	}

	@Test
	public void validarNomeComMenosQue5CaracteresComSucesso(){
		try {
			candidato.setNome("Test");
			candidato.setCpf("12345678901");
			candidato.validar(fase);
			Assert.fail("A validação falhou");
		} catch (Exception excessao) {
			Assert.assertEquals(excessao.getMessage(), "O nome tem que ter no minimo 5 caracteres.");
		}
	}

	@Test
	public void validarComCandidatoJaInscrito(){
		try {
			candidato.setNome("Teste de validador");
			candidato.setCpf("12345678901");
			candidato.validar(fase);
			Assert.fail("A validação falhou");
		} catch (Exception excessao) {
			Assert.assertEquals(excessao.getMessage(), "O Candidato Teste de validador já esta inscrito nessa fase");
		}
	}

	@Test
	public void validarCandidatoOk(){
		try {
			candidato.setNome("Teste de validador");
			candidato.setCpf("12345678901");
			candidato.validar(fasePolo);
		} catch (Exception excessao) {
			Assert.fail("A validação falhou");
		}
	}

}
