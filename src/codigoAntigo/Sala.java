package codigoAntigo;

import java.util.ArrayList;
import java.util.List;


public class Sala {

	private Long codigo;
	private Integer capacidade;
	private Integer totalOcupada;
	private List<Candidato> listaCandidatos;	

	public Sala() {
		listaCandidatos = new ArrayList<Candidato>();
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Integer getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}
	public Integer getTotalOcupada() {
		return totalOcupada;
	}
	public void setTotalOcupada(Integer totalOcupada) {
		this.totalOcupada = totalOcupada;
	}
	
	public void addCandidato(Candidato candidatoNovo){
		listaCandidatos.add(candidatoNovo);
	}
	
	
}
