package codigoNovo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import codigoAntigo.Candidato;
import codigoAntigo.Prova;



public class VestibularFase {

	private Long codigoFase;
	private Long codigoVest;
	private Long nrFase;
	private TipoFase tipoFase;
	private Date dtInicioFase;
	private Date dtFimFase;
	private String tipoProva;
	private List<Candidato> listaCandidatos;

	public VestibularFase(String tipoFase) {
		this.tipoFase = FabricaTipoFase.fabricarTipoFase(tipoFase);
	}

	public Long getCodigoFase() {
		return codigoFase;
	}

	public void setCodigoFase(Long codigoFase) {
		this.codigoFase = codigoFase;
	}

	public Long getCodigoVest() {
		return codigoVest;
	}

	public void setCodigoVest(Long codigoVest) {
		this.codigoVest = codigoVest;
	}

	public Long getNrFase() {
		return nrFase;
	}

	public void setNrFase(Long nrFase) {
		this.nrFase = nrFase;
	}

	public Date getDtInicioFase() {
		return dtInicioFase;
	}

	public void setDtInicioFase(Date dtInicioFase) {
		this.dtInicioFase = dtInicioFase;
	}

	public Date getDtFimFase() {
		return dtFimFase;
	}

	public void setDtFimFase(Date dtFimFase) {
		this.dtFimFase = dtFimFase;
	}

	public String getTipoProva() {
		return tipoProva;
	}

	public void setTipoProva(String tipoProva) {
		this.tipoProva = tipoProva;
	}

	public List<Candidato> getListaCandidatos() {
		return listaCandidatos;
	}

	public void setListaCandidatos(List<Candidato> listaCandidatos) {
		this.listaCandidatos = listaCandidatos;
	}

	public void carregarCandidatos() {
		if (tipoFase != null) {
			listaCandidatos = tipoFase.carregarCandidatos(this);
		}
	}

	public List<Prova> listarProvasDaFase() {
		if (tipoFase != null) {
			return tipoFase.listarProvasDaFase(this);
		}
		return new ArrayList<Prova>();
	}
}
