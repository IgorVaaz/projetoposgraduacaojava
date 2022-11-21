import java.util.Iterator;

public class Teste {

	// atributos static pois serão utilizados dentro do Main abaixo
	private static Passeio passeio = new Passeio();
	private static Carga carga = new Carga();

	private static Passeio vetPasseio[] = new Passeio[5];
	private static Carga vetCarga[] = new Carga[5];

	private static Leitura lei = new Leitura();

	public static void main(String[] args) {
		System.out.println("-----------------------------");

		boolean continua = true;
		int opcao = 0;

		while (continua) {
			System.out.println("\nSistema de Gestao de Veiculos - Menu Inicial");
			System.out.println("(1) Cadastrar veiculo de PASSEIO");
			System.out.println("(2) Cadastrar veiculo de CARGA");
			System.out.println("(3) Imprimir todos veiculos PASSEIO");
			System.out.println("(4) Imprimir todos veiculos CARGA");
			System.out.println("(5) Imprimir veiculo PASSEIO pela Placa");
			System.out.println("(6) Imprimir veiculo CARGA pela Placa");
			System.out.println("(7) Sair do Sistema");

			try {

				opcao = Integer.parseInt(lei.entDados("Escolha uma opcao: "));

			} catch (NumberFormatException nfe) {
				System.out.println("Deve ser um valor inteiro - press <ENTER>");
				lei.entDados("");

				continue;
			}

			switch (opcao) {
			case 1:
				for (int i = achaVagoPasseio(); i < vetPasseio.length; i++) {
					if (i == -1) {
						lei.entDados("Vetor de PASSEIO esta cheio!! press <ENTER>");
					}

					passeio = new Passeio();
					vetPasseio[i] = cadPasseio(passeio);

					lei.entDados("Passeio armazenado na posicao: " + i + " press <ENTER>");

					String respPass = lei.entDados("Deseja cadastrar outro PASSEIO? <s/n>");

					if (respPass.equalsIgnoreCase("n")) {
						break;
					}
					if (achaVagoPasseio() == -1) {
						lei.entDados("Vetor de PASSEIO esta cheio! press <ENTER>");
						break;
					}

				}
				break;

			case 2:
				for (int i = achaVagoCarga(); i < vetCarga.length; i++) {
					if (i == -1) {
						lei.entDados("Vetor de CARGA esta cheio! press <ENTER>");
						break;
					}

					carga = new Carga();
					vetCarga[i] = cadCarga(carga);

					lei.entDados("Carga armazenada na posicao: " + i + " press <ENTER>");

					String respCarg = lei.entDados("Deseja cadastrar outra carga? <s/n>");

					if (respCarg.equalsIgnoreCase("n")) {
						break;
					}

					if (achaVagoCarga() == -1) {
						lei.entDados("Vetor de Carga esta cheio! press <ENTER>");
						break;
					}

				}
				break;

			case 3:

				System.out.println("Impressao veiculos PASSEIO");
				System.out.println("-----------------------------");
				for (int i = 0; i < vetPasseio.length; i++) {
					if (vetPasseio[i] != null) {
						impPasseio(vetPasseio[i], i);
					} else {
						lei.entDados("Sem veiculos PASSEIO para imprimir press <ENTER>");
					}
				}
				System.out.println("-----------------------------");
				break;
			case 4:
				System.out.println("Impressao veiculos CARGA");
				System.out.println("-----------------------------");
				for (int i = 0; i < vetCarga.length; i++) {
					if (vetCarga[1] != null) {
						impCarga(vetCarga[i], i);
					} else {
						lei.entDados("Sem veiculos CARGA p/ imprimir press <ENTER>");
					}
				}
				System.out.println("-----------------------------");
				break;

			case 5:

				System.out.println("Consulta pela PLACA - PASSEIO");
				System.out.println("-----------------------------");

				passeio = new Passeio();
				boolean existePlacaPasseio = false;

				String placaPasseio = lei.entDados("Informe a placa: ");

				passeio.setPlaca(placaPasseio);

				for (int i = 0; i < vetPasseio.length; i++) {// pergunta se ela é igual ao do objeto
					if (vetPasseio[i] == null) {
						System.out.println("\nvetPasseio[" + i + "] nao foi criado!");
					} else {
						if (vetPasseio[i].getPlaca().equalsIgnoreCase(passeio.getPlaca())) {
							impPasseio(vetPasseio[i], i);
							existePlacaPasseio = true;
						}
					}
				}
				if (!existePlacaPasseio) {
					lei.entDados("Nao existe veiculo passeio com a placa: " + placaPasseio);
				}

				break;

			case 6:

				System.out.println("Consulta pela PLACA - CARGA");
				System.out.println("-----------------------------");

				carga = new Carga();
				boolean existePlacaCarga = false;

				String placaCarga = lei.entDados("Informe a placa: ");
				carga.setPlaca(placaCarga);
//				System.out.println("A PLACA ESCOLHIDA: " + carga.getPlaca());
//				System.out.println("A PLACA do vetor: " + vetCarga[0].getPlaca());
				for (int i = 0; i < vetCarga.length; i++) {
					if (vetCarga[i] == null) {
						System.out.println("\nvetCarga[" + i + "] nao foi criado!");
					} else {

						if (vetCarga[i].getPlaca().equalsIgnoreCase(carga.getPlaca())) {
							impCarga(vetCarga[i], i);
							existePlacaCarga = true;
						}
					}
				}
				if (!existePlacaCarga) {
					lei.entDados("Nao existe veiculo carga coma placa: " + placaCarga);
				}

				break;

			case 7:
				continua = false;
				break;
			default:
				lei.entDados("O valor deve ser >=1 e <= 7 press <ENTER>");
				break;
			} // fim do switch-case

		} // fim do while

	} // fim do main

	// encontra endereço de passeio vazio antes de inserir objeto
	public static int achaVagoPasseio() {
		for (int i = 0; i < vetPasseio.length; i++) {
			if (vetPasseio[i] == null) {
				return i;
			}
		}
		return -1; // vetPasseio está cheio
	}

	// encontra endereço de carga vazio antes de inserir objeto
	public static int achaVagoCarga() {
		for (int i = 0; i < vetCarga.length; i++) {
			if (vetCarga[i] == null) {
				return i;
			}
		}
		return -1; // vetCargo está cheio
	}

	// Cadastrar Passeio
	public static Passeio cadPasseio(Passeio passeio) {
		System.out.println("-----------------------------");
		System.out.println("Cadastro de Veiculo de PASSEIO");
		passeio.setQtdPassageiros(Integer.parseInt(lei.entDados("Qtde de Passageiros: ")));
		passeio.setPlaca(lei.entDados("Placa: "));
		passeio.setMarca(lei.entDados("Marca: "));
		passeio.setModelo(lei.entDados("Modelo: "));
		passeio.setCor(lei.entDados("Cor: "));
		passeio.setQtdRodas(Integer.parseInt(lei.entDados("Qtde Rodas: ")));
		passeio.setVelocMax(Float.parseFloat(lei.entDados("Veloc Max: ")));
		passeio.getMotor().setQtdPist(Integer.parseInt(lei.entDados("Qtd Pistao: ")));
		passeio.getMotor().setPotencia(Integer.parseInt(lei.entDados("Potencia: ")));

		return passeio;

	}

	// Imprimir Passeio
	public static void impPasseio(Passeio passeio, int i) {
		System.out.println("-----------------------------");
		System.out.println("Passeio do endereco: " + i + " do vetPasseio[i]");
		System.out.println("Qtde de Passageiros: " + passeio.getQtdPassageiros());
		System.out.println("Placa: " + passeio.getPlaca());
		System.out.println("Marca: " + passeio.getMarca());
		System.out.println("Modelo: " + passeio.getModelo());
		System.out.println("Cor: " + passeio.getCor());
		System.out.println("Qtd Rodas: " + passeio.getQtdRodas());
		System.out.println("VelocidadeMaxima: " + passeio.getVelocMax());
		System.out.println("Qtd Pistoes do motor: " + passeio.getMotor().getQtdPist());
		System.out.println("Potencia do motor: " + passeio.getMotor().getPotencia());
		System.out.println("Qtde de Letras: " + passeio.calcular());
		passeio.calcVel(passeio.getVelocMax());
	}

	// Cadastrar Carga
	public static Carga cadCarga(Carga carga) {
		System.out.println("-----------------------------");
		System.out.println("Cadastro de Veiculo de CARGA");
		carga.setTara(Integer.parseInt(lei.entDados("Tara: ")));
		carga.setCargaMax(Integer.parseInt(lei.entDados("CargaMax: ")));
		carga.setPlaca(lei.entDados("Placa: "));
		carga.setMarca(lei.entDados("Marca; "));
		carga.setModelo(lei.entDados("Modelo: "));
		carga.setCor(lei.entDados("Cor: "));
		carga.setQtdRodas(Integer.parseInt(lei.entDados("Qtd Rodas: ")));
		carga.setVelocMax(Float.parseFloat(lei.entDados("Veloc Max: ")));
		carga.getMotor().setQtdPist(Integer.parseInt(lei.entDados("Qtd Pistao do motor: ")));
		carga.getMotor().setPotencia(Integer.parseInt(lei.entDados("Potencia do motor: ")));

		return carga;
	}

	// Imprimir Carga
	public static void impCarga(Carga carga, int i) {
		System.out.println("-----------------------------");
		System.out.println("Carga do endereco: " + i + " do vetCarga[i]");
		System.out.println("Carga Max: " + carga.getCargaMax());
		System.out.println("Tara: " + carga.getTara());
		System.out.println("Placa: " + carga.getPlaca());
		System.out.println("Marca: " + carga.getMarca());
		System.out.println("Modelo: " + carga.getModelo());
		System.out.println("Cor: " + carga.getCor());
		System.out.println("VelocidadeMaxima " + carga.getVelocMax());
		System.out.println("Qtd Rodas: " + carga.getQtdRodas());
		System.out.println("Potencia Motor: " + carga.getMotor().getPotencia());
		System.out.println("Qtd pistao Motor: " + carga.getMotor().getQtdPist());
		System.out.println("Soma valores: " + carga.calcular());
		carga.calcVel(carga.getVelocMax());
	}

} // fim da classe
