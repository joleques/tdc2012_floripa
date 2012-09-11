package codigoNovo;

import java.util.List;

import codigoAntigo.Candidato;
import codigoAntigo.Prova;



public abstract class TipoFase {
	public abstract List<Candidato> carregarCandidatos(VestibularFase fase);
	public abstract List<Prova> listarProvasDaFase(VestibularFase fase);
}
