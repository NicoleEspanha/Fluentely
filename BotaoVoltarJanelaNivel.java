import javax.swing.*;

public class BotaoVoltarJanelaNivel {
    private JButton buttonVoltar;

    public BotaoVoltarJanelaNivel(JFrame frameAtual, Pessoa pessoa) {

        //Botão voltar
        buttonVoltar = new JButton("Voltar");
        buttonVoltar.setBounds(25, 500, 100, 40);

        //Ação - botão voltar
        buttonVoltar.addActionListener(e -> {
            frameAtual.dispose();
            if (pessoa.getTipo().equals("Aluno"))
                new JanelaAluno(frameAtual, pessoa);
            else
                new JanelaProfessor(frameAtual, pessoa);
        });
    }


    public JButton getButtonVoltar() {
        return buttonVoltar;
    }
}


