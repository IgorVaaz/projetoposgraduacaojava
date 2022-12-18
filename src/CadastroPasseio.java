
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CadastroPasseio implements ActionListener {

	static JFrame janelaPasseio = new JFrame();

	// aplicando Singleton
	private static CadastroPasseio cadastroPasseio = new CadastroPasseio();

	private static CadastroPasseio cadastroPasseioUnico;

	public static CadastroPasseio getCadastroPasseio() {
		if (cadastroPasseioUnico == null) {
			cadastroPasseioUnico = new CadastroPasseio();
		}
		return cadastroPasseioUnico;
	}
	// finalizou singleton

	static JButton btCadastrar = new JButton("Cadastrar");
	static JButton btLimpar = new JButton("Limpar");
	static JButton btNovo = new JButton("Novo");
	static JButton btSair = new JButton("Sair");

	static JLabel rtQtdPassageiro = new JLabel("Qtd. Passageiros: ");
	static JTextField cxQtdPassageiro = new JTextField(4);

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
		janelaPasseio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaPasseio.setSize(600, 450);
		janelaPasseio.setTitle("Cadastro de Passeio");

		janelaPasseio.add(rtQtdPassageiro);
		janelaPasseio.add(cxQtdPassageiro);

		janelaPasseio.add(rtPlaca);
		janelaPasseio.add(cxPlaca);

		janelaPasseio.add(rtMarca);
		janelaPasseio.add(cxMarca);

		janelaPasseio.add(rtModelo);
		janelaPasseio.add(cxModelo);

		janelaPasseio.add(rtCor);
		janelaPasseio.add(cxCor);

		janelaPasseio.add(rtQtdRodas);
		janelaPasseio.add(cxQtdRodas);

		janelaPasseio.add(rtVelocidadeMax);
		janelaPasseio.add(cxVelocidadeMax);

		janelaPasseio.add(rtQtdPistoes);
		janelaPasseio.add(cxQtdPistoes);

		janelaPasseio.add(rtPotencia);
		janelaPasseio.add(cxPotencia);

		janelaPasseio.add(btCadastrar);
		janelaPasseio.add(btLimpar);
		janelaPasseio.add(btNovo);
		janelaPasseio.add(btSair);

		btCadastrar.addActionListener(cadastroPasseio);
		btLimpar.addActionListener(cadastroPasseio);
		btNovo.addActionListener(cadastroPasseio);
		btSair.addActionListener(cadastroPasseio);

		janelaPasseio.setLayout(new FlowLayout());
		janelaPasseio.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {

		if (evt.getSource().equals(btSair)) {
			janelaPasseio.dispose();
		}
		if (evt.getSource().equals(btCadastrar)) {
			cadastrarPasseio();
		}
		if (evt.getSource().equals(btLimpar)) {
			limparDados();
		}

	}

	public void cadastrarPasseio() {
		Passeio p = new Passeio();
		System.out.println("\nEntrou no Cadastro de PASSEIO\n");
		p.setQtdPassageiros(Integer.parseInt(cxQtdPassageiro.getText()));
		p.setPlaca(cxPlaca.getText());
		p.setMarca(cxMarca.getText());
		p.setModelo(cxModelo.getText());
		p.setCor(cxCor.getText());
		p.setQtdRodas(Integer.parseInt(cxQtdRodas.getText()));
		p.setVelocMaxPasseio(Float.parseFloat(cxVelocidadeMax.getText()));
		p.getMotor().setQtdPist(Integer.parseInt(cxQtdPistoes.getText()));
		p.getMotor().setPotencia(Integer.parseInt(cxPotencia.getText()));

		try {
			BDVeiculos.getBDveiculos();
			p = BDVeiculos.setBDPasseio(p);
			if (p != null) {
				JOptionPane.showConfirmDialog(null, "Passeio cadastrada com sucesso!", "Cadastro de Passeio",
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
		cxQtdPassageiro.setText("");
		cxPlaca.setText("");
		cxMarca.setText("");
		cxModelo.setText("");
		cxCor.setText("");
		cxQtdRodas.setText("");
		cxVelocidadeMax.setText("");
		cxQtdPistoes.setText("");
		cxPotencia.setText("");
		cxQtdPassageiro.requestFocus();
	}

}
