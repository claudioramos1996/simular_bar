import javax.swing.JOptionPane;

public class SimulacaoV2 {

	public static void main(String[] args) {

		simular();
	}

	public static void simular() {

		Garconete garconete = new Garconete();

		Bar bar = new Bar();

		for (int tempo = 0; tempo < 40; tempo++) {

			bar.atualizar(tempo);

			mostrarInformacoes(bar, garconete, tempo,true);


			if(garconete.isAguardandoCopo()){
				garconete.setTempoQueIraFicaOciosa(tempo);
			}
			
			if(garconete.isTerminoEncher(tempo) && garconete.isAguardandoCopo() == false)
				if (bar.isClienteOcioso(tempo)) {
					bar.beberGarrefa(tempo);
				}
			
			if (garconete.isOciosa(tempo))
				if (bar.isGarrafaVazia(tempo)) {
					garconete.encherGarrafa(tempo);
				}

			if(garconete.isOciosa(tempo) && bar.isGarrafaVazia(tempo) == false)
				garconete.setAguardandoCopo(true);
				
			mostrarInformacoes(bar, garconete, tempo,false);

			System.out.print("\n\n");
		}
		
		informacoesFinais(bar,garconete);
	}

	private static void informacoesFinais(Bar bar ,Garconete garconete){
		
		
		
		String texto = "\nClientes: ";
		
		for (Cliente cliente : bar.getClientesBebendo()) {
			texto += "\nCliente " + cliente.getCod() + " bebeu: " + cliente.getVolumeBedido() + " Litros";
		}
		
		JOptionPane.showMessageDialog(null, "Total de copos enchidos foi: " + garconete.getTotalGarrafasEnchidas() + texto);
		
	}
	@SuppressWarnings("static-access")
	private static void mostrarInformacoes(Bar bar, Garconete garcionete, int minuto, boolean momentoInicial) {
		
//		if(momentoInicial == true)
//			return;
		
		String texto = "";
		
		if(momentoInicial){
			texto += "\n ------- /// ------\n";
			texto += (momentoInicial) ? "MINUTO: " + (minuto) + "\n" : "";
		}
		texto += "\n";
		
		texto += (momentoInicial) ? "NO COMEÇO ":"\nNO FINAL";
		
		texto += "\nGARCIONENTE ESTÁ: " + (garcionete.isOciosa(minuto) ||  garcionete.isAguardandoCopo() ? "Aguardando para encher" : "Enchendo");
		
		texto += "\n";
		texto += "\nGARRAFAS VAZIOS: " + bar.getGarrafasVazias().size();
		texto += "\nGARRAFAS CHEIOS: " + bar.getGarrafasCheias().size();
		
		texto += "\n";
		texto += "\nCLIENTES OCIOSOS: " + bar.getClientesOciosos().size();
		texto += "\nCLIENTES OCUPADOS: " + bar.getClientesBebendo().size();

		System.out.print(texto);

	}
}
