package aula3004;
import javax.swing.*;



/**
 *
 * @author Cris
 */
public class TelaCOMBO extends JFrame{
    private JPanel painel;
    private JComboBox jcbEstados;
    private JButton jbAdicionar,jbImprimir;
    private JLabel jlEstados;
    private String[] estados = {"Acre", "Minas Gerais", "Rio de Janeiro", "São Paulo"};
    public TelaCOMBO(){
        painel = new JPanel();
        jbAdicionar = new JButton("Adicionar");
        jbImprimir = new JButton("Imprimir");
        jcbEstados = new JComboBox(estados);
        jlEstados = new JLabel("Selecione o seu estado:");
    }
    public void configurarJanela(){
        setVisible(true);
        setTitle("Aula 30/04");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setResizable(false);
        setLocation(600,300);
        add(painel);
        configurarPainel();
    }
    public void configurarPainel(){
        painel.setLayout(null);
        jlEstados.setBounds(10,10,150,20);
        painel.add(jlEstados);
        jcbEstados.setBounds(165,10,100,20);
        painel.add(jcbEstados);
        jbImprimir.setBounds(55,40,90,20);
        jbImprimir.addActionListener(evento ->{
            String estado = jcbEstados.getSelectedItem().toString();
            int indice = jcbEstados.getSelectedIndex();
            JOptionPane.showMessageDialog(this, "Você selecionou o índice: "+indice
                    + "\nque corresponde ao estado: "+ estado);
        });
        painel.add(jbImprimir);
        jbAdicionar.setBounds(155,40,90,20);
        jbAdicionar.addActionListener(evento ->{
            String estado = JOptionPane.showInputDialog(this,"Digite um estado a ser adicionado: ");
            jcbEstados.addItem(estado);
        });
        painel.add(jbAdicionar);
        
    }
}
