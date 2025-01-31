import javax.swing.*;

public class BotaoProximo {
    private JButton buttonProximo;
    private int PERGUNTAS_POR_TEMA;
    
    public BotaoProximo(JFrame frame, JButton buttonTema, JButton buttonNivel, Pessoa pessoa, int numeroPergunta){
        buttonProximo = new JButton("Próximo");
        buttonProximo.setBounds(325, 450, 150, 40);

        BotaoProgresso x = new BotaoProgresso(frame, pessoa);
        this.PERGUNTAS_POR_TEMA = x.getPerguntasPorTema();
        
        //Ação - botão
        buttonProximo.addActionListener(e -> {
            pessoa.somaUmRespostasFeitas();
            if (numeroPergunta < PERGUNTAS_POR_TEMA) {
                frame.setVisible(false);
                if (pessoa.getTipo().equals("Aluno"))
                    new JanelaPerguntaAluno(frame, buttonTema, buttonNivel, pessoa, numeroPergunta + 1);
                else
                    new JanelaPerguntaProfessor(frame, buttonTema,buttonNivel,pessoa, numeroPergunta +1);
                //informa q já completou todas as perguntas
            } else {
                JOptionPane.showMessageDialog(frame, "Você completou todas as perguntas!");
                frame.dispose();
                new JanelaNivel(frame, buttonNivel, pessoa);
            }
        });
    }

    public JButton getButtonProximo(){
        return buttonProximo;
    }
}