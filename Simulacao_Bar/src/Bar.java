import java.util.ArrayList;
import java.util.List;

public class Bar {

	private static List<Garrafa> garrafasVazias = new ArrayList<Garrafa>();

	private static List<Garrafa> garrafasCheias = new ArrayList<Garrafa>();

	private static List<Cliente> clientesOciosos = new ArrayList<Cliente>();

	private static List<Cliente> clientesBebendo = new ArrayList<Cliente>();

	private static int garrafaEnchidas = 0;
	
	public void atualizar(int tempo){
		
		for (int i = 0; i < clientesBebendo.size(); i++) {
			
			Cliente cliente = clientesBebendo.get(i);
			
			if (cliente.isOcioso(tempo)) {

				cliente.setVolumeBedido(cliente.getVolumeBedido() + 500);
				
				esvaziarUmaGarrafa();

				tornarUmClienteOcioso(cliente.getCod());
			}
			
		}

	}
	
	public boolean isClienteOcioso(int tempo) {

		return clientesOciosos.size() > 0;
	}

	public boolean isGarrafaVazia(int tempo) {

		return garrafasVazias.size() > 0;

	}

	public void tornarUmClienteOcioso(int codCliente) {

		for (int i = 0; i < clientesBebendo.size(); i++) {

			Cliente cliente = clientesBebendo.get(i);

			if (cliente.getCod() == codCliente) {

				clientesBebendo.remove(i);
				
				clientesOciosos.add(cliente);
			}
		}

	}

//	public Garrafa retornaGarrafaVazia() {
//
//		Garrafa garrafa = garrafasVazias.get(0);
//		garrafasVazias.remove(0);
//
//		garrafasCheias.add(garrafa);
//
//		return garrafa;
//	}

	public void esvaziarUmaGarrafa() {

		Garrafa garrafa = garrafasCheias.get(0);
		garrafasCheias.remove(0);
		
		garrafasVazias.add(garrafa);

	}

	public void beberGarrefa(int tempo) {

		Garrafa garrafa = encherGarrafa(tempo);

		Cliente clienteOcioso = clientesOciosos.get(0);
		clientesOciosos.remove(0);
		clientesBebendo.add(clienteOcioso);

		clienteOcioso.beber(tempo, garrafa);

	}

	private Garrafa encherGarrafa(int tempo) {

		Garrafa garrafaVazia = garrafasVazias.get(0);
		garrafasVazias.remove(0);

		garrafasCheias.add(garrafaVazia);

		return garrafaVazia;
	}

	public Bar() {

		// LISTA DE GARRAFAS

		Garrafa garrafa1 = new Garrafa(1);

		Garrafa garrafa2 = new Garrafa(2);

		Garrafa garrafa3 = new Garrafa(3);

		garrafasVazias.add(garrafa1);
		garrafasVazias.add(garrafa2);
		garrafasVazias.add(garrafa3);

		// LISTA DE CLIENTES

		Cliente cliente1 = new Cliente(1);
		Cliente cliente2 = new Cliente(2);
		Cliente cliente3 = new Cliente(3);

		clientesOciosos.add(cliente1);
		clientesOciosos.add(cliente2);
		clientesOciosos.add(cliente3);

	}

	public static List<Garrafa> getGarrafasVazias() {
		return garrafasVazias;
	}

	public static void setGarrafasVazias(List<Garrafa> garrafasVazias) {
		Bar.garrafasVazias = garrafasVazias;
	}

	public static List<Garrafa> getGarrafasCheias() {
		return garrafasCheias;
	}

	public static void setGarrafasCheias(List<Garrafa> garrafasCheias) {
		Bar.garrafasCheias = garrafasCheias;
	}

	public static List<Cliente> getClientesOciosos() {
		return clientesOciosos;
	}

	public static void setClientesOciosos(List<Cliente> clientesOciosos) {
		Bar.clientesOciosos = clientesOciosos;
	}

	public static List<Cliente> getClientesBebendo() {
		return clientesBebendo;
	}

	public static void setClientesBebendo(List<Cliente> clientesBebendo) {
		Bar.clientesBebendo = clientesBebendo;
	}

	public static int getGarrafaEnchidas() {
		return garrafaEnchidas;
	}

	public static void setGarrafaEnchidas(int garrafaEnchidas) {
		Bar.garrafaEnchidas = garrafaEnchidas;
	}
	
	

}
