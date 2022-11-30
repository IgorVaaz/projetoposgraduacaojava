
import java.io.IOException;

import javax.swing.JOptionPane;

public class VeicExistException extends IOException {

	VeicExistException() {
		JOptionPane.showConfirmDialog(null,
				"Ja existe um veiculo com esta placa!!",
				"Erro no Cadastro de Passeio",
				JOptionPane.ERROR_MESSAGE
				);
	}

	public void impErro() {
		JOptionPane.showConfirmDialog(null, "Placa ja utilizada!", "Erro no Cadastro de Passeio",
				JOptionPane.WARNING_MESSAGE);
	}
}
