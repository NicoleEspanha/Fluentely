import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;
import javax.swing.*;

public class Main {

    // variáveis para o progresso
    private static int respostasCorretas = 0; // Número de respostas corretas
    private static final int TOTAL_PERGUNTAS = 27; // Total de perguntas        

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        SwingUtilities.invokeLater(() -> criarJanelaPrincipal(pessoa));
    }

    // ========================================================== COMEÇA JANELA PRINCIPAL ==============================================================================
    private static void criarJanelaPrincipal(Pessoa pessoa) {
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
        buttonAluno.setBackground(new Color(100, 200, 100)); // Cor de fundo verde claro
        buttonAluno.setForeground(Color.BLACK); // Cor do texto preto
        buttonAluno.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(frame, "Tem certeza que deseja continuar como Aluno?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                String nome = JOptionPane.showInputDialog(frame, "Digite o seu nome:", "Nome do Aluno", JOptionPane.PLAIN_MESSAGE);
                pessoa.setNome(nome);
                pessoa.setTipo("Aluno");
                if (nome != null && !nome.trim().isEmpty()) {
                    criarJanelaAluno(frame, pessoa);
                }
            }
        });
        backgroundPanel.add(buttonAluno);

        // Botão Professor
        JButton buttonProfessor = new JButton("Professor");
        buttonProfessor.setBounds(450, 250, 100, 40);
        buttonProfessor.setBackground(new Color(100, 150, 250)); // Cor de fundo azul
        buttonProfessor.setForeground(Color.WHITE); // Cor do texto branco
        buttonProfessor.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(frame, "Tem certeza que deseja continuar como Professor?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                String nome = JOptionPane.showInputDialog(frame, "Digite o seu nome:", "Nome do Professor", JOptionPane.PLAIN_MESSAGE);
                pessoa.setNome(nome);
                pessoa.setTipo("Professor");
                if (nome != null && !nome.trim().isEmpty()) {
                    criarJanelaProfessor(frame, pessoa);
                }
            }
        });
        backgroundPanel.add(buttonProfessor);

        // Botão Sair
        JButton buttonSair = new JButton("Sair");
        buttonSair.setBounds(350, 320, 100, 40); // Centralizado abaixo dos outros botões
        buttonSair.setBackground(new Color(255, 100, 100)); // Cor de fundo vermelho claro
        buttonSair.setForeground(Color.WHITE); // Cor do texto branco
        buttonSair.addActionListener(e -> {
            int resposta = JOptionPane.showConfirmDialog(frame, "Tem certeza que deseja sair?", "Confirmar Saída", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        backgroundPanel.add(buttonSair);

       

        frame.setVisible(true);
    }
    // ========================================================== TERMINA JANELA PRINCIPAL ==============================================================================

    // ========================================================== COMEÇA JANELA ALUNO ==============================================================================
    private static void criarJanelaAluno(JFrame frameAnterior, Pessoa pessoa) {
        frameAnterior.dispose(); // Fecha a janela anterior

        
        JFrame frameAluno = new JFrame("Bem-vindo, aluno(a) " + pessoa.getNome());
        frameAluno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAluno.setSize(800, 600);
        frameAluno.setLocationRelativeTo(null);
        frameAluno.setLayout(null);

        JPanel panelAluno = new JPanel();
        panelAluno.setLayout(null);
        panelAluno.setBackground(new Color(220, 240, 255));
        panelAluno.setBounds(0, 0, 800, 600);
        frameAluno.add(panelAluno);

        JLabel tituloAluno = new JLabel("Bem-vindo, " + pessoa.getNome() + "!", JLabel.CENTER);
        tituloAluno.setFont(new Font("Arial", Font.BOLD, 24));
        tituloAluno.setBounds(200, 50, 400, 40);
        panelAluno.add(tituloAluno);

        JLabel escolhaNivelAluno = new JLabel("Escolha o nível", JLabel.CENTER);
        escolhaNivelAluno.setFont(new Font("Arial", Font.PLAIN, 18));
        escolhaNivelAluno.setBounds(200, 150, 400, 30);
        panelAluno.add(escolhaNivelAluno);

        JButton buttonN1 = new JButton("Nível 1");
        buttonN1.setBounds(100, 200, 100, 40);
        panelAluno.add(buttonN1);
        buttonN1.addActionListener(e ->{
            Botao botao = new Botao();
            botao.setNivel(buttonN1);
            criarJanelaNivel(frameAluno, botao, pessoa);
        });

        JButton buttonN2 = new JButton("Nível 2");
        buttonN2.setBounds(250, 200, 100, 40);
        panelAluno.add(buttonN2);
        buttonN2.addActionListener(e ->{
            Botao botao = new Botao();
            botao.setNivel(buttonN2);
            criarJanelaNivel(frameAluno, botao, pessoa);
        });

        JButton buttonN3 = new JButton("Nível 3");
        buttonN3.setBounds(400, 200, 100, 40);
        panelAluno.add(buttonN3);
        buttonN3.addActionListener(e ->{
            Botao botao = new Botao();
            botao.setNivel(buttonN3);
            criarJanelaNivel(frameAluno, botao, pessoa);
        });

        
        JButton buttonVoltar = new JButton("Voltar");
        buttonVoltar.setBounds(250, 400, 100, 40);
        buttonVoltar.addActionListener(e -> {
            frameAluno.dispose();
            criarJanelaPrincipal(pessoa);
        });
        panelAluno.add(buttonVoltar);

        JButton buttonSair = new JButton("Sair");
        buttonSair.setBounds(400, 400, 100, 40);
        buttonSair.setBackground(new Color(255, 100, 100));
        buttonSair.setForeground(Color.WHITE);
        buttonSair.addActionListener(e -> {
            int resposta = JOptionPane.showConfirmDialog(frameAluno, "Tem certeza que deseja sair?", "Confirmar Saída", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        panelAluno.add(buttonSair);
        
        

                JButton buttonProgresso = new JButton("Progresso");
        buttonProgresso.setBounds(550, 200, 100, 40);
        buttonProgresso.addActionListener(e -> {
            // Calcula a porcentagem de progresso
            double progresso = (respostasCorretas / (double) TOTAL_PERGUNTAS) * 100;
            // Formata o valor para mostrar 2 casas decimais
            JOptionPane.showMessageDialog(frameAluno, "Você completou " + String.format("%.2f", progresso) + "% das perguntas corretamente.");
        });
        panelAluno.add(buttonProgresso);

        

        frameAluno.setVisible(true);
    }
    // ========================================================== TERMINA JANELA ALUNO ==============================================================================

    // ========================================================= COMEÇA JANELA PROFESSOR ==============================================================================
    private static void criarJanelaProfessor(JFrame frameAnterior, Pessoa pessoa) {
        frameAnterior.dispose();

        JFrame frameProfessor = new JFrame("Bem-vindo, professor(a) " + pessoa.getNome());
        frameProfessor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameProfessor.setSize(800, 600);
        frameProfessor.setLocationRelativeTo(null);
        frameProfessor.setLayout(null);

        JPanel panelProfessor = new JPanel();
        panelProfessor.setLayout(null);
        panelProfessor.setBackground(new Color(240, 230, 255));
        panelProfessor.setBounds(0, 0, 800, 600);
        frameProfessor.add(panelProfessor);

        JLabel tituloProfessor = new JLabel("Bem-vindo, " + pessoa.getNome() + "!", JLabel.CENTER);
        tituloProfessor.setFont(new Font("Arial", Font.BOLD, 24));
        tituloProfessor.setBounds(200, 50, 400, 40);
        panelProfessor.add(tituloProfessor);

        JLabel escolhaNivelProfessor = new JLabel("Escolha o nível", JLabel.CENTER);
        escolhaNivelProfessor.setFont(new Font("Arial", Font.PLAIN, 18));
        escolhaNivelProfessor.setBounds(200, 150, 400, 30);
        panelProfessor.add(escolhaNivelProfessor);

        JButton buttonN1 = new JButton("Nível 1");
        buttonN1.setBounds(200, 200, 100, 40);
        panelProfessor.add(buttonN1);
        buttonN1.addActionListener(e ->{
            Botao botao = new Botao();
            botao.setNivel(buttonN1);
            criarJanelaNivel(frameProfessor, botao, pessoa);
        });

        JButton buttonN2 = new JButton("Nível 2");
        buttonN2.setBounds(350, 200, 100, 40);
        panelProfessor.add(buttonN2);
        buttonN2.addActionListener(e ->{
            Botao botao = new Botao();
            botao.setNivel(buttonN2);
            criarJanelaNivel(frameProfessor, botao, pessoa);
        });

        JButton buttonN3 = new JButton("Nível 3");
        buttonN3.setBounds(500, 200, 100, 40);
        panelProfessor.add(buttonN3);
        buttonN3.addActionListener(e ->{
            Botao botao = new Botao();
            botao.setNivel(buttonN3);
            criarJanelaNivel(frameProfessor, botao, pessoa);
        });

        JButton buttonVoltar = new JButton("Voltar");
        buttonVoltar.setBounds(250, 400, 100, 40);
        buttonVoltar.addActionListener(e -> {
            frameProfessor.dispose();
            criarJanelaPrincipal(pessoa);
        });
        panelProfessor.add(buttonVoltar);

        JButton buttonSair = new JButton("Sair");
        buttonSair.setBounds(400, 400, 100, 40);
        buttonSair.setBackground(new Color(255, 100, 100));
        buttonSair.setForeground(Color.WHITE);
        buttonSair.addActionListener(e -> {
            int resposta = JOptionPane.showConfirmDialog(frameProfessor, "Tem certeza que deseja sair?", "Confirmar Saída", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        panelProfessor.add(buttonSair);

        frameProfessor.setVisible(true);
    }


// ========================================================== TERMINA JANELA PROFESSOR ==============================================================================

    // ========================================================== COMEÇA JANELA NÍVEL ==============================================================================
    private static void criarJanelaNivel(JFrame frameAnterior, Botao buttonClicado, Pessoa pessoa){
        frameAnterior.dispose();

        JFrame frameNivel = new JFrame(buttonClicado.getNivel().getText() +" - "+ pessoa.getTipo());
        frameNivel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameNivel.setSize(800,600);
        frameNivel.setLocationRelativeTo(null);
        frameNivel.setLayout(null);

        JPanel panelNivel = new JPanel();
        panelNivel.setLayout(null);
        panelNivel.setBackground(new Color(72, 104, 72));
        panelNivel.setBounds(0, 0, 800, 600);
        frameNivel.add(panelNivel);

        JButton buttonSubstantivos = new JButton("Substantivos");
        buttonSubstantivos.setBounds(150, 240, 150, 40);
        buttonSubstantivos.setBackground(new Color(40, 159, 158));
        buttonSubstantivos.setForeground(Color.WHITE);
        buttonSubstantivos.addActionListener(e ->{
            frameNivel.dispose();
            buttonClicado.setTema(buttonSubstantivos);
            criarJanelaTemas(frameNivel, buttonClicado, pessoa);
        });
        panelNivel.add(buttonSubstantivos);

        JButton buttonVerbos = new JButton("Verbos");
        buttonVerbos.setBounds(325, 240, 150, 40);
        buttonVerbos.setBackground(new Color(40, 159, 158));
        buttonVerbos.setForeground(Color.WHITE);
        buttonVerbos.addActionListener(e ->{
            frameNivel.dispose();
            buttonClicado.setTema(buttonVerbos);
            criarJanelaTemas(frameNivel, buttonClicado, pessoa);
        });
        panelNivel.add(buttonVerbos);

        JButton buttonAdjetivos = new JButton("Adjetivos");
        buttonAdjetivos.setBounds(500, 240, 150, 40);
        buttonAdjetivos.setBackground(new Color(40, 159, 158));
        buttonAdjetivos.setForeground(Color.WHITE);
        buttonAdjetivos.addActionListener(e ->{
            frameNivel.dispose();
            buttonClicado.setTema(buttonAdjetivos);
            criarJanelaTemas(frameNivel, buttonClicado, pessoa);
        });
        panelNivel.add(buttonAdjetivos);

        JButton buttonVoltar = new JButton("Voltar");
        buttonVoltar.setBounds(10, 510, 100, 40);
        buttonVoltar.addActionListener(e -> {
            frameNivel.dispose();
            if(pessoa.getTipo().equals("Aluno"))
                criarJanelaAluno(frameNivel, pessoa);
            else
                criarJanelaProfessor(frameNivel, pessoa); //ajeitar para fazer voltar para Janela Professor/aluno tendo o nome digitado antes
        });
        panelNivel.add(buttonVoltar);

        frameNivel.setVisible(true);
    }
// ========================================================== TERMINA JANELA NÍVEL ==============================================================================

    // ========================================================== COMEÇA JANELA TEMAS ==============================================================================
    private static void criarJanelaTemas(JFrame frameAnterior, Botao buttonClicado, Pessoa pessoa) {
        frameAnterior.dispose();

        JFrame frameTemas = new JFrame(buttonClicado.getTema().getText() + " - " + buttonClicado.getNivel().getText() + " - " + pessoa.getTipo());
        frameTemas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTemas.setSize(800, 600);
        frameTemas.setLocationRelativeTo(null);
        frameTemas.setLayout(null);

        JPanel panelTemas = new JPanel();
        panelTemas.setLayout(null);
        panelTemas.setBackground(new Color(41, 147, 227));
        panelTemas.setBounds(0, 0, 800, 600);
        frameTemas.add(panelTemas);

        JLabel temaLabel = new JLabel("Tema: " + buttonClicado.getTema().getText(), JLabel.CENTER);
        temaLabel.setFont(new Font("Arial", Font.BOLD, 24));
        temaLabel.setBounds(200, 50, 400, 40);
        panelTemas.add(temaLabel);

        JButton buttonContinuar = new JButton("Continuar");
        buttonContinuar.setBounds(325, 240, 150, 40);
        buttonContinuar.addActionListener(e -> {
            if (pessoa.getTipo().equals("Aluno")) {
                frameTemas.dispose();
                criarJanelaPerguntaAluno(frameTemas, buttonClicado, pessoa, 1); // Inicia as perguntas para o aluno a partir da Pergunta 1
            } else {
                frameTemas.dispose();
                criarJanelaPerguntaProfessor(frameTemas, buttonClicado, pessoa, 1); // Inicia as perguntas para o professor a partir da Pergunta 1
            }
        });
        panelTemas.add(buttonContinuar);

        JButton buttonVoltar = new JButton("Voltar");
        buttonVoltar.setBounds(10, 510, 100, 40);
        buttonVoltar.addActionListener(e -> {
            frameTemas.dispose();
            criarJanelaNivel(frameTemas, buttonClicado, pessoa); // Volta para a tela de nível
        });
        panelTemas.add(buttonVoltar);

        frameTemas.setVisible(true);
    }



// ========================================================== TERMINA JANELA TEMAS ==============================================================================

// ========================================================== COMEÇA JANELA QUESTÃO ALUNO ============================================================================

    private static void criarJanelaPerguntaAluno(JFrame frameAnterior, Botao buttonClicado, Pessoa pessoa, int numeroPergunta) {
        frameAnterior.dispose();

        JFrame framePergunta = new JFrame("Pergunta " + numeroPergunta + " - " + buttonClicado.getTema().getText() + " - " + buttonClicado.getNivel().getText());
        framePergunta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePergunta.setSize(800, 600);
        framePergunta.setLocationRelativeTo(null);
        framePergunta.setLayout(null);

        JPanel panelPergunta = new JPanel();
        panelPergunta.setLayout(null);
        panelPergunta.setBackground(new Color(255, 250, 200));
        panelPergunta.setBounds(0, 0, 800, 600);
        framePergunta.add(panelPergunta);

        JLabel perguntaLabel = new JLabel("Pergunta " + numeroPergunta, JLabel.CENTER);
        perguntaLabel.setFont(new Font("Arial", Font.BOLD, 24));
        perguntaLabel.setBounds(200, 50, 400, 40);
        panelPergunta.add(perguntaLabel);

        String arquivo = null;
        String nivel = buttonClicado.getNivel().getText();

        // Seleciona qual arquivo abrir
        if (nivel.startsWith("Nível")) {
            String nivelNum = nivel.split(" ")[1];
            switch (buttonClicado.getTema().getText()) {
                case "Substantivos":
                    arquivo = "n" + nivelNum + "_sub.txt";
                    break;
                case "Adjetivos":
                    arquivo = "n" + nivelNum + "_adje.txt";
                    break;
                case "Verbos":
                    arquivo = "n" + nivelNum + "_verb.txt";
                    break;
            }
        }

        if (arquivo != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
                String linha;
                int linhaPergunta = 1 + (numeroPergunta - 1) * 7; // A linha da pergunta começa na 1 e pula de sete em sete (1, 8, 15, 22...)
                int linhaAtual = 0;
                String pergunta = null;
                String[] alternativas = new String[4];
                String respostaCorretaTexto = null;

                while ((linha = reader.readLine()) != null) {
                    linhaAtual++;

                    if (linhaAtual == linhaPergunta) {
                        pergunta = linha;
                    } else if (linhaAtual >= linhaPergunta + 1 && linhaAtual <= linhaPergunta + 4) {
                        alternativas[linhaAtual - linhaPergunta - 1] = linha;
                    } else if (linhaAtual == linhaPergunta + 5) {
                        respostaCorretaTexto = linha;
                        break;
                    }
                }

                // Verifica se todos os dados foram carregados
                if (pergunta != null && alternativas[0] != null && respostaCorretaTexto != null) {
                    JLabel fraseLabel = new JLabel(pergunta, JLabel.CENTER);
                    fraseLabel.setFont(new Font("Arial", Font.PLAIN, 18));
                    fraseLabel.setBounds(100, 150, 600, 30);
                    panelPergunta.add(fraseLabel);

                    int respostaCorretaIndice = switch (respostaCorretaTexto.trim().toUpperCase()) {
                        case "A" -> 0;
                        case "B" -> 1;
                        case "C" -> 2;
                        case "D" -> 3;
                        default -> -1;
                    };

                    for (int i = 0; i < 4; i++) {
                        JButton alternativaButton = new JButton(alternativas[i]);
                        alternativaButton.setBounds(200, 200 + i * 50, 400, 40);

                        String alternativaTexto = alternativas[i];
                        alternativaButton.addActionListener(e -> {
                            if (respostaCorretaIndice != -1 && alternativaTexto.equals(alternativas[respostaCorretaIndice])) {
                                alternativaButton.setBackground(Color.green);
                                JOptionPane.showMessageDialog(framePergunta, "Resposta correta!");
                                respostasCorretas++;
                            } else {
                                alternativaButton.setBackground(Color.red);
                                JOptionPane.showMessageDialog(framePergunta, "Resposta incorreta. Tente novamente!");
                            }
                        });

                        panelPergunta.add(alternativaButton);
                    }
                } else {
                    JOptionPane.showMessageDialog(framePergunta, "Erro: Dados insuficientes no arquivo.");
                }
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(framePergunta, "Erro ao ler o arquivo: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(framePergunta, "Erro: Arquivo não encontrado.");
        }

        JButton buttonProximo = new JButton("Próximo");
        buttonProximo.setBounds(325, 450, 150, 40);
        buttonProximo.addActionListener(e -> {
            if (numeroPergunta < 3) {
                framePergunta.dispose();
                criarJanelaPerguntaAluno(framePergunta, buttonClicado, pessoa, numeroPergunta + 1);
            } else {
                JOptionPane.showMessageDialog(framePergunta, "Você completou todas as perguntas!");
                framePergunta.dispose();
                criarJanelaNivel(framePergunta, buttonClicado, pessoa);
            }
        });
        panelPergunta.add(buttonProximo);

        JButton buttonVoltar = new JButton("Voltar");
        buttonVoltar.setBounds(10, 510, 100, 40);
        buttonVoltar.addActionListener(e -> {
            framePergunta.dispose();
            criarJanelaTemas(framePergunta, buttonClicado, pessoa);
        });
        panelPergunta.add(buttonVoltar);

        framePergunta.setVisible(true);
    }



// ========================================================== TERMINA JANELA QUESTÃO ALUNO ==============================================================================

// ========================================================== COMEÇA JANELA QUESTÃO PROFESSOR ===========================================================================

    private static void criarJanelaPerguntaProfessor(JFrame frameAnterior, Botao buttonClicado, Pessoa pessoa, int numeroPergunta) {
        frameAnterior.dispose();

        JFrame framePergunta = new JFrame("Pergunta " + numeroPergunta + " - " + buttonClicado.getTema().getText() + " - " + buttonClicado.getNivel().getText());
        framePergunta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePergunta.setSize(800, 600);
        framePergunta.setLocationRelativeTo(null);
        framePergunta.setLayout(null);

        JPanel panelPergunta = new JPanel();
        panelPergunta.setLayout(null);
        panelPergunta.setBackground(new Color(255, 250, 200));
        panelPergunta.setBounds(0, 0, 800, 600);
        framePergunta.add(panelPergunta);

        JLabel perguntaLabel = new JLabel("Pergunta " + numeroPergunta, JLabel.CENTER);
        perguntaLabel.setFont(new Font("Arial", Font.BOLD, 24));
        perguntaLabel.setBounds(200, 50, 400, 40);
        panelPergunta.add(perguntaLabel);

        JLabel modificarLabel = new JLabel("Escolha um elemento para alterar:", JLabel.CENTER);
        modificarLabel.setFont(new Font("Arial", Font.BOLD, 24));
        modificarLabel.setBounds(200, 90, 400, 40);
        panelPergunta.add(modificarLabel);

        String arquivo = null;
        String nivel = buttonClicado.getNivel().getText();

//TESTANDO LOGICA---------------------------------------------------------------------------------------------------------------------------------------
        // Seleciona qual arquivo abrir
        if (nivel.startsWith("Nível")) {
            String nivelNum = nivel.split(" ")[1];
            switch (buttonClicado.getTema().getText()) {
                case "Substantivos":
                    arquivo = "n" + nivelNum + "_sub.txt";
                    break;
                case "Adjetivos":
                    arquivo = "n" + nivelNum + "_adje.txt";
                    break;
                case "Verbos":
                    arquivo = "n" + nivelNum + "_verb.txt";
                    break;
            }
        }

        if (arquivo != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
                List<String> linhas = new ArrayList<>();
                String linha;
                int linhaPergunta = 1 + (numeroPergunta - 1) * 7; // A linha da pergunta começa na 1 e pula de sete em sete (1, 8, 15, 22...)
                int linhaAtual = 0;
                String pergunta = null;
                String[] alternativas = new String[4];
                String respostaCorretaTexto = null;

                while ((linha = reader.readLine()) != null) {
                    linhas.add(linha);
                    linhaAtual++;

                    if (linhaAtual == linhaPergunta) {
                        pergunta = linha;
                    } else if (linhaAtual >= linhaPergunta + 1 && linhaAtual <= linhaPergunta + 4) {
                        alternativas[linhaAtual - linhaPergunta - 1] = linha;
                    } else if (linhaAtual == linhaPergunta + 5) {
                        respostaCorretaTexto = linha;
                        break;
                    }
                }

                // Verifica se todos os dados foram carregados
                if (pergunta != null && alternativas[0] != null && respostaCorretaTexto != null) {
                    JButton fraseButton = new JButton(pergunta);
                    fraseButton.setFont(new Font("Arial", Font.PLAIN, 18));
                    fraseButton.setBounds(100, 150, 600, 30);
                    fraseButton.setBackground(Color.white);
                    fraseButton.setBorder(BorderFactory.createLoweredBevelBorder());
                    fraseButton.addActionListener(e -> {
                        String pergModificada = JOptionPane.showInputDialog(framePergunta, "Altere a pergunta:", fraseButton.getText(), JOptionPane.PLAIN_MESSAGE);
                        JOptionPane.showMessageDialog(framePergunta, "Alterando a pergunta..."); //IMPLEMENTAR LOGICA PRA ALTERAR
                        if (linhaPergunta <= linhas.size()) {
                            linhas.set(linhaPergunta - 1, pergModificada);
                        }
                        //LOGICA PRA ALTERAR PERGUNTA

                    });
                    panelPergunta.add(fraseButton);

                    int respostaCorretaIndice = switch (respostaCorretaTexto.trim().toUpperCase()) {
                        case "A" -> 0;
                        case "B" -> 1;
                        case "C" -> 2;
                        case "D" -> 3;
                        default -> -1;
                    };

                    for (int i = 0; i < 4; i++) {
                        JButton alternativaButton = new JButton(alternativas[i]);
                        alternativaButton.setBounds(200, 200 + i * 50, 400, 40);
                        String alternativaTexto = alternativas[i];
                        if (respostaCorretaIndice != -1 && alternativaTexto.equals(alternativas[respostaCorretaIndice])) {
                            alternativaButton.setBackground(Color.green);
                        }

                        alternativaButton.addActionListener(e -> {
                            if (respostaCorretaIndice != -1 && alternativaTexto.equals(alternativas[respostaCorretaIndice])) {
                                String resposta = JOptionPane.showInputDialog(framePergunta, "Altere a resposta correta:", alternativaTexto, JOptionPane.PLAIN_MESSAGE);
                            } else {
                                String resposta = JOptionPane.showInputDialog(framePergunta, "Altere a resposta errada:", alternativaTexto, JOptionPane.PLAIN_MESSAGE);
                            }
                            //LOGICA PRA ALTERAR RESPOSTAS

                        });
                        panelPergunta.add(alternativaButton);
                    }
                }else {
                    JOptionPane.showMessageDialog(framePergunta, "Erro: Dados insuficientes no arquivo.");
                }
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(framePergunta, "Erro ao ler o arquivo: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(framePergunta, "Erro: Arquivo não encontrado.");
        }
//TESTANDO LOGICA-------------------------------------------------------------------------------------------------------------------------------------------------------

        JButton buttonProximo = new JButton("Próximo");
        buttonProximo.setBounds(325, 450, 150, 40);
        buttonProximo.addActionListener(e -> {
            if (numeroPergunta <3) {
                framePergunta.dispose();
                criarJanelaPerguntaProfessor(framePergunta, buttonClicado, pessoa, numeroPergunta + 1);
            } else {
                JOptionPane.showMessageDialog(framePergunta, "Você completou todas as perguntas!");
                framePergunta.dispose();
                criarJanelaNivel(framePergunta, buttonClicado, pessoa);
            }
        });
        panelPergunta.add(buttonProximo);

        JButton buttonVoltar = new JButton("Voltar");
        buttonVoltar.setBounds(10, 510, 100, 40);
        buttonVoltar.addActionListener(e -> {
            framePergunta.dispose();
            criarJanelaTemas(framePergunta, buttonClicado, pessoa);
        });
        panelPergunta.add(buttonVoltar);

        framePergunta.setVisible(true);
    }

// ========================================================== TERMINA JANELA QUESTÃO PROFESSOR ==========================================================================

}
