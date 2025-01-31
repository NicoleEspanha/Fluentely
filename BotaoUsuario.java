import javax.swing.*;
import java.awt.*;

public class BotaoUsuario {
    private JButton buttonAluno;
    private JButton buttonProfessor;
    private Pessoa alunoPessoa;
    private Pessoa professorPessoa;

    public BotaoUsuario(JFrame frame) {
        buttonAluno = new JButton("Aluno");
        buttonProfessor = new JButton("Professor");
        alunoPessoa = new Pessoa();
        professorPessoa = new Pessoa();

        // Botão Aluno
        buttonAluno.setBounds(250, 250, 100, 40);
        buttonAluno.setBackground(new Color(100, 200, 100));    // Cor de fundo verde claro
        buttonAluno.setForeground(Color.BLACK);                         // Cor do texto preto

        //Ação - botão Aluno
        buttonAluno.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(frame, "Tem certeza que deseja continuar como Aluno?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                String nome = JOptionPane.showInputDialog(frame, "Digite o seu nome:", "Nome do Aluno", JOptionPane.PLAIN_MESSAGE);
                alunoPessoa.setNome(nome);
                alunoPessoa.setTipo("Aluno");
                if (nome != null && !nome.trim().isEmpty()) {
                    frame.setVisible(false);
                    new JanelaAluno(frame, alunoPessoa);
                }
            }
        });

        // Botão Professor
        buttonProfessor = new JButton("Professor");
        buttonProfessor.setBounds(450, 250, 100, 40);
        buttonProfessor.setBackground(new Color(100, 150, 250)); // Cor de fundo azul
        buttonProfessor.setForeground(Color.WHITE);                      // Cor do texto branco

        //Ação - botão Professor
        buttonProfessor.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(frame, "Tem certeza que deseja continuar como Professor?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                String nome = JOptionPane.showInputDialog(frame, "Digite o seu nome:", "Nome do Professor", JOptionPane.PLAIN_MESSAGE);
                professorPessoa.setNome(nome);
                professorPessoa.setTipo("Professor");
                if (nome != null && !nome.trim().isEmpty()) {
                    frame.setVisible(false);
                    new JanelaProfessor(frame, professorPessoa);
                }
            }
        });
    }
//Gets dos botões aluno e professor
    public JButton getButtonAluno(){
        return buttonAluno;
    }

    public JButton getButtonProfessor() {
        return buttonProfessor;
    }
}
