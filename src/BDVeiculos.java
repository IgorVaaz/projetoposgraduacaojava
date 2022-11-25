import java.util.ArrayList;
import java.util.List;

public class BDVeiculos {

	List<Passeio> listaPasseio = new ArrayList<>(5);
	List<Carga> listaCarga = new ArrayList<>(5);

	public BDVeiculos(List<Passeio> listaPasseio, List<Carga> listaCarga) {
		super();
		this.listaPasseio = listaPasseio;
		this.listaCarga = listaCarga;
	}

	public List<Passeio> getListaPasseio() {
		return listaPasseio;
	}

	public void setListaPasseio(List<Passeio> listaPasseio) {
		this.listaPasseio = listaPasseio;
	}

	public List<Carga> getListaCarga() {
		return listaCarga;
	}

	public void setListaCarga(List<Carga> listaCarga) {
		this.listaCarga = listaCarga;
	}

}
