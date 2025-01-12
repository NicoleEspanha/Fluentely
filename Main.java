import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> criarJanelaPrincipal());
    }

    // CRIANDO A JANELA PRINCIPAL (POST IT AMARELO)
    private static void criarJanelaPrincipal() {
        JFrame frame = new JFrame("Tela Inicial");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null); // Define layout nulo para posicionamento manual

        // Painel de fundo para customizar a cor
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(null);
        backgroundPanel.setBackground(new Color(200, 230, 255));
        backgroundPanel.setBounds(0, 0, 800, 600);
        frame.add(backgroundPanel);

        // Título principal
        JLabel titulo = new JLabel("Bem-vindo ao Fluentily", JLabel.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 32));
        titulo.setBounds(200, 50, 400, 50);
        backgroundPanel.add(titulo);

        // Subtítulo
        JLabel subtitulo = new JLabel("Você é ...", JLabel.CENTER);
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 20));
        subtitulo.setBounds(300, 150, 200, 30);
        backgroundPanel.add(subtitulo);

        // Botão Aluno
        JButton buttonAluno = new JButton("Aluno");
        buttonAluno.setBounds(250, 250, 100, 40);
        buttonAluno.setBackground(new Color(239, 229, 130));
        buttonAluno.setForeground(Color.BLACK);
        buttonAluno.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Você escolheu Aluno!", "Opção", JOptionPane.INFORMATION_MESSAGE);
        });
        backgroundPanel.add(buttonAluno);

        // Botão Professor
        JButton buttonProfessor = new JButton("Professor");
        buttonProfessor.setBounds(450, 250, 100, 40);
        buttonProfessor.setBackground(new Color(239, 229, 130));
        buttonProfessor.setForeground(Color.BLACK);
        buttonProfessor.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Você escolheu Professor!", "Opção", JOptionPane.INFORMATION_MESSAGE);
        });
        backgroundPanel.add(buttonProfessor);

        // Botão Sair
        JButton buttonSair = new JButton("Sair");
        buttonSair.setBounds(350, 320, 100, 40); // Centralizado abaixo dos outros botões
        buttonSair.setBackground(new Color(255, 100, 100)); // Cor de fundo vermelho claro
        buttonSair.setForeground(Color.BLACK); // Cor do texto branco
        buttonSair.addActionListener(e -> {
            int resposta = JOptionPane.showConfirmDialog(frame, "Tem certeza que deseja sair?", "Confirmar Saída", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        backgroundPanel.add(buttonSair);

        frame.setVisible(true);
    }
    // TERMINO DO CÓDIGO DA JANELA PRINCIPAL
}
