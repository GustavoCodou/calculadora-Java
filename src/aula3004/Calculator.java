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
        // jtxaObservacao.setEditable(false); // Opcional: para não permitir que o usuário digite diretamente

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

        // --- ActionListeners para os botões de números (mais genérico) ---
        // Poderíamos usar um loop para simplificar a adição de listeners para todos os números
        // Mas para seguir seu estilo atual, vou continuar adicionando um a um.

        // Botões de 0 a 9
        // A flag `novoNumero` ajuda a sobrescrever o display quando um novo número deve começar
        botoes[0].addActionListener((ActionEvent e) -> { appendDigit("0"); }); // "0"
        botoes[5].addActionListener((ActionEvent e) -> { appendDigit("1"); }); // "1"
        botoes[6].addActionListener((ActionEvent e) -> { appendDigit("2"); }); // "2"
        botoes[7].addActionListener((ActionEvent e) -> { appendDigit("3"); }); // "3"
        botoes[10].addActionListener((ActionEvent e) -> { appendDigit("4"); }); // "4"
        botoes[11].addActionListener((ActionEvent e) -> { appendDigit("5"); }); // "5"
        botoes[12].addActionListener((ActionEvent e) -> { appendDigit("6"); }); // "6"
        botoes[15].addActionListener((ActionEvent e) -> { appendDigit("7"); }); // "7"
        botoes[16].addActionListener((ActionEvent e) -> { appendDigit("8"); }); // "8"
        botoes[17].addActionListener((ActionEvent e) -> { appendDigit("9"); }); // "9"

        // Botão para o ponto decimal (se quiser adicionar)
        // botes[?] .addActionListener((ActionEvent e) -> { appendDigit("."); });


        // --- Botão de SOMA "+" ---
        botoes[9].addActionListener((ActionEvent e) -> {
            try {
                String textoAtual = jtxaObservacao.getText();
                if (!textoAtual.isEmpty()) {
                    numero1 = Float.parseFloat(textoAtual); // Pega o primeiro número
                    opcao = 1; // Define a operação como soma
                    jtxaObservacao.setText(""); // IMPORTANTE: Limpa o display para o próximo número
                    novoNumero = true; // Garante que o próximo dígito comece um novo número
                }
            } catch (NumberFormatException ex) {
                jtxaObservacao.setText("Erro!");
            }
        });

        // --- Botão de IGUAL "=" ---
        botoes[4].addActionListener((ActionEvent e) -> {
            try {
                String textoAtual = jtxaObservacao.getText();
                if (!textoAtual.isEmpty()) {
                    numero2 = Float.parseFloat(textoAtual); // Pega o segundo número
                    float resultado = 0;

                    if (opcao == 1) { // Se a opção for soma
                        resultado = numero1 + numero2;
                    }
                    // Adicionar mais else if para outras operações (subtração, multiplicação, divisão)

                    jtxaObservacao.setText(String.valueOf(resultado)); // Define o resultado no display
                    numero1 = resultado; 
                    novoNumero = true; 
                    opcao = 0; 
                }
            } catch (NumberFormatException ex) {
                jtxaObservacao.setText("Erro!");
            }
        });

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