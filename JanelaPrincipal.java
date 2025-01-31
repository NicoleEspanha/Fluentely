import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal {
    private JFrame frame;
    private JPanel painel;

    //construtor
    public JanelaPrincipal(){

        //Cria Frame da janela principal
        frame = new JFrame("Tela Inicial");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null); // Define layout nulo para posicionamento manual

        // Painel de fundo para customizar a cor
        painel = new JPanel();
        painel.setLayout(null);
        painel.setBackground(new Color(200, 230, 255));
        painel.setBounds(0, 0, 800, 600);
        frame.add(painel);

        //Título principal
        JLabel titulo = new JLabel("Bem-vindo ao Fluentely", JLabel.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
        titulo.setBounds(200, 50, 400, 50);
        painel.add(titulo);

        // Subtítulo
        JLabel subtitulo = new JLabel("Você é ...", JLabel.CENTER);
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 20));
        subtitulo.setBounds(300, 150, 200, 30);
        painel.add(subtitulo);

        //Botão sair
        SairBotao sair = new SairBotao(frame);
        painel.add(sair.getSairBotao());

        //Botão Aluno
        BotaoUsuario aluno = new BotaoUsuario(frame);
        painel.add(aluno.getButtonAluno());

        //Botão Professor
        BotaoUsuario professor = new BotaoUsuario(frame);
        painel.add(professor.getButtonProfessor());

        //tornar janela visível
        frame.setVisible(true);
    }
}
