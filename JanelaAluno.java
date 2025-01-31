import javax.swing.*;
import java.awt.*;

public class JanelaAluno {
    private JFrame frameAluno;
    private int nivel;

    public JanelaAluno(JFrame frameAnterior, Pessoa pessoa){

        //Cria Frame da janela aluno
        frameAluno = new JFrame("Bem-vindo, aluno(a) " + pessoa.getNome());
        frameAluno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAluno.setSize(800, 600);
        frameAluno.setLocationRelativeTo(null);
        frameAluno.setLayout(null);

        // Painel de fundo para customizar a cor
        JPanel panelAluno = new JPanel();
        panelAluno.setLayout(null);
        panelAluno.setBackground(new Color(220, 240, 255));
        panelAluno.setBounds(0, 0, 800, 600);
        frameAluno.add(panelAluno);

        // Título principal
        JLabel tituloAluno = new JLabel("Bem-vindo, " + pessoa.getNome() + "!", JLabel.CENTER);
        tituloAluno.setFont(new Font("Arial", Font.BOLD, 32));
        tituloAluno.setBounds(200, 50, 400, 50);
        panelAluno.add(tituloAluno);

        // Subtítulo
        JLabel escolhaNivelAluno = new JLabel("Escolha o nível", JLabel.CENTER);
        escolhaNivelAluno.setFont(new Font("Arial", Font.PLAIN, 24));
        escolhaNivelAluno.setBounds(200, 150, 400, 30);
        panelAluno.add(escolhaNivelAluno);

        //Botões de níveis
        BotaoNivel buttonN1 = new BotaoNivel(1, frameAluno, pessoa, 100, 250, 100, 40);
        BotaoNivel buttonN2 = new BotaoNivel(2, frameAluno, pessoa, 250, 250, 100, 40);
        BotaoNivel buttonN3 = new BotaoNivel(3, frameAluno, pessoa, 400, 250, 100, 40);
        panelAluno.add(buttonN1.getButtonNivel());
        panelAluno.add(buttonN2.getButtonNivel());
        panelAluno.add(buttonN3.getButtonNivel());

        //Botão progresso
        BotaoProgresso buttonProgresso = new BotaoProgresso(frameAluno, pessoa);
        panelAluno.add(buttonProgresso.getButtonProgresso());

        //Botão voltar especial
        BotaoVoltarJanelaPrincipal voltar = new BotaoVoltarJanelaPrincipal(frameAluno, pessoa);
        panelAluno.add(voltar.getButtonVoltar());

        //Botão sair
        SairBotao sair = new SairBotao(frameAluno);
        panelAluno.add(sair.getSairBotao());

        //tornar janela visível
        frameAluno.setVisible(true);
    }

    public void setNivel(int nivelEscolhido){
        this.nivel = nivelEscolhido;
    }
    public int getNivel(){
        return nivel;
    }
    public JFrame getFrameAluno(){
        return frameAluno;
    }
}
