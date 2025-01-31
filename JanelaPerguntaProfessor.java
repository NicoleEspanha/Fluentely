import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JanelaPerguntaProfessor {
    private JFrame framePerguntaProfessor;

    public JanelaPerguntaProfessor(JFrame frameAnterior, JButton buttonTema, JButton buttonNivel, Pessoa pessoa, int numeroPergunta) {

        //Cria Frame da janela nível
        framePerguntaProfessor = new JFrame("Pergunta " + numeroPergunta + " - " + buttonTema.getText() + " " + buttonNivel.getText() + " - " + pessoa.getTipo() + "(a) " + pessoa.getNome());
        framePerguntaProfessor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePerguntaProfessor.setSize(800, 600);
        framePerguntaProfessor.setLocationRelativeTo(null);
        framePerguntaProfessor.setLayout(null);

        // Painel de fundo para customizar a cor
        JPanel panelTemas = new JPanel();
        panelTemas.setLayout(null);
        panelTemas.setBackground(new Color(255, 250, 200));
        panelTemas.setBounds(0, 0, 800, 600);
        framePerguntaProfessor.add(panelTemas);

        // Título principal
        JLabel temaLabel = new JLabel(buttonTema.getText() + " - Pergunta " + numeroPergunta, JLabel.CENTER);
        temaLabel.setFont(new Font("Arial", Font.BOLD, 24));
        temaLabel.setBounds(200, 50, 400, 40);
        panelTemas.add(temaLabel);

        //Rótulos perguntas
        Perguntas pergunta = new Perguntas(framePerguntaProfessor, numeroPergunta, buttonTema, buttonNivel);
        JLabel fraseLabel = new JLabel(pergunta.getPergunta(), JLabel.CENTER);
        fraseLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        fraseLabel.setBounds(100, 150, 600, 30);
        panelTemas.add(fraseLabel);

        //Botão alternativas e pergunta para alterar
        int respostaCorretaIndice = pergunta.getRespostaCorretaIndice();
        String alternativaTexto;
        String[] alternativas = pergunta.getAlternativasVetor();
        String arquivo = pergunta.getArquivo();
        String perg = pergunta.getPergunta();
        String respostaCorretaTexto = pergunta.getRespostaCorretaTexto();
        String finalArquivo = arquivo;

        try {
            if (perg != null && alternativas[0] != null && respostaCorretaTexto != null) {
                JButton fraseButton = new JButton(perg);
                fraseButton.setFont(new Font("Arial", Font.PLAIN, 18));
                fraseButton.setBounds(100, 150, 600, 30);
                fraseButton.setBackground(Color.white);
                fraseButton.setBorder(BorderFactory.createLoweredBevelBorder());

                //Ação - botão --------------------------- LÓGICA PARA ALTERAR PERGUNTA
                fraseButton.addActionListener(e -> {
                    String pergModificada = JOptionPane.showInputDialog(framePerguntaProfessor, "Altere a pergunta:", fraseButton.getText(), JOptionPane.PLAIN_MESSAGE);

                    //Garantir que não vai deixar a alteração como null e apagar o arquivo
                    if (pergModificada != null && !pergModificada.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(framePerguntaProfessor, "Alterando a pergunta...");
                        modificarPergunta(finalArquivo, numeroPergunta, pergModificada);
                    }
                });
                panelTemas.add(fraseButton);
            }

            for (int i = 0; i < 4; i++) {
                JButton buttonAlternativa = new JButton(pergunta.getAlternativas(i));
                buttonAlternativa.setBounds(200, 200 + i * 50, 400, 40);

                alternativaTexto = alternativas[i];
                String finalAlternativaTexto = alternativaTexto; //

                //Deixar gabarito em verde
                if (respostaCorretaIndice != -1 && finalAlternativaTexto.equals(alternativas[respostaCorretaIndice])) {
                    buttonAlternativa.setBackground(Color.green);
                }
                int numResp = i + 1;

                //Ação - botão --------------------------- LÓGICA PARA ALTERAR RESPOSTAS
                buttonAlternativa.addActionListener(e -> {
                String resposta = JOptionPane.showInputDialog(framePerguntaProfessor, "Altere a resposta errada:", finalAlternativaTexto, JOptionPane.PLAIN_MESSAGE);

                    //Garantir que não vai deixar a alteração como null e apagar o arquivo
                if (resposta != null && !resposta.trim().isEmpty())
                    modificarAlternativa(finalArquivo, numeroPergunta, numResp, resposta);
                });
                panelTemas.add(buttonAlternativa);
            }
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(framePerguntaProfessor, "Erro ao ler o arquivo: " + e.getMessage());

        }
            //Aviso de salvamento de alterações
            JLabel avisoLabel = new JLabel("SAIA E ENTRE PARA VERIFICAR ALTERAÇÕES ", JLabel.CENTER);
            avisoLabel.setFont(new Font("Arial", Font.BOLD, 12));
            avisoLabel.setBounds(200, 520, 400, 40);
            panelTemas.add(avisoLabel);

            //Botão próximo
            BotaoProximo proximo = new BotaoProximo(framePerguntaProfessor, buttonTema, buttonNivel, pessoa, numeroPergunta);
            panelTemas.add(proximo.getButtonProximo());

            //Botão voltar
            VoltarBotao voltar = new VoltarBotao(framePerguntaProfessor, frameAnterior);
            panelTemas.add(voltar.getButtonVoltar());

            //Botão sair
            SairBotao sair = new SairBotao(framePerguntaProfessor);
            panelTemas.add(sair.getSairBotao());

            framePerguntaProfessor.setVisible(true);
    }

        public static void modificarPergunta (String arquivo,int numeroPergunta, String novaPergunta){
            java.util.List<String> linhas = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    linhas.add(linha);
                }

                int linhaPergunta = (numeroPergunta - 1) * 7; // indice: A cada 7 linhas há uma pergunta

                if (linhaPergunta < linhas.size()) {
                    linhas.set(linhaPergunta, novaPergunta); // Modifica a pergunta na linha correta
                    salvarAlteracoesNoArquivo(arquivo, linhas); // Salvar no arquivo
                } else {
                    System.out.println("Pergunta não encontrada no arquivo.");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public static void modificarAlternativa (String arquivo,int numeroPergunta, int numeroAlternativa, String
        novaAlternativa){
            java.util.List<String> linhas = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    linhas.add(linha);
                }

                int linhaPergunta = (numeroPergunta - 1) * 7; // indice: A cada 7 linhas há uma pergunta
                int linhaAlternativa = linhaPergunta + numeroAlternativa; // adiciona a posicao da alternativa

                if (linhaAlternativa < linhas.size()) {
                    linhas.set(linhaAlternativa, novaAlternativa); // Substitui a alternativa na linha correta

                    salvarAlteracoesNoArquivo(arquivo, linhas); // Salvar no arquivo
                } else {
                    System.out.println("Alternativa não encontrada no arquivo.");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public static void salvarAlteracoesNoArquivo (String arquivo, List < String > linhas){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
                for (String linha : linhas) { // Escreve todas as linhas modificadas de volta no arquivo
                    writer.write(linha);
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
