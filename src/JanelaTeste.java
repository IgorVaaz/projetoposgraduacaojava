
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class JanelaTeste implements ActionListener {
    
    static JFrame jan1 = new JFrame();
    
    static JLabel rtl1 = new JLabel();
    static JLabel rtl2 = new JLabel();
    
    static JTextField cx1 = new JTextField(20);
    static JTextField cx2 = new JTextField(20);
    
    static JButton bt1 = new JButton();
    static JButton bt2 = new JButton();
    static JButton bt3 = new JButton();
    
    static JMenuBar mnBar = new JMenuBar();
    static JMenu mnPrinc = new JMenu();
    static JMenu mnSub = new JMenu();
    
    static JMenuItem mnItem1 = new JMenuItem();
    static JMenuItem mnItem2 = new JMenuItem();
    static JMenuItem mnItem3 = new JMenuItem();
    
    static JanelaTeste j = new JanelaTeste();
    
    public static void main(String[] args) {
        
    	jan1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jan1.setSize(600, 450); // largura, altura
        jan1.setTitle("Gestão de Veículos");
        
        rtl1.setText("Nome: ");
        rtl2.setText("Nota: ");
        
        cx1.setText("Deus é bom");
        cx2.setText("O tempo todo!");
        
        bt1.setText("Trocar valores");
        bt2.setText("Limpar");
        bt3.setText("Sair");
        
        mnPrinc.setText("Menu Principal");
        mnSub.setText("SubMenu");
        
        mnItem1.setText("Item 1 - BarraMenu");
        mnItem2.setText("Item 2 - MenuPrincipal");
        mnItem3.setText("Item 3 - SubMenu");
        
        mnBar.add(mnPrinc);
        mnBar.add(mnItem1);
        
        mnPrinc.add(mnSub);
        mnPrinc.add(mnItem2);
        
        mnSub.add(mnItem3);
        
        jan1.setJMenuBar(mnBar);
        
        jan1.add(rtl1);
        jan1.add(cx1);
        
        jan1.add(rtl2);
        jan1.add(cx2);
        
        jan1.add(bt1);
        jan1.add(bt2);
        jan1.add(bt3);
        
        bt1.addActionListener(j);
        bt2.addActionListener(j);
        bt3.addActionListener(j);
        
        mnItem1.addActionListener(j);
        mnItem2.addActionListener(j);
        mnItem3.addActionListener(j);
        
        jan1.setLayout(new FlowLayout());
        jan1.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        
        if (evt.getSource().equals(bt1) || evt.getSource().equals(mnItem3)) {
            String frase = cx1.getText();
            cx1.setText(cx2.getText());
            cx2.setText(frase);
        }
        
        if (evt.getSource().equals(bt2) || evt.getSource().equals(mnItem2)) {
            cx1.setText("");
            cx2.setText("");
            cx1.requestFocus();
        }
        
        if (evt.getSource().equals(bt3) || evt.getSource().equals(mnItem1)) {
            jan1.dispose();
            //System.exit(0);
        }
        
    }
}
