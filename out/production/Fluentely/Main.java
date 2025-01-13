import javax.swing.*;
import java.awt.*;

public class Main {

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
        backgroundPanel.setBackground(new Color(200, 230, 255)); // Cor de fundo azul claro
        backgroundPanel.setBounds(0, 0, 800, 600);
        frame.add(backgroundPanel);

        // Título principal
        JLabel titulo = new JLabel("Bem-vindo ao Fluentily", JLabel.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 32)); // Fonte mais elegante
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

        JButton buttonProgresso = new JButton("Progresso");
        buttonProgresso.setBounds(550, 200, 100, 40);
        panelAluno.add(buttonProgresso);

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
    private static void criarJanelaTemas(JFrame frameAnterior, Botao buttonClicado, Pessoa pessoa){

        JFrame frameSubstantivos = new JFrame(buttonClicado.getTema().getText() + " - " + buttonClicado.getNivel().getText() + " - " + pessoa.getTipo());
        frameSubstantivos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameSubstantivos.setSize(800, 600);
        frameSubstantivos.setLocationRelativeTo(null);
        frameSubstantivos.setLayout(null);

        JPanel panelSubstantivos = new JPanel();
        panelSubstantivos.setLayout(null);
        panelSubstantivos.setBackground(new Color(41, 147, 227)); // Cor de fundo azul claro
        panelSubstantivos.setBounds(0, 0, 800, 600);
        frameSubstantivos.add(panelSubstantivos);

        if (pessoa.equals("Professor")){

        }
        else if(pessoa.equals("Aluno")){

        }

        JButton buttonVoltar = new JButton("Voltar");
        buttonVoltar.setBounds(10, 510, 100, 40);
        buttonVoltar.addActionListener(e -> {
            frameSubstantivos.dispose();
            criarJanelaNivel(frameAnterior, buttonClicado, pessoa);

        });
        panelSubstantivos.add(buttonVoltar);

        frameSubstantivos.setVisible(true);
    }

// ========================================================== TERMINA JANELA TEMAS ==============================================================================

// ========================================================== COMEÇA JANELA QUESTÃO ==============================================================================
}