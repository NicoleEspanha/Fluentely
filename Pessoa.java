public class Pessoa{
    private String nome;
    private String tipo;
    private int respostasCorretas;
    private int respostasFeitas;

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public String getTipo(){
        return tipo;
    }
    public int getRespostasCorretas(){
        return respostasCorretas;
    }
    public int getRespostasFeitas(){
        return respostasFeitas;
    }
    public void somaUmRespostasCorretas(){
        respostasCorretas++;
    }
    public void somaUmRespostasFeitas(){
        respostasFeitas ++;

    }
}
