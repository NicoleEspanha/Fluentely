import javax.swing.*;
import java.awt.*;

public class JanelaProfessor {
    private JFrame frameProfessor;

    public JanelaProfessor(JFrame frameAnterior, Pessoa pessoa){

        //Cria Frame da janela professor
        frameProfessor = new JFrame("Bem-vindo, professor(a) " + pessoa.getNome());
        frameProfessor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameProfessor.setSize(800, 600);
        frameProfessor.setLocationRelativeTo(null);
        frameProfessor.setLayout(null);

        // Painel de fundo para customizar a cor
        JPanel panelProfessor = new JPanel();
        panelProfessor.setLayout(null);
        panelProfessor.setBackground(new Color(240, 230, 255));
        panelProfessor.setBounds(0, 0, 800, 600);
        frameProfessor.add(panelProfessor);

        // Título principal
        JLabel tituloProfessor = new JLabel("Bem-vindo, " + pessoa.getNome() + "!", JLabel.CENTER);
        tituloProfessor.setFont(new Font("Arial", Font.BOLD, 32));
        tituloProfessor.setBounds(200, 50, 400, 50);
        panelProfessor.add(tituloProfessor);

        // Subtítulo
        JLabel escolhaNivelProfessor = new JLabel("Escolha o nível", JLabel.CENTER);
        escolhaNivelProfessor.setFont(new Font("Arial", Font.PLAIN, 24));
        escolhaNivelProfessor.setBounds(200, 150, 400, 30);
        panelProfessor.add(escolhaNivelProfessor);

        //Botões de níveis
        BotaoNivel buttonN1 = new BotaoNivel(1, frameProfessor, pessoa, 200, 250, 100, 40);
        BotaoNivel buttonN2 = new BotaoNivel(2, frameProfessor, pessoa, 350, 250, 100, 40);
        BotaoNivel buttonN3 = new BotaoNivel(3, frameProfessor, pessoa, 500, 250, 100, 40);
        panelProfessor.add(buttonN1.getButtonNivel());
        panelProfessor.add(buttonN2.getButtonNivel());
        panelProfessor.add(buttonN3.getButtonNivel());

        //Botão voltar especial
        BotaoVoltarJanelaPrincipal voltar = new BotaoVoltarJanelaPrincipal(frameProfessor, pessoa);
        panelProfessor.add(voltar.getButtonVoltar());

        //Botão sair
        SairBotao sair = new SairBotao(frameProfessor);
        panelProfessor.add(sair.getSairBotao());

        //tornar janela visível
        frameProfessor.setVisible(true);
    }
}
