import java.util.ArrayList;
import java.util.List;

public class Simulacao {

	public static void main(String[] args) {
		
		System.out.println("Quantidade de garrafas enchidas: "+ rodarSimulacao());
	}

	public static int rodarSimulacao() {

		int totalGarrafasEnchidas = 0;

		long volumeBedidoPorClient1 = 0;

		List<Garrafa> garrafasVazias = new ArrayList<Garrafa>();

		List<Garrafa> garrafasCheias = new ArrayList<Garrafa>();

		List<Cliente> clientesOciosos = new ArrayList<Cliente>();

		Garrafa garrafa1 = new Garrafa(1);

		Garrafa garrafa2 = new Garrafa(2);

		Garrafa garrafa3 = new Garrafa(3);

		garrafasVazias.add(garrafa1);
		garrafasVazias.add(garrafa2);
		garrafasVazias.add(garrafa3);

		for (int i = 0; i < 50; i++) {

			// Verifica se deu 3 minutos
			if (i % 3 == 0) {

				// Verifica se tem garrafa vazia
				if (garrafasVazias.size() > 0) {

					Garrafa garrafaVazia = garrafasVazias.get(0);
					garrafasVazias.remove(0);

					garrafasCheias.add(garrafaVazia);

					totalGarrafasEnchidas++;
				}

			}
		}

		return totalGarrafasEnchidas;
	}

}
