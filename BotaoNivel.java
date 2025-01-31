import javax.swing.*;

public class BotaoNivel {
    private JButton buttonNivel;

    public BotaoNivel(int nivelNum, JFrame frame, Pessoa pessoa, int x, int y, int width, int heigth){
        buttonNivel = new JButton("Nível "+ nivelNum);
        buttonNivel.setBounds(x, y, width, heigth); // Define posição e tamanho

        //Ação - botão nível
        buttonNivel.addActionListener(e ->{
            frame.setVisible(false);
            new JanelaNivel(frame, buttonNivel, pessoa);
        });
    }
    public JButton getButtonNivel(){
        return buttonNivel;
    }
}
