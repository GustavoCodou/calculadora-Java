package aula3004;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Calculator extends JFrame {
    private JPanel painelBotoes;
    private JButton[] botoes;
    private JTextArea jtxaObservacao;
    private JScrollPane jspObservacao;

    private String[] caracteres = {
        "0", " ", "X!", "10^X", "=",
        "1", "2", "3", "x^3", "+",
        "4", "5", "6", "x2", "-",
        "7", "8", "9", "X^Y", "*",
        "AC/C", "+/-", "%", "RAIZ Q", "/"
    };

    public Calculator() {
        // Criação dos componentes
        painelBotoes = new JPanel();
        botoes = new JButton[25];
        for (int i = 0; i < 25; i++) {
            botoes[i] = new JButton(caracteres[i]);
        }

        jtxaObservacao = new JTextArea(1, 20);
        jtxaObservacao.setLineWrap(true);
        jtxaObservacao.setWrapStyleWord(true);
        jtxaObservacao.setFont(new Font("Arial", Font.PLAIN, 30));

        // Corrigido: Crie e configure o JScrollPane apenas uma vez
        jspObservacao = new JScrollPane(jtxaObservacao);
        jspObservacao.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jspObservacao.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        LineBorder border = new LineBorder(Color.LIGHT_GRAY, 20);
        jspObservacao.setBorder(border);

        configurarPainel();
        configurarJanela();
    }

    public void configurarJanela() {
        setTitle("Aula 30/04");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setResizable(false);
        setLocation(600, 300);
        setLayout(new BorderLayout());

        add(jspObservacao, BorderLayout.NORTH);
        add(painelBotoes, BorderLayout.CENTER);

        setVisible(true);
    }

    public void configurarPainel() {
        painelBotoes.setLayout(new GridLayout(5, 5));
        for (int i = 0; i < 25; i++) {
            painelBotoes.add(botoes[i]);
        }


        botoes[0].addActionListener((ActionEvent e) -> {
            jtxaObservacao.append("0");
        });

        botoes[5].addActionListener((ActionEvent e) -> {
            jtxaObservacao.append("1");
        });

        botoes[6].addActionListener((ActionEvent e) -> {
            jtxaObservacao.append("2");
        });

        botoes[7].addActionListener((ActionEvent e) -> {
            jtxaObservacao.append("3");
        });

        botoes[10].addActionListener((ActionEvent e) -> {
            jtxaObservacao.append("4");
        });

        botoes[11].addActionListener((ActionEvent e) -> { 
            jtxaObservacao.append("5");
        });

        botoes[12].addActionListener((ActionEvent e) -> {
            jtxaObservacao.append("6");
        });

        botoes[15].addActionListener((ActionEvent e) -> { 
            jtxaObservacao.append("7");
        });

        botoes[16].addActionListener((ActionEvent e) -> { 
            jtxaObservacao.append("8");
        });

        botoes[17].addActionListener((ActionEvent e) -> {
            jtxaObservacao.append("9");
        });
        

        botoes[20].addActionListener((ActionEvent e) -> { 
            jtxaObservacao.setText("");
        });
        
    }

    
}