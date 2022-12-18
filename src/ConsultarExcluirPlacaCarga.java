import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ConsultarExcluirPlacaCarga implements ActionListener {

	static JFrame janelaConsultarExcluirPlaca = new JFrame();

	// aplicando Singleton
	private static ConsultarExcluirPlacaCarga consultarExcluirPlacaCarga = new ConsultarExcluirPlacaCarga();

	private static ConsultarExcluirPlacaCarga consultarExcluirPlacaCargaUnica;

	public static ConsultarExcluirPlacaCarga getCadastroCarga() {
		if (consultarExcluirPlacaCargaUnica == null) {
			consultarExcluirPlacaCargaUnica = new ConsultarExcluirPlacaCarga();
		}
		return consultarExcluirPlacaCargaUnica;
	}
	// finalizou singleton

	static JButton btConsultar = new JButton("Consultar");
	static JButton btExcluir = new JButton("Excluir");
	static JButton btSair = new JButton("Sair");

	static JLabel rtPlaca = new JLabel("Informe a Placa: ");
	static JTextField cxPlaca = new JTextField(10);

	static JLabel rtTara = new JLabel("Tara: ");
	static JTextField cxTara = new JTextField(4);

	static JLabel rtCargaMax = new JLabel("Carga Max: ");
	static JTextField cxCargaMax = new JTextField(4);

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

		janelaConsultarExcluirPlaca.add(rtTara);
		janelaConsultarExcluirPlaca.add(cxTara);

		janelaConsultarExcluirPlaca.add(rtCargaMax);
		janelaConsultarExcluirPlaca.add(cxCargaMax);

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

		btConsultar.addActionListener(consultarExcluirPlacaCarga);
		btExcluir.addActionListener(consultarExcluirPlacaCarga);
		btSair.addActionListener(consultarExcluirPlacaCarga);

		janelaConsultarExcluirPlaca.setLayout(new FlowLayout());
		janelaConsultarExcluirPlaca.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {

		if (evt.getSource().equals(btSair)) {
			janelaConsultarExcluirPlaca.dispose();
		}
		if (evt.getSource().equals(btConsultar)) {
			consultarPelaPlacaCarga();
		}
		if (evt.getSource().equals(btExcluir)) {
			excluirPelaPlaca();
		}

	}

	public void consultarPelaPlacaCarga() {
		Carga carga = new Carga();

		carga.setPlaca(cxPlaca.getText());

		carga = BDVeiculos.consPlacaCarga(carga);

		if (carga != null) {
			impUmCarga(carga);
		} else {
			JOptionPane.showConfirmDialog(null, "Nao existe carga com essa placa!", "Placa nao encontrada",
					JOptionPane.ERROR_MESSAGE);
			limparDados();
		}
	}

	public void limparDados() {
		cxTara.setText("");
		cxCargaMax.setText("");
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
		System.out.println("Excluir Veiculo de CARGA pela Placa");
		Carga carga = new Carga();
		carga.setPlaca(cxPlaca.getText());

		carga = BDVeiculos.consPlacaCarga(carga);
		if (carga != null) {
			BDVeiculos.delBDCarga(carga);
			JOptionPane.showConfirmDialog(null, "Carga excluido com sucesso!", "Exclusao de Carga",
					JOptionPane.INFORMATION_MESSAGE);

		} else {
			JOptionPane.showConfirmDialog(null, "Nao existe Carga com essa Placa!", "Erro na Exclusao de Carga",
					JOptionPane.INFORMATION_MESSAGE);
		}
		limparDados();
	}

	public void impUmCarga(Carga p) {
		cxTara.setText(String.valueOf(p.getTara()));
		cxCargaMax.setText(String.valueOf(p.getCargaMax()));
		cxPlaca.setText(String.valueOf(p.getPlaca()));
		cxMarca.setText(p.getMarca());
		cxModelo.setText(p.getModelo());
		cxCor.setText(p.getCor());
		cxQtdRodas.setText(String.valueOf(p.getQtdRodas()));
		cxVelocidadeMax.setText(String.valueOf(p.getVelocMax()));
		cxQtdPistoes.setText(String.valueOf(p.getMotor().getQtdPist()));
		cxPotencia.setText(String.valueOf(p.getMotor().getPotencia()));
	}

}
