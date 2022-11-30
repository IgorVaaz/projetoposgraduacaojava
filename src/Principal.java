import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Principal implements ActionListener {

	static JFrame janelaPrincipal = new JFrame();
	static Principal principal = new Principal();

	static JButton btPasseio = new JButton();
	static JButton btCarga = new JButton();

	public static void main(String[] args) {
		janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaPrincipal.setSize(600, 450);
		janelaPrincipal.setTitle("Gestão de Veículos");

		btPasseio.setText("Passeio");
		btCarga.setText("Carga");

		janelaPrincipal.add(btPasseio);
		janelaPrincipal.add(btCarga);

		btPasseio.addActionListener(principal);
		btCarga.addActionListener(principal);

		janelaPrincipal.setLayout(new FlowLayout());
		janelaPrincipal.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {

		if (evt.getSource().equals(btPasseio)) {
			MenuPasseio.main(null);
		}
		if (evt.getSource().equals(btCarga)) {
			MenuCarga.main(null);
		}

	}

}
