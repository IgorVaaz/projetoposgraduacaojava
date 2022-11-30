import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuCarga implements ActionListener {

	static JFrame janelaCarga = new JFrame();
	static MenuCarga menuPasseio = new MenuCarga();
	
	static JButton btCadastrar = new JButton("Cadastrar");
	static JButton btConsultarExcluirPlaca = new JButton("Consultar/Excluir pela placa");
	static JButton btImprimirExcluirTodos = new JButton("Imprimir/Excluir todos");
	static JButton btSair = new JButton("Sair");
	
	public static void main(String[] args) {
		janelaCarga.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaCarga.setSize(600, 450);
		janelaCarga.setTitle("Veiculos de Carga");
		
		janelaCarga.add(btCadastrar);
		janelaCarga.add(btConsultarExcluirPlaca);
		janelaCarga.add(btImprimirExcluirTodos);
		janelaCarga.add(btSair);
		
		btSair.addActionListener(menuPasseio);
		
		janelaCarga.setLayout(new FlowLayout());
		janelaCarga.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {

		if(evt.getSource().equals(btSair)) {
			janelaCarga.dispose();
		}
		
	}

}
