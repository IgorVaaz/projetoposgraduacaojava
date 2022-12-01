import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuPasseio implements ActionListener {

	static JFrame janelaPasseio = new JFrame();
	static MenuPasseio menuPasseio = new MenuPasseio();

	static JButton btCadastrar = new JButton("Cadastrar");
	static JButton btConsultarExcluirPlacaPasseio = new JButton("Consultar/Excluir pela placa");
	static JButton btImprimirExcluirTodosPasseio = new JButton("Imprimir/Excluir todos");
	static JButton btSair = new JButton("Sair");

	public static void main(String[] args) {
		janelaPasseio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaPasseio.setSize(600, 450);
		janelaPasseio.setTitle("Veiculos de Passeio");

		janelaPasseio.add(btCadastrar);
		janelaPasseio.add(btConsultarExcluirPlacaPasseio);
		janelaPasseio.add(btImprimirExcluirTodosPasseio);
		janelaPasseio.add(btSair);

		btCadastrar.addActionListener(menuPasseio);
		btSair.addActionListener(menuPasseio);
		btConsultarExcluirPlacaPasseio.addActionListener(menuPasseio);
		btImprimirExcluirTodosPasseio.addActionListener(menuPasseio);

		janelaPasseio.setLayout(new FlowLayout());
		janelaPasseio.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {

		if (evt.getSource().equals(btCadastrar)) {
			CadastroPasseio.main(null);
		}
		if (evt.getSource().equals(btConsultarExcluirPlacaPasseio)) {
			ConsultarExcluirPlacaPasseio.main(null);
		}
		if(evt.getSource().equals(btImprimirExcluirTodosPasseio)) {
			ImprimirExcluirTodosPasseio.main(null);
		}
		if (evt.getSource().equals(btSair)) {
			janelaPasseio.dispose();
		}

	}

}











