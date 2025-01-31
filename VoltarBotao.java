import javax.swing.*;

public class VoltarBotao {
    JButton buttonVoltar;

    public VoltarBotao(JFrame frameAtual, JFrame frameAnterior){

        //Botão voltar
        buttonVoltar = new JButton("Voltar");
        buttonVoltar.setBounds(25, 500, 100, 40);

        //Ação - botão voltar
        buttonVoltar.addActionListener(e -> {
            frameAtual.dispose();
            frameAnterior.setVisible(true);
        });
    }

    public JButton getButtonVoltar(){
        return  buttonVoltar;
    }
}
