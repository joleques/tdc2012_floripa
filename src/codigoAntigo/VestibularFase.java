package codigoAntigo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class VestibularFase {

    private static final String PRESENCIAL = "PRE";
    private static final String EAD = "EAD";
    
	private Long codigoFase;
    private Long codigoVest;
    private Long nrFase;
    private String tipoFase;
    private Date dtInicioFase;
    private Date dtFimFase;
    private String tipoProva;
    private List<Candidato> listaCandidatos;
    
    
    
	public VestibularFase(String tipoFase) {
		this.tipoFase = tipoFase;
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
	public String getTipoFase() {
		return tipoFase;
	}
	public void setTipoFase(String tipoFase) {
		this.tipoFase = tipoFase;
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

	public void carregarCandidatos(){
		if(tipoFase.equalsIgnoreCase(EAD)){
			PoloDAO poloDAO = new PoloDAO();
			listaCandidatos = poloDAO.listarCandidatos(this);
		}else if(tipoFase.equalsIgnoreCase(PRESENCIAL)){
			FaseDAO faseDAO = new FaseDAO();
			listaCandidatos = faseDAO.listarCandidatos(this);
		}
	}
	
	public List<Prova> listarProvasDaFase(){
		List<Prova> retorno = new ArrayList<Prova>();
		if(tipoFase.equalsIgnoreCase(EAD)){
			PoloDAO poloDAO = new PoloDAO();
			List<Polo> listaDePolos = poloDAO.listarPolos(this);
			for (Polo polo : listaDePolos) {
				retorno.add(polo.getProva());
			}
		}else if(tipoFase.equalsIgnoreCase(PRESENCIAL)){
			FaseDAO faseDAO = new FaseDAO();
			retorno = faseDAO.listarProvas(this);
		}
		return retorno;		
	}
}
