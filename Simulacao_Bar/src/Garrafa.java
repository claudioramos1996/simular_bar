
public class Garrafa {

	private int cod;
	private long litros;
	
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

}
