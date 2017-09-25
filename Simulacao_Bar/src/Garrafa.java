
public class Garrafa {

	private int cod;
	private long litros;
	private int tempoQueGarrafaEstaraVazia = 0;
	
	
	public Garrafa(int cod) {
		this.cod = cod;
		litros = 500;
	}
	
	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public long getLitros() {
		return litros;
	}
	public void setLitros(long litros) {
		this.litros = litros;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		Garrafa garrafa = (Garrafa) obj;
		
		return this.getCod() == garrafa.getCod();
	}

}
