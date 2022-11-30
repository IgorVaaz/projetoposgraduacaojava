import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ConsultarExcluirPlacaPasseio implements ActionListener {

	static JFrame janelaConsultarExcluirPlaca = new JFrame();

	// aplicando Singleton
	private static ConsultarExcluirPlacaPasseio consultarExcluirPlacaPasseio = new ConsultarExcluirPlacaPasseio();

	private static ConsultarExcluirPlacaPasseio consultarExcluirPlacaPasseioUnico;

	public static ConsultarExcluirPlacaPasseio getCadastroPasseio() {
		if (consultarExcluirPlacaPasseioUnico == null) {
			consultarExcluirPlacaPasseioUnico = new ConsultarExcluirPlacaPasseio();
		}
		return consultarExcluirPlacaPasseioUnico;
	}
	// finalizou singleton

	static JButton btConsultar = new JButton("Consultar");
	static JButton btExcluir = new JButton("Excluir");
	static JButton btSair = new JButton("Sair");

	static JLabel rtPlaca = new JLabel("Informe a Placa: ");
	static JTextField cxPlaca = new JTextField(10);

	static JLabel rtQtdPassageiro = new JLabel("Qtd. Passageiros: ");
	static JTextField cxQtdPassageiro = new JTextField(4);

	static JLabel rtMarca = new JLabel("Marca: ");
	static JTextField cxMarca = new JTextField(15);

	static JLabel rtModelo = new JLabel("Modelo: ");
	static JTextField cxModelo = new JTextField(15);

	static JLabel rtCor = new JLabel("Cor: ");
	static JTextField cxCor = new JTextField(10);

	static JLabel rtQtdRodas = new JLabel("Qtd. Rodas: ");
	static JTextField cxQtdRodas = new JTextField(4);

	static JLabel rtVelocidadeMax = new JLabel("Velocidade Max: ");
	static JTextField cxVelocidadeMax = new JTextField(6);

	static JLabel rtQtdPistoes = new JLabel("Qtd. Pistoes: ");
	static JTextField cxQtdPistoes = new JTextField(4);

	static JLabel rtPotencia = new JLabel("Potencia: ");
	static JTextField cxPotencia = new JTextField(4);

	public static void main(String[] args) {
		janelaConsultarExcluirPlaca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaConsultarExcluirPlaca.setSize(600, 450);
		janelaConsultarExcluirPlaca.setTitle("Consultar/Excluir pela Placa");

		janelaConsultarExcluirPlaca.add(rtPlaca);
		janelaConsultarExcluirPlaca.add(cxPlaca);

		janelaConsultarExcluirPlaca.add(rtQtdPassageiro);
		janelaConsultarExcluirPlaca.add(cxQtdPassageiro);

		janelaConsultarExcluirPlaca.add(rtMarca);
		janelaConsultarExcluirPlaca.add(cxMarca);

		janelaConsultarExcluirPlaca.add(rtModelo);
		janelaConsultarExcluirPlaca.add(cxModelo);

		janelaConsultarExcluirPlaca.add(rtCor);
		janelaConsultarExcluirPlaca.add(cxCor);

		janelaConsultarExcluirPlaca.add(rtQtdRodas);
		janelaConsultarExcluirPlaca.add(cxQtdRodas);

		janelaConsultarExcluirPlaca.add(rtVelocidadeMax);
		janelaConsultarExcluirPlaca.add(cxVelocidadeMax);

		janelaConsultarExcluirPlaca.add(rtQtdPistoes);
		janelaConsultarExcluirPlaca.add(cxQtdPistoes);

		janelaConsultarExcluirPlaca.add(rtPotencia);
		janelaConsultarExcluirPlaca.add(cxPotencia);

		janelaConsultarExcluirPlaca.add(btConsultar);
		janelaConsultarExcluirPlaca.add(btExcluir);
		janelaConsultarExcluirPlaca.add(btSair);

		btConsultar.addActionListener(consultarExcluirPlacaPasseio);
		btExcluir.addActionListener(consultarExcluirPlacaPasseio);
		btSair.addActionListener(consultarExcluirPlacaPasseio);

		janelaConsultarExcluirPlaca.setLayout(new FlowLayout());
		janelaConsultarExcluirPlaca.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {

		if (evt.getSource().equals(btSair)) {
			janelaConsultarExcluirPlaca.dispose();
		}
		if (evt.getSource().equals(btConsultar)) {
			consultarPelaPlacaPasseio();
		}
		if (evt.getSource().equals(btExcluir)) {
			excluirPelaPlaca();
		}

	}

	public void consultarPelaPlacaPasseio() {
		Passeio passeio = new Passeio();

		passeio.setPlaca(cxPlaca.getText());

		passeio = BDVeiculos.consPlacaPasseio(passeio);

		if (passeio != null) {
			impUmPasseio(passeio);
		} else {
			JOptionPane.showConfirmDialog(
					null,
					"Nao existe passeio com essa placa!",
					"Placa nao encontrada",
					JOptionPane.ERROR_MESSAGE
					);
			limparDados();
		}
	}
	
	public void limparDados() {
		cxQtdPassageiro.setText("");
		cxPlaca.setText("");
		cxMarca.setText("");
		cxModelo.setText("");
		cxCor.setText("");
		cxQtdRodas.setText("");
		cxVelocidadeMax.setText("");
		cxQtdPistoes.setText("");
		cxPotencia.setText("");
		cxPlaca.requestFocus();
	}

	public void excluirPelaPlaca() {
		System.out.println("Excluir Veiculo de PASSEIO pela Placa");
        Passeio passeio = new Passeio();
        passeio.setPlaca(cxPlaca.getText());

        passeio = BDVeiculos.consPlacaPasseio(passeio);
        if (passeio != null) {
            BDVeiculos.delBDPasseio(passeio);
            JOptionPane.showConfirmDialog(
            		null,
            		"Passeio excluido com sucesso!",
            		"Exclusao de Passeio",
            		JOptionPane.INFORMATION_MESSAGE
            		);

        } else {
        	JOptionPane.showConfirmDialog(
            		null,
            		"Nao existe Passeio com essa Placa!",
            		"Erro na Exclusao de Passeio",
            		JOptionPane.INFORMATION_MESSAGE
            		);
        }
        limparDados();
	}

	public void impUmPasseio(Passeio p) {
		cxQtdPassageiro.setText(String.valueOf(p.getQtdPassageiros()));
		cxMarca.setText(p.getMarca());
		cxModelo.setText(p.getModelo());
		cxCor.setText(p.getCor());
		cxQtdRodas.setText(String.valueOf(p.getQtdRodas()));
		cxVelocidadeMax.setText(String.valueOf(p.getVelocMax()));
		cxQtdPistoes.setText(String.valueOf(p.getMotor().getQtdPist()));
		cxPotencia.setText(String.valueOf(p.getMotor().getPotencia()));
	}

}
