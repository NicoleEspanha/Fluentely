import javax.swing.*;
import java.awt.*;

public class BotaoTema {
    private JButton buttonTema;

    public BotaoTema(String tema, JFrame frameAnterior, JButton buttonNivel, Pessoa pessoa, int x, int y, int width, int heigth){
        buttonTema = new JButton(tema);
        buttonTema.setBackground(new Color(40, 159, 158));
        buttonTema.setForeground(Color.WHITE);
        buttonTema.setBounds(x, y, width, heigth);

        //Ação - botão
        buttonTema.addActionListener(e ->{
            if (pessoa.getTipo().equals("Aluno")) {
                frameAnterior.setVisible(false);
                new JanelaPerguntaAluno(frameAnterior, buttonTema, buttonNivel, pessoa, 1); // Inicia as perguntas para o aluno a partir da Pergunta 1
            } else {
                frameAnterior.setVisible(false);
                new JanelaPerguntaProfessor(frameAnterior, buttonTema, buttonNivel, pessoa, 1); // Inicia as perguntas para o professor a partir da Pergunta 1
            }
        });
    }
    public JButton getButtonTema() {
        return buttonTema;
    }
}
