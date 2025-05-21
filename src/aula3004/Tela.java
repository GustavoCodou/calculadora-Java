package aula3004;
import javax.swing.*;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;


public class Tela extends JFrame{
    private JPanel painel;
    private JPasswordField jpfLogin;
    private JFormattedTextField jftxCep, jftxEstado;
    private JLabel jlLogin, jlCep;
    private JButton jbLogar;
    private JSpinner jspOpcoes, jspIntervalo;
    
    public Tela() /*throws ParseException */{
        painel = new JPanel();
        jpfLogin = new JPasswordField();
        jlLogin = new JLabel("Login:");
        jlCep = new JLabel("Cep:");
        jbLogar = new JButton("Logar:"); 
        
        try{
            jftxCep = new JFormattedTextField(new MaskFormatter("##.###-###"));
            jftxEstado = new JFormattedTextField(new MaskFormatter("UU"));
        }catch(ParseException e){
            System.out.println(e.getMessage());
        }
        
        jspOpcoes = new JSpinner(new SpinnerListModel(new String[]{"Opção 1", "Opção 2", "Opção 3"}));
        jspIntervalo = new JSpinner(new SpinnerNumberModel(50,0,100,1));
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
        jlLogin.setBounds(10,10,90,20);
        painel.add(jlLogin);
        jpfLogin.setBounds(70,10,90,20);
        painel.add(jpfLogin);
        jbLogar.setBounds(40,30,90,20);
        
        jbLogar.addActionListener(evento ->{
            char[] retorno = jpfLogin.getPassword();
            String senha = new String(retorno);
            System.out.println("A senha digitado foi:"+senha);
            System.out.println("CEP: "+jftxCep.getText());
            System.out.println("Intervalo JSpinner" + jspIntervalo.getValue().toString());
        });
        
        painel.add(jbLogar);
        jlCep.setBounds(10,70,50,20);
        painel.add(jlCep);
        jftxCep.setBounds(65,70,100,20);
        painel.add(jftxCep);
        jftxEstado.setBounds(60,70,100,20);
        painel.add(jftxEstado);
        jspOpcoes.setBounds(60,100,100,20);
        painel.add(jspOpcoes);
        jspIntervalo.setBounds(100,130,80,20);
        painel.add(jspIntervalo);
    }
}
