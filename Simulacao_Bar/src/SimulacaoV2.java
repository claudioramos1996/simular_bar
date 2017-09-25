
public class SimulacaoV2 {

	public static void main(String[] args) {

		simular();
	}

	public static void simular() {

		Garcionete garcionete = new Garcionete();

		Bar bar = new Bar();

		for (int tempo = 0; tempo < 40; tempo++) {

			bar.atualizar(tempo);

			mostrarInformacoes(bar, garcionete, tempo,true);


			if(garcionete.isAguardandoCopo()){
				garcionete.setTempoQueIraFicaOciosa(tempo);
			}
			
			if(garcionete.isTerminoEncher(tempo) && garcionete.isAguardandoCopo() == false)
				if (bar.isClienteOcioso(tempo)) {
					bar.beberGarrefa(tempo);
				}
			
			if (garcionete.isOciosa(tempo))
				if (bar.isGarrafaVazia(tempo)) {
					garcionete.encherGarrafa(tempo);
				}

			if(garcionete.isOciosa(tempo) && bar.isGarrafaVazia(tempo) == false)
				garcionete.setAguardandoCopo(true);
				
			mostrarInformacoes(bar, garcionete, tempo,false);

			System.out.print("\n\n");
		}
	}

	@SuppressWarnings("static-access")
	private static void mostrarInformacoes(Bar bar, Garcionete garcionete, int minuto, boolean momentoInicial) {
		
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
