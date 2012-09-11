package codigoNovo;

public class FabricaTipoFase {

    private static final String PRESENCIAL = "PRE";
    private static final String EAD = "EAD";
    
	public static TipoFase fabricarTipoFase(String tipo){
		if(tipo.equalsIgnoreCase(PRESENCIAL)){
			return new Presencial();
		}else if(tipo.equalsIgnoreCase(EAD)){
			return new EAD();
		}
		return null;
	}
}
