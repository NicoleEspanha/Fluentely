import javax.swing.*;

public class Botao extends Main{
    private JButton buttonNivel;
    private JButton buttonTema;

    public void setNivel(JButton buttonNivel){
        this.buttonNivel = buttonNivel;
    }
    public JButton getNivel(){
        return buttonNivel;
    }
    public void setTema(JButton buttonTema){
        this.buttonTema = buttonTema;
    }
    public JButton getTema(){
        return buttonTema;
    }


}
