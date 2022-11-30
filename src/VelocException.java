
import java.io.IOException;

import javax.swing.JOptionPane;

public class VelocException extends IOException {

	VelocException() {
		JOptionPane.showConfirmDialog(null,
				"A velocidade maxima esta fora dos limites brasileiros!",
				"Alerta de Velocidade Maxima",
				JOptionPane.WARNING_MESSAGE
				);
	}

	public void impErro() {
		JOptionPane.showConfirmDialog(
				null,
				"Velocidade maxima acima do permitido!",
				"Alerta de Velocidade Maxima",
				JOptionPane.WARNING_MESSAGE
				);
	}
}
