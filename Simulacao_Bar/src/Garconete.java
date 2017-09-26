
public class Garconete {

	private int totalGarrafasEnchidas = 0;
	
	private int tempoQueIraFicaOciosa = 0;
	
	private boolean aguardandoCopo = false;
	
	public boolean isOciosa(int tempo){
		
		return tempoQueIraFicaOciosa == tempo;
	}
	
	public void encherGarrafa(int tempoAtual){
		aguardandoCopo = false;
		totalGarrafasEnchidas++;
		tempoQueIraFicaOciosa = tempoAtual + 3;
	}

	public boolean isTerminoEncher(int tempo) {
		if(tempoQueIraFicaOciosa == tempo && tempo > 0){

			return true;
		}
		
		return false;
	}

	public int getTotalGarrafasEnchidas() {
		return totalGarrafasEnchidas;
	}

	public void setTotalGarrafasEnchidas(int totalGarrafasEnchidas) {
		this.totalGarrafasEnchidas = totalGarrafasEnchidas;
	}

	public int getTempoQueIraFicaOciosa() {
		return tempoQueIraFicaOciosa;
	}

	public void setTempoQueIraFicaOciosa(int tempoQueIraFicaOciosa) {
		this.tempoQueIraFicaOciosa = tempoQueIraFicaOciosa;
	}

	public boolean isAguardandoCopo() {
		return aguardandoCopo;
	}

	public void setAguardandoCopo(boolean aguardandoCopo) {
		this.aguardandoCopo = aguardandoCopo;
	}
	
	
	
}
