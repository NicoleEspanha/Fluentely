import javax.swing.*;

public class BotaoProgresso {
    private JButton buttonProgresso;
    private  int respostasCorretas;
    private static final int TOTAL_PERGUNTAS = 90;
    private static final int PERGUNTAS_POR_TEMA = 10; //Total de perguntas por tema



    public BotaoProgresso(JFrame frame, Pessoa pessoa){

        buttonProgresso = new JButton("Progresso");
        buttonProgresso.setBounds(550, 250, 100, 40);

        //Ação - botão progresso
        buttonProgresso.addActionListener(e -> {

            // Calcula a porcentagem de progresso
            double progresso = ((pessoa.getRespostasFeitas()) / (double) TOTAL_PERGUNTAS) * 100;

            // Formata o valor para mostrar 2 casas decimais
            JOptionPane.showMessageDialog(frame, "Você completou " + String.format("%.2f", progresso) + "% das perguntas.");
        });
    }
    public JButton getButtonProgresso(){
        return buttonProgresso;
    }
    public void setRespostasCorretas(int num){
        respostasCorretas = num;
    }
    public int getRespostasCorretas(){
        return respostasCorretas;
    }
    public int getTOTAL_PERGUNTAS(){
        return TOTAL_PERGUNTAS;
    }
    public  int getPerguntasPorTema() {
        return PERGUNTAS_POR_TEMA;
    }
}
