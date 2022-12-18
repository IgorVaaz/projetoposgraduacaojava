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

public class ImprimirExcluirTodosCarga implements ActionListener {

	// inicio Singleton
	private static ImprimirExcluirTodosCarga imprimirExcluirTodosCarga = new ImprimirExcluirTodosCarga();
	private static ImprimirExcluirTodosCarga imprimirExcluirTodosCargaUnica;

	public static ImprimirExcluirTodosCarga getImprimirExcluirTodosPasseio() {
		if (imprimirExcluirTodosCargaUnica == null) {
			imprimirExcluirTodosCargaUnica = new ImprimirExcluirTodosCarga();
		}
		return imprimirExcluirTodosCargaUnica;
	}

	// fim Singleton
	static JFrame janela = new JFrame();
	static JButton btImprimirTodos = new JButton("Imprimir Todos");
	static JButton btExcluirTodos = new JButton("Excluir Todos");
	static JButton btSair = new JButton("Sair");

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
		modelo.addColumn("Tara");
		modelo.addColumn("Carga Max");

		barraRolagem = new JScrollPane(tabela);
		painelFundo.add(barraRolagem);

		janela.add(btImprimirTodos);
		janela.add(btExcluirTodos);
		janela.add(btSair);
		janela.add(painelFundo);

		btImprimirTodos.addActionListener(imprimirExcluirTodosCarga);
		btExcluirTodos.addActionListener(imprimirExcluirTodosCarga);
		btSair.addActionListener(imprimirExcluirTodosCarga);

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
			imprimirTodosCarga();
		}
		if (e.getSource().equals(btExcluirTodos)) {
			excluirTodosCarga();
		}

	}

	public void excluirTodosCarga() {
		BDVeiculos.delTodosBDCarga();
		modelo.setRowCount(0);
		JOptionPane.showConfirmDialog(null, "Todos Cargas Excluidos com Sucesso!", "Sucesso", JOptionPane.OK_OPTION);
	}

	public void imprimirTodosCarga() {

		for (int i = 0; i < BDVeiculos.getListaCarga().size(); i++) { // imprimir cargas
			modelo.addRow(new Object[] { BDVeiculos.getListaCarga().get(i).getPlaca(),
					BDVeiculos.getListaCarga().get(i).getMarca(),
					BDVeiculos.getListaCarga().get(i).getModelo(),
					BDVeiculos.getListaCarga().get(i).getCor(),
					BDVeiculos.getListaCarga().get(i).getQtdRodas(),
					BDVeiculos.getListaCarga().get(i).getVelocMax(),
					BDVeiculos.getListaCarga().get(i).getMotor().getQtdPist(),
					BDVeiculos.getListaCarga().get(i).getMotor().getPotencia(),
					BDVeiculos.getListaCarga().get(i).getTara(),
					BDVeiculos.getListaCarga().get(i).getCargaMax() });
		}

	}

	public void limparTabela() {
		modelo.setRowCount(0);
	}

}
