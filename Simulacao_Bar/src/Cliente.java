
public class Cliente {

	private int cod;

	private long volumeBedido = 0;
	
	private Garrafa garrafaBebida = null;

	private int horarioTerminalBeber = 0;

	public Cliente(int cod) {
		this.cod = cod;
	}
	
	public void beber(int tempo, Garrafa garrafa){
		
		horarioTerminalBeber = tempo+7;
		
		//volumeBedido += garrafa.getLitros();
		
		garrafaBebida = garrafa;
	}
	
	public boolean isOcioso(int tempo){
		if(tempo == horarioTerminalBeber){
			//volumeBedido += 500;
			return true;
		}
		return false;
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
