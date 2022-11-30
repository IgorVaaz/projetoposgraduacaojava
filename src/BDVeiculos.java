
import java.util.ArrayList;
import java.util.List;

public class BDVeiculos {

    private static List<Passeio> BDPasseio = new ArrayList<Passeio>();
    private static List<Carga> BDCarga = new ArrayList<Carga>();
    
    //Inicio singleton
    private static BDVeiculos bdVeiculosUnico;
    private BDVeiculos() {}
    public static BDVeiculos getBDveiculos() {
    	if(bdVeiculosUnico == null) {
    		bdVeiculosUnico = new BDVeiculos();
    	}
    	return bdVeiculosUnico;
    }
    //Fim singleton

    public static Passeio consPlacaPasseio(Passeio p) { // consultar placa passeio
        for (int i = 0; i < BDPasseio.size(); i++) {
            if (p.getPlaca().equalsIgnoreCase(BDPasseio.get(i).getPlaca())) {
                return BDPasseio.get(i);
            }
        }
        return null;
    }

    public static Passeio setBDPasseio(Passeio p) { // cadastrar passeio
        if (consPlacaPasseio(p) == null) {
            BDPasseio.add(p);
            return p;
        } else {
            return null;

        }
    }

    public static Carga consPlacaCarga(Carga c) { // consulta placa carga
        for (int i = 0; i < BDCarga.size(); i++) {
            if (c.getPlaca().equalsIgnoreCase(BDCarga.get(i).getPlaca())) {
                return BDCarga.get(i);
            }
        }
        return null;
    }

    public static Carga setBDCarga(Carga c) { // cadastrar carga
        if (consPlacaCarga(c) == null) {
            BDCarga.add(c);
            return c;
        } else {
            return null;
        }
    }

    public static void impUmaCarga(Carga c) {
        System.out.println("\n-----------------------------");
        System.out.println("Carga Max: " + c.getCargaMax());
        System.out.println("Tara: " + c.getTara());
        System.out.println("Placa: " + c.getPlaca());
        System.out.println("Marca: " + c.getMarca());
        System.out.println("Modelo: " + c.getModelo());
        System.out.println("Cor: " + c.getCor());
        System.out.println("VelocidadeMaxima " + c.getVelocMax());
        System.out.println("Qtd Rodas: " + c.getQtdRodas());
        System.out.println("Potencia Motor: " + c.getMotor().getPotencia());
        System.out.println("Qtd pistao Motor: " + c.getMotor().getQtdPist());
        System.out.println("Soma valores: " + c.calcular());
        c.calcVel(c.getVelocMax());
    }

    public static void impListaCarga() {
        for (int i = 0; i < BDCarga.size(); i++) {
            System.out.println("\n-----------------------------");
            System.out.println("Carga do endereco: " + i + " do BDCcarga.get(i)");
            System.out.println("Carga Max: " + BDCarga.get(i).getCargaMax());
            System.out.println("Tara: " + BDCarga.get(i).getTara());
            System.out.println("Placa: " + BDCarga.get(i).getPlaca());
            System.out.println("Marca: " + BDCarga.get(i).getMarca());
            System.out.println("Modelo: " + BDCarga.get(i).getModelo());
            System.out.println("Cor: " + BDCarga.get(i).getCor());
            System.out.println("VelocidadeMaxima " + BDCarga.get(i).getVelocMax());
            System.out.println("Qtd Rodas: " + BDCarga.get(i).getQtdRodas());
            System.out.println("Potencia Motor: " + BDCarga.get(i).getMotor().getPotencia());
            System.out.println("Qtd pistao Motor: " + BDCarga.get(i).getMotor().getQtdPist());
            System.out.println("Soma valores: " + BDCarga.get(i).calcular());
            BDCarga.get(i).calcVel(BDCarga.get(i).getVelocMax());
        }
    }

    public static void impUmPasseio(Passeio p) {
        System.out.println("\n-----------------------------");
        System.out.println("Qtde de Passageiros: " + p.getQtdPassageiros());
        System.out.println("Placa: " + p.getPlaca());
        System.out.println("Marca: " + p.getMarca());
        System.out.println("Modelo: " + p.getModelo());
        System.out.println("Cor: " + p.getCor());
        System.out.println("Qtd Rodas: " + p.getQtdRodas());
        System.out.println("VelocidadeMaxima: " + p.getVelocMax());
        System.out.println("Qtd Pistoes do motor: " + p.getMotor().getQtdPist());
        System.out.println("Potencia do motor: " + p.getMotor().getPotencia());
        System.out.println("Qtde de Letras: " + p.calcular());
        p.calcVel(p.getVelocMax());
    }

    public static void impListaPasseio() {
        for (int i = 0; i < BDPasseio.size(); i++) { // imprimir passeios
            System.out.println("\n-----------------------------");
            System.out.println("Passeio do endereco: " + i + " do BDPasseio.get(i)");
            System.out.println("Qtde de Passageiros: " + BDPasseio.get(i).getQtdPassageiros());
            System.out.println("Placa: " + BDPasseio.get(i).getPlaca());
            System.out.println("Marca: " + BDPasseio.get(i).getMarca());
            System.out.println("Modelo: " + BDPasseio.get(i).getModelo());
            System.out.println("Cor: " + BDPasseio.get(i).getCor());
            System.out.println("Qtd Rodas: " + BDPasseio.get(i).getQtdRodas());
            System.out.println("VelocidadeMaxima: " + BDPasseio.get(i).getVelocMax());
            System.out.println("Qtd Pistoes do motor: " + BDPasseio.get(i).getMotor().getQtdPist());
            System.out.println("Potencia do motor: " + BDPasseio.get(i).getMotor().getPotencia());
            System.out.println("Qtde de Letras: " + BDPasseio.get(i).calcular());
            BDPasseio.get(i).calcVel(BDPasseio.get(i).getVelocMax());
        }
    }

    public static void delBDPasseio(Passeio p) { // deletar passeio
        BDPasseio.remove(p);
    }

    public static void delBDCarga(Carga c) { // deletar carga
        BDCarga.remove(c);
    }

    public static List<Passeio> getListaPasseio() {
        return BDPasseio; // retorna lista
    }

    public static List<Carga> getListaCarga() {
        return BDCarga; // retorna lista
    }

}
