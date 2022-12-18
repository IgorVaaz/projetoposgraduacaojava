import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CadastroCarga implements ActionListener {

	static JFrame janelaCarga = new JFrame();

	// aplicando Singleton
	private static CadastroCarga cadastroCarga = new CadastroCarga();

	private static CadastroCarga cadastroCargaUnica;

	public static CadastroCarga getCadastroCarga() {
		if (cadastroCargaUnica == null) {
			cadastroCargaUnica = new CadastroCarga();
		}
		return cadastroCargaUnica;
	}
	// finalizou singleton

	static JButton btCadastrar = new JButton("Cadastrar");
	static JButton btLimpar = new JButton("Limpar");
	static JButton btNovo = new JButton("Novo");
	static JButton btSair = new JButton("Sair");

	static JLabel rtTara = new JLabel("Tara: ");
	static JTextField cxTara = new JTextField(4);

	static JLabel rtCargaMax = new JLabel("Carga Max: ");
	static JTextField cxCargaMax = new JTextField(4);

	static JLabel rtPlaca = new JLabel("Placa: ");
	static JTextField cxPlaca = new JTextField(10);

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
		janelaCarga.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaCarga.setSize(600, 450);
		janelaCarga.setTitle("Cadastro de Carga");

		janelaCarga.add(rtTara);
		janelaCarga.add(cxTara);

		janelaCarga.add(rtCargaMax);
		janelaCarga.add(cxCargaMax);

		janelaCarga.add(rtPlaca);
		janelaCarga.add(cxPlaca);

		janelaCarga.add(rtMarca);
		janelaCarga.add(cxMarca);

		janelaCarga.add(rtModelo);
		janelaCarga.add(cxModelo);

		janelaCarga.add(rtCor);
		janelaCarga.add(cxCor);

		janelaCarga.add(rtQtdRodas);
		janelaCarga.add(cxQtdRodas);

		janelaCarga.add(rtVelocidadeMax);
		janelaCarga.add(cxVelocidadeMax);

		janelaCarga.add(rtQtdPistoes);
		janelaCarga.add(cxQtdPistoes);

		janelaCarga.add(rtPotencia);
		janelaCarga.add(cxPotencia);

		janelaCarga.add(btCadastrar);
		janelaCarga.add(btLimpar);
		janelaCarga.add(btNovo);
		janelaCarga.add(btSair);

		btCadastrar.addActionListener(cadastroCarga);
		btLimpar.addActionListener(cadastroCarga);
		btNovo.addActionListener(cadastroCarga);
		btSair.addActionListener(cadastroCarga);

		janelaCarga.setLayout(new FlowLayout());
		janelaCarga.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {

		if (evt.getSource().equals(btSair)) {
			janelaCarga.dispose();
		}
		if (evt.getSource().equals(btCadastrar)) {
			cadastrarCarga();
		}
		if (evt.getSource().equals(btLimpar)) {
			limparDados();
		}

	}

	public void cadastrarCarga() {
		Carga c = new Carga();
		System.out.println("\nEntrou no Cadastro de Carga\n");
		c.setTara(Integer.parseInt(cxTara.getText()));
		c.setCargaMax(Integer.parseInt(cxCargaMax.getText()));
		c.setPlaca(cxPlaca.getText());
		c.setMarca(cxMarca.getText());
		c.setModelo(cxModelo.getText());
		c.setCor(cxCor.getText());
		c.setQtdRodas(Integer.parseInt(cxQtdRodas.getText()));
		c.setVelocMaxCarga(Float.parseFloat(cxVelocidadeMax.getText()));
		c.getMotor().setQtdPist(Integer.parseInt(cxQtdPistoes.getText()));
		c.getMotor().setPotencia(Integer.parseInt(cxPotencia.getText()));

		try {
			BDVeiculos.getBDveiculos();
			c = BDVeiculos.setBDCarga(c);
			if (c != null) {
				JOptionPane.showConfirmDialog(null, "Carga cadastrado com sucesso!", "Cadastro de Carga",
						JOptionPane.INFORMATION_MESSAGE);
				limparDados();
			} else {
				throw new VeicExistException();
			}
		} catch (VeicExistException e) {
			e.impErro();
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
		cxTara.requestFocus();
	}

}
