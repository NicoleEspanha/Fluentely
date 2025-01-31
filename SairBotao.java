import javax.swing.*;
import java.awt.*;

public class SairBotao {
private JButton sair;
    
    public SairBotao(JFrame frame){
        // Botão Sair
        sair = new JButton("Sair");
        if (frame.getTitle().equals("Tela Inicial"))
            sair.setBounds(350, 320, 100, 40);    // Centralizado abaixo dos outros botões
        else
            sair.setBounds(660, 500, 100, 40);  // canto inferior direito
        sair.setBackground(new Color(255, 100, 100));    // Cor de fundo vermelho claro
        sair.setForeground(Color.WHITE);                         // Cor do texto branco

        //Ação do botão
        sair.addActionListener(e -> {
            int resposta = JOptionPane.showConfirmDialog(frame, "Tem certeza que deseja sair?", "Confirmar Saída", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
    }

//get do botão
    public JButton getSairBotao(){
        return sair;
    }
}
