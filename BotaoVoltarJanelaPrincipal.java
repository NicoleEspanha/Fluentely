import javax.swing.*;

public class BotaoVoltarJanelaPrincipal {
     private JButton buttonVoltar;

        public BotaoVoltarJanelaPrincipal(JFrame frameAtual, Pessoa pessoa) {

            //Botão voltar
            buttonVoltar = new JButton("Voltar");
            buttonVoltar.setBounds(25, 500, 100, 40);

            //Ação - botão voltar
            buttonVoltar.addActionListener(e -> {
                frameAtual.dispose();
                new JanelaPrincipal();
            });
        }

        public JButton getButtonVoltar() {
            return buttonVoltar;
        }
}
