package aula3004;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
/**
 *
 * @author Cris
 */
public class TelaTEXTAREA extends JFrame{
    private JPanel painel;
    private JTextArea jtxaObservacao;
    private JScrollPane jspObservacao;
    private JButton jbFormatar, jbImprimir;
    
    public TelaTEXTAREA(){
        painel = new JPanel();
        jtxaObservacao = new JTextArea();
        jspObservacao = new JScrollPane(jtxaObservacao);
        jbFormatar = new JButton("Formatar");
        jbImprimir = new JButton("Imprimir");
    }
    public void configurarJanela(){
        setVisible(true);
        setTitle("Aula 30/04");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        //setResizable(false);
        setLocation(600,300);
        add(painel);
        configurarPainel();
    }
    public void configurarPainel(){
       painel.setLayout(null);
       jspObservacao.setBounds(10,10,270,100);
       jspObservacao.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
       jspObservacao.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
       jtxaObservacao.setLineWrap(true);
       painel.add(jspObservacao);
       jbFormatar.setBounds(40,120,90,20);
       jbFormatar.addActionListener(evento ->{
           jtxaObservacao.setFont(new Font("Arial",Font.BOLD,14));
           jtxaObservacao.setForeground(Color.MAGENTA);
       });
       painel.add(jbFormatar);
       jbImprimir.setBounds(135,120,90,20);
       jbImprimir.addActionListener(evento ->{
           JOptionPane.showMessageDialog(this, "O texto escrito foi: \n"
                                                        +jtxaObservacao.getText());
       });
       painel.add(jbImprimir);
       
    }
}
