import javax.swing.*;
import java.awt.*;

public class JanelaPerguntaAluno {
    private JFrame framePerguntaAluno;

    public JanelaPerguntaAluno(JFrame frameAnterior, JButton buttonTema, JButton buttonNivel, Pessoa pessoa, int numeroPergunta){

        //Cria Frame da janela nível
        framePerguntaAluno = new JFrame("Pergunta " + numeroPergunta + " - " + buttonTema.getText() + " " + buttonNivel.getText() + " - " + pessoa.getTipo() + "(a) " + pessoa.getNome());
        framePerguntaAluno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePerguntaAluno.setSize(800, 600);
        framePerguntaAluno.setLocationRelativeTo(null);
        framePerguntaAluno.setLayout(null);

        // Painel de fundo para customizar a cor
        JPanel panelTemas = new JPanel();
        panelTemas.setLayout(null);
        panelTemas.setBackground(new Color(255, 250, 200));
        panelTemas.setBounds(0, 0, 800, 600);
        framePerguntaAluno.add(panelTemas);

        // Título principal
        JLabel temaLabel = new JLabel(buttonTema.getText() + " - Pergunta " + numeroPergunta, JLabel.CENTER);
        temaLabel.setFont(new Font("Arial", Font.BOLD, 24));
        temaLabel.setBounds(200, 50, 400, 40);
        panelTemas.add(temaLabel);

        // Rótulo perguntas
        Perguntas pergunta = new Perguntas(framePerguntaAluno, numeroPergunta, buttonTema, buttonNivel);
        JLabel fraseLabel = new JLabel(pergunta.getPergunta(), JLabel.CENTER);
        fraseLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        fraseLabel.setBounds(100, 150, 600, 30);
        panelTemas.add(fraseLabel);

        //Botão alternativas
        int respostaCorretaIndice = pergunta.getRespostaCorretaIndice();
        String alternativaTexto;
        String[] alternativas = pergunta.getAlternativasVetor();

        for (int i = 0; i < 4; i++) {
            JButton buttonAlternativa = new JButton(pergunta.getAlternativas(i));
            buttonAlternativa.setBounds(200, 200 + i * 50, 400, 40);

            //pinta as respostas de verde ou vermelha ao serem clicadas e informa se esta correta ou errada
            alternativaTexto = alternativas[i];
            String finalAlternativaTexto = alternativaTexto;

            //Ação - botões
            buttonAlternativa.addActionListener(e -> {
                if (respostaCorretaIndice != -1 && finalAlternativaTexto.equals(alternativas[respostaCorretaIndice])) {
                    pessoa.somaUmRespostasCorretas();
                    buttonAlternativa.setBackground(Color.green);
                    JOptionPane.showMessageDialog(framePerguntaAluno, "Resposta correta!");

                } else {
                    buttonAlternativa.setBackground(Color.red);
                    JOptionPane.showMessageDialog(framePerguntaAluno, "Resposta incorreta. Tente novamente!");
                }
            });
            panelTemas.add(buttonAlternativa);
        }

        //Aviso de salvamento de progresso
        JLabel avisoLabel = new JLabel("AO SAIR SEU PROGRESSO NÃO SERÁ SALVO ", JLabel.CENTER);
        avisoLabel.setFont(new Font("Arial", Font.BOLD, 12));
        avisoLabel.setBounds(200, 520, 400, 40);
        panelTemas.add(avisoLabel);

        //Botão próximo
        BotaoProximo proximo = new BotaoProximo(framePerguntaAluno, buttonTema, buttonNivel, pessoa, numeroPergunta);
        panelTemas.add(proximo.getButtonProximo());

        //Botão voltar
        VoltarBotao voltar = new VoltarBotao(framePerguntaAluno, frameAnterior);
        panelTemas.add(voltar.getButtonVoltar());

        //Botão sair
        SairBotao sair = new SairBotao(framePerguntaAluno);
        panelTemas.add(sair.getSairBotao());
        framePerguntaAluno.setVisible(true);
        
        framePerguntaAluno.setVisible(true);
    }

}
