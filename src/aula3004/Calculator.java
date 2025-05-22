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

    private float numero1 = 0;
    private float numero2 = 0;
    private int opcao = 0; 
    private boolean novoNumero = true;

    private String[] caracteres = {
        "0", " ", "X!", "10^X", "=",
        "1", "2", "3", "x^3", "+",
        "4", "5", "6", "x^2", "-",
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

        botoes[0].addActionListener((ActionEvent e) -> { appendDigit("0"); });
        botoes[5].addActionListener((ActionEvent e) -> { appendDigit("1"); });
        botoes[6].addActionListener((ActionEvent e) -> { appendDigit("2"); });
        botoes[7].addActionListener((ActionEvent e) -> { appendDigit("3"); });
        botoes[10].addActionListener((ActionEvent e) -> { appendDigit("4"); });
        botoes[11].addActionListener((ActionEvent e) -> { appendDigit("5"); });
        botoes[12].addActionListener((ActionEvent e) -> { appendDigit("6"); });
        botoes[15].addActionListener((ActionEvent e) -> { appendDigit("7"); });
        botoes[16].addActionListener((ActionEvent e) -> { appendDigit("8"); });
        botoes[17].addActionListener((ActionEvent e) -> { appendDigit("9"); });

        // botao de +
        botoes[9].addActionListener((ActionEvent e) -> {
            try {
                String textoAtual = jtxaObservacao.getText();
                if (!textoAtual.isEmpty()) {
                    numero1 = Float.parseFloat(textoAtual);
                    opcao = 1;
                    jtxaObservacao.setText("");
                    novoNumero = true;
                }
            } catch (NumberFormatException ex) {
                jtxaObservacao.setText("Erro!");
            }
        });
        
        // botao de - 
        botoes[14].addActionListener((ActionEvent e) -> {
            try {
                String textoAtual = jtxaObservacao.getText();
                if (!textoAtual.isEmpty()) {
                    numero1 = Float.parseFloat(textoAtual);
                    opcao = 2;
                    jtxaObservacao.setText("");
                    novoNumero = true;
                }
            } catch (NumberFormatException ex) {
                jtxaObservacao.setText("Erro!");
            }
        });
        
        // botao de * 
        botoes[19].addActionListener((ActionEvent e) -> {
            try {
                String textoAtual = jtxaObservacao.getText();
                if (!textoAtual.isEmpty()) {
                    numero1 = Float.parseFloat(textoAtual);
                    opcao = 3;
                    jtxaObservacao.setText("");
                    novoNumero = true;
                }
            } catch (NumberFormatException ex) {
                jtxaObservacao.setText("Erro!");
            }
        });
        
        // botao de /
        botoes[24].addActionListener((ActionEvent e) -> {
            try {
                String textoAtual = jtxaObservacao.getText();
                if (!textoAtual.isEmpty()) {
                    numero1 = Float.parseFloat(textoAtual);
                    opcao = 5;
                    jtxaObservacao.setText("");
                    novoNumero = true;
                }
            } catch (NumberFormatException ex) {
                jtxaObservacao.setText("Erro!");
            }
        });
        
        // botao de +/-
        botoes[21].addActionListener((ActionEvent e) -> {
            try {
                String textoAtual = jtxaObservacao.getText();
                if (!textoAtual.isEmpty()) {
                    float numero=0;
                    numero = Float.parseFloat(textoAtual);
                    numero= numero *-1;

                    jtxaObservacao.setText(String.valueOf(numero));
                    novoNumero = true; 
                    opcao = 0; 
                }
            } catch (NumberFormatException ex) {
                jtxaObservacao.setText("Erro!");
            }
        });   
        
        // botao de raiz quadrada
        botoes[23].addActionListener((ActionEvent e) -> {
            try {
                String textoAtual = jtxaObservacao.getText();
                if (!textoAtual.isEmpty()) {
                    float numero=0;
                    numero = Float.parseFloat(textoAtual);
                    numero= (float) Math.sqrt(numero);

                    jtxaObservacao.setText(String.valueOf(numero));
                    novoNumero = true; 
                    opcao = 0; 
                }
            } catch (NumberFormatException ex) {
                jtxaObservacao.setText("Erro!");
            }
        });

        
        // Botao de fatorial
        botoes[2].addActionListener((ActionEvent e) -> {
            try {
                String textoAtual = jtxaObservacao.getText();
                if (!textoAtual.isEmpty()) {
                    float numero=0;
                    numero = Float.parseFloat(textoAtual);
                    int contador= (int) numero;
                    numero=1;
                    while(contador!=0){
                        numero=numero*contador;
                        contador--;
                    }

                    jtxaObservacao.setText(String.valueOf(numero));
                    novoNumero = true; 
                    opcao = 0; 
                }
            } catch (NumberFormatException ex) {
                jtxaObservacao.setText("Erro!");
            }
        });
        
        // Botao de x elevado ^ 3
        botoes[8].addActionListener((ActionEvent e) -> {
            try {
                String textoAtual = jtxaObservacao.getText();
                if (!textoAtual.isEmpty()) {
                    float numero=0;
                    numero = Float.parseFloat(textoAtual);
                    numero= numero * numero * numero;

                    jtxaObservacao.setText(String.valueOf(numero));
                    novoNumero = true; 
                    opcao = 0; 
                }
            } catch (NumberFormatException ex) {
                jtxaObservacao.setText("Erro!");
            }
        });
           
        // botao de =
        botoes[4].addActionListener((ActionEvent e) -> {
            try {
                String textoAtual = jtxaObservacao.getText();
                if (!textoAtual.isEmpty()) {
                    numero2 = Float.parseFloat(textoAtual);
                    float resultado = 0;

                    switch (opcao) {
                        case 1 -> resultado = numero1 + numero2;
                        case 2 -> resultado = numero1 - numero2;
                        case 3 -> resultado = numero1 * numero2;
                        case 4 -> resultado = (float) Math.pow(numero1, numero2);
                        case 5 -> resultado = numero2 / numero1;
                        default -> {
                        }
                    }

                    jtxaObservacao.setText(String.valueOf(resultado));
                    numero1 = resultado; 
                    novoNumero = true; 
                    opcao = 0; 
                }
            } catch (NumberFormatException ex) {
                jtxaObservacao.setText("Erro!");
            }
        });
        

        // Botao A/C
        botoes[20].addActionListener((ActionEvent e) -> {
            jtxaObservacao.setText("");
            numero1 = 0;
            numero2 = 0;
            opcao = 0;
            novoNumero = true; 
        });


    }


    private void appendDigit(String digit) {
        if (novoNumero) {
            jtxaObservacao.setText(digit); 
            novoNumero = false;
        } else {
            jtxaObservacao.append(digit); 
        }
    }

   
}