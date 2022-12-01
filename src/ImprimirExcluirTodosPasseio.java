import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ImprimirExcluirTodosPasseio implements ActionListener {

	// inicio Singleton
	private static ImprimirExcluirTodosPasseio imprimirExcluirTodosPasseio = new ImprimirExcluirTodosPasseio();
	private static ImprimirExcluirTodosPasseio imprimirExcluirTodosPasseioUnico;

	public static ImprimirExcluirTodosPasseio getImprimirExcluirTodosPasseio() {
		if (imprimirExcluirTodosPasseioUnico == null) {
			imprimirExcluirTodosPasseioUnico = new ImprimirExcluirTodosPasseio();
		}
		return imprimirExcluirTodosPasseioUnico;
	}

	// fim Singleton
	static JFrame janela = new JFrame();
	static JButton btImprimirTodos = new JButton("Imprimir Todos");
	static JButton btExcluirTodos = new JButton("Excluir Todos");
	static JButton btSair = new JButton("Sair");

	static Object[][] dados = { { "Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com" },
			{ "João da Silva", "48 8890-3345", "joaosilva@hotmail.com" },
			{ "Pedro Cascaes", "48 9870-5634", "pedrinho@gmail.com" } };
	static JTable tabela;

	static JPanel painelFundo;
	static JScrollPane barraRolagem;
	static DefaultTableModel modelo = new DefaultTableModel();

	public static void main(String[] args) {
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(600, 450);
		janela.setTitle("Imprimir/Excluir Todos");

		painelFundo = new JPanel();
		painelFundo.setLayout(new GridLayout(1, 1));
		tabela = new JTable(modelo);
		modelo.addColumn("Placa");
		modelo.addColumn("Marca");
		modelo.addColumn("Modelo");
		modelo.addColumn("Cor");
		modelo.addColumn("Qtd Rodas");
		modelo.addColumn("Veloc Max");
		modelo.addColumn("Qtd Pist");
		modelo.addColumn("Potencia");
		modelo.addColumn("Qtd Passag");

		barraRolagem = new JScrollPane(tabela);
		painelFundo.add(barraRolagem);

		janela.add(btImprimirTodos);
		janela.add(btExcluirTodos);
		janela.add(btSair);
		janela.add(painelFundo);

		btImprimirTodos.addActionListener(imprimirExcluirTodosPasseio);
		btExcluirTodos.addActionListener(imprimirExcluirTodosPasseio);
		btSair.addActionListener(imprimirExcluirTodosPasseio);

		janela.setLayout(new FlowLayout());
		janela.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btSair)) {
			janela.dispose();
		}
		if (e.getSource().equals(btImprimirTodos)) {
			limparTabela();
			imprimirTodosPasseio();
		}
		if (e.getSource().equals(btExcluirTodos)) {
			excluirTodosPasseio();
		}

	}

	public void excluirTodosPasseio() {
		BDVeiculos.delTodosBDPasseio();
		modelo.setRowCount(0);
		JOptionPane.showConfirmDialog(
				null,
				"Todos Passeios Excluidos com Sucesso!",
				"Sucesso",
				JOptionPane.OK_OPTION
				);
	}

	public void imprimirTodosPasseio() {

		for (int i = 0; i < BDVeiculos.getListaPasseio().size(); i++) { // imprimir passeios
			modelo.addRow(new Object[] { BDVeiculos.getListaPasseio().get(i).getPlaca(),
					BDVeiculos.getListaPasseio().get(i).getMarca(), BDVeiculos.getListaPasseio().get(i).getModelo(),
					BDVeiculos.getListaPasseio().get(i).getCor(), BDVeiculos.getListaPasseio().get(i).getQtdRodas(),
					BDVeiculos.getListaPasseio().get(i).getVelocMax(),
					BDVeiculos.getListaPasseio().get(i).getMotor().getQtdPist(),
					BDVeiculos.getListaPasseio().get(i).getMotor().getPotencia(),
					BDVeiculos.getListaPasseio().get(i).getQtdPassageiros(), });
		}
		
	}

	public void limparTabela() {
		modelo.setRowCount(0);
	}
}
