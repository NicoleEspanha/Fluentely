import javax.swing.*;
import java.awt.*;

public class JanelaNivel {
    private JFrame frameNivel;

    public JanelaNivel(JFrame frameAnterior, JButton buttonClicado,Pessoa pessoa){

        //Cria Frame da janela nível
        frameNivel = new JFrame(buttonClicado.getText() +" - "+ pessoa.getTipo() + "(a)");
        frameNivel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameNivel.setSize(800,600);
        frameNivel.setLocationRelativeTo(null);
        frameNivel.setLayout(null);

        // Painel de fundo para customizar a cor
        JPanel panelNivel = new JPanel();
        panelNivel.setLayout(null);
        panelNivel.setBackground(new Color(72, 104, 72));
        panelNivel.setBounds(0, 0, 800, 600);
        frameNivel.add(panelNivel);

        // Título principal
        JLabel tituloNivel = new JLabel(pessoa.getNome() + ", escolha um tema:", JLabel.CENTER);
        tituloNivel.setForeground(Color.white);
        tituloNivel.setFont(new Font("Arial", Font.BOLD, 35));
        tituloNivel.setBounds(100, 50, 600, 40);
        panelNivel.add(tituloNivel);

        //Botões de temas
        BotaoTema buttonT1 = new BotaoTema("Substantivos", frameNivel, buttonClicado, pessoa, 150, 240, 150, 40);
        BotaoTema buttonT2 = new BotaoTema("Verbos"      , frameNivel, buttonClicado, pessoa, 325, 240, 150, 40);
        BotaoTema buttonT3 = new BotaoTema("Adjetivos"   , frameNivel, buttonClicado, pessoa, 500, 240, 150, 40);
        panelNivel.add(buttonT1.getButtonTema());
        panelNivel.add(buttonT2.getButtonTema());
        panelNivel.add(buttonT3.getButtonTema());

        //Botão voltar
        BotaoVoltarJanelaNivel voltar = new BotaoVoltarJanelaNivel(frameNivel, pessoa);
        panelNivel.add(voltar.getButtonVoltar());

        //Botão sair
        SairBotao sair = new SairBotao(frameNivel);
        panelNivel.add(sair.getSairBotao());
        frameNivel.setVisible(true);
    }
}
