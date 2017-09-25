
public class Cliente {

	private int cod;

	private long volumeBedido;
	
	private Garrafa garrafaBebida = null;

	private int horarioTerminalBeber = 0;

	public Cliente(int cod) {
		this.cod = cod;
	}
	
	public void beber(int tempo, Garrafa garrafa){
		
		horarioTerminalBeber = tempo+7;
		
		garrafaBebida = garrafa;
	}
	
	public boolean isOcioso(int tempo){
		return tempo == horarioTerminalBeber;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public long getVolumeBedido() {
		return volumeBedido;
	}

	public void setVolumeBedido(long volumeBedido) {
		this.volumeBedido = volumeBedido;
	}

	public Garrafa getGarrafaBebida() {
		return garrafaBebida;
	}


	
}
