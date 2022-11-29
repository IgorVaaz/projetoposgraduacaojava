
public class Teste {

	// atributos static pois serão utilizados dentro do Main abaixo
	private static Passeio passeio = new Passeio();
	private static Carga carga = new Carga();

	// private static Passeio vetPasseio[] = new Passeio[5];
	// private static Carga vetCarga[] = new Carga[5];

	private static Leitura lei = new Leitura();

	public static void main(String[] args) throws VeicExistException, VelocException {
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
			System.out.println("(7) Excluir Veiculo de PASSEIO pela Placa");
			System.out.println("(8) Excluir Veiculo de CARGA pela Placa");
			System.out.println("(9) Sair do Sistema");

			try {

				opcao = Integer.parseInt(lei.entDados("Escolha uma opcao: "));

			} catch (NumberFormatException nfe) {
				System.out.println("Deve ser um valor inteiro - press <ENTER>");
				lei.entDados("");

				continue;
			}

			switch (opcao) {
			case 1:
				Passeio p = new Passeio();
				System.out.println("\nCadastro de PASSEIO\n");
				System.out.println("-----------------------------");
				p.setQtdPassageiros(Integer.parseInt(lei.entDados("Qtde de Passageiros: ")));
				p.setPlaca(lei.entDados("Placa: "));
				p.setMarca(lei.entDados("Marca: "));
				p.setModelo(lei.entDados("Modelo: "));
				p.setCor(lei.entDados("Cor: "));
				p.setQtdRodas(Integer.parseInt(lei.entDados("Qtde Rodas: ")));
				p.setVelocMaxPasseio(Float.parseFloat(lei.entDados("Veloc Max: ")));
				p.getMotor().setQtdPist(Integer.parseInt(lei.entDados("Qtd Pistao: ")));
				p.getMotor().setPotencia(Integer.parseInt(lei.entDados("Potencia: ")));

				BDVeiculos.setBDPasseio(p);
				System.out.println("\nPasseio Cadastrado com Sucesso!");
				break;

			case 2:
				Carga c = new Carga();
				System.out.println("\nCadastro de PASSEIO\n");
				System.out.println("-----------------------------");
				c.setTara(Integer.parseInt(lei.entDados("Tara: ")));
				c.setCargaMax(Integer.parseInt(lei.entDados("CargaMax: ")));
				c.setPlaca(lei.entDados("Placa: "));
				c.setMarca(lei.entDados("Marca: "));
				c.setModelo(lei.entDados("Modelo: "));
				c.setCor(lei.entDados("Cor: "));
				c.setQtdRodas(Integer.parseInt(lei.entDados("Qtd Rodas: ")));
				c.setVelocMaxCarga(Float.parseFloat(lei.entDados("Veloc Max: ")));
				c.getMotor().setQtdPist(Integer.parseInt(lei.entDados("Qtd Pistao do motor: ")));
				c.getMotor().setPotencia(Integer.parseInt(lei.entDados("Potencia do motor: ")));

				BDVeiculos.setBDCarga(c);
				//System.out.println("\nCarga Cadastrado com Sucesso!");
				break;

			case 3:
				System.out.println("Impressao veiculos PASSEIO");
				System.out.println("-----------------------------");
				BDVeiculos.impListaPasseio();
				System.out.println("-----------------------------");
				break;
			case 4:
				System.out.println("Impressao veiculos CARGA");
				System.out.println("-----------------------------");
				BDVeiculos.impListaCarga();
				System.out.println("-----------------------------");
				break;

			case 5:

				System.out.println("Consulta pela PLACA - PASSEIO");
				System.out.println("-----------------------------");

				passeio = new Passeio();

				passeio.setPlaca(lei.entDados("\nInforme a placa: "));

				passeio = BDVeiculos.consPlacaPasseio(passeio);

				if (passeio == null) {
					System.out.println("\nPlaca nao existe");
				} else {
					System.out.println("Qtde Passageiros: " + passeio.getQtdPassageiros());
				}

				break;

			case 6:

				System.out.println("Consulta pela PLACA - CARGA");
				System.out.println("-----------------------------");

				carga = new Carga();
				carga.setPlaca(lei.entDados("\nInforme a placa: "));

				carga = BDVeiculos.consPlacaCarga(carga);
				
				if(carga != null) {
					BDVeiculos.impUmaCarga(carga);
				}else {
					lei.entDados("\n Nao existe carga com essa placa!");
				}
				
				break;

			case 7:
				System.out.println("Excluir Veiculo de PASSEIO pela Placa");
				passeio = new Passeio();
				passeio.setPlaca(lei.entDados("\nInforme a placa para excluir: "));

				passeio = BDVeiculos.consPlacaPasseio(passeio);
				if (passeio == null) {
					System.out.println("Placa nao existe");
					break;

				} else {
					BDVeiculos.delBDPasseio(passeio);
					System.out.println("Exluido com sucesso!");
				}
				break;

			case 8:

				System.out.println("Excluir Veiculo de CARGA pela Placa");
				carga = new Carga();
				carga.setPlaca(lei.entDados("Informe a placa:"));
				carga = BDVeiculos.consPlacaCarga(carga);
				
				if(carga != null) {
					BDVeiculos.delBDCarga(carga);
					System.out.println("Carga excluida com sucesso");
					break;
				} else {
					lei.entDados("\nNao existe carga com essa placa!");
				}
				
				break;

			case 9:
				continua = false;
				break;

			default:
				lei.entDados("O valor deve ser >=1 e <= 7 press <ENTER>");
				break;
			} // fim do switch-case

		} // fim do while

	} // fim do main

} // fim da classe
