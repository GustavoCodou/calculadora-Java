
package aula3004;

import java.awt.Color;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Cris
 */
public class TelaTABELA extends JFrame{
    private JPanel painel;
    private JTable jtProduto;
    private DefaultTableModel modeloProduto;
    private JScrollPane jspProduto;
    private JButton jbAdicionar, jbImprimir;
    public TelaTABELA(){
        painel = new JPanel();
        modeloProduto = new DefaultTableModel(new String[]{"Descrição","Estoque","Preço"},0);
        jtProduto = new JTable(modeloProduto);
        //jtProduto = new JTable(new String[][]{{"1","1","1"},{"2","2","2"}},new String[]{"Descrição","Estoque","Preço"});
        //jtProduto = new JTable(new String[][]{},new String[]{"Descrição","Estoque","Preço"});
        jspProduto = new JScrollPane(jtProduto);
        jbAdicionar = new JButton("Adicionar");
        jbImprimir = new JButton("Imprimir");
        
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
        jspProduto.setBounds(20,10,190,100);
        painel.add(jspProduto);
        jbAdicionar.setBounds(20,115,90,20);
        jbAdicionar.addActionListener(evento ->{
            String nome = JOptionPane.showInputDialog(this,"Digite o nome de um produto");
            modeloProduto.addRow(new String[]{nome,"10","2,99"});
        });
        painel.add(jbAdicionar);
        jbImprimir.setBounds(115,115,90,20);
        jbImprimir.addActionListener(evento->{
            int linha = jtProduto.getSelectedRow();
            JOptionPane.showMessageDialog(this,"Linha selecionada: "+ linha
                                                +"\nDescrição: "+ jtProduto.getValueAt(linha, 0)
                                                +"\nEstoque: "+ jtProduto.getValueAt(linha, 1)
                                                +"\nPreço: "+jtProduto.getValueAt(linha, 2));
        });
        painel.add(jbImprimir);
    }
}
