import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Perguntas {
    private String arquivo;
    private String nivel;
    private String tema;
    private int respostaCorretaIndice;
    private int linhaPergunta;
    private int linhaAtual;
    private String linha;
    private String pergunta;
    private String[] alternativas; //num de alternativas
    private String respostaCorretaTexto;

    public Perguntas(JFrame frame, int numeroPergunta, JButton buttonTema, JButton buttonNivel) {
        nivel = buttonNivel.getText();
        tema = buttonTema.getText();

        // Seleciona qual arquivo abrir
        if (nivel.startsWith("Nível")) {
            String nivelNum = nivel.split(" ")[1];
            switch (tema) {
                case "Substantivos":
                    arquivo = "n" + nivelNum + "_sub.txt";
                    break;
                case "Adjetivos":
                    arquivo = "n" + nivelNum + "_adje.txt";
                    break;
                case "Verbos":
                    arquivo = "n" + nivelNum + "_verb.txt";
                    break;
            }
        }
        //lê o arquivo se ele não estiver vazio
        if (arquivo != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
                linhaPergunta = 1 + (numeroPergunta - 1) * 7; // A linha da pergunta começa na 1 e pula de sete em sete (1, 8, 15, 22...)
                linhaAtual = 0;
                alternativas = new String[4];//num de alternativas

                //cursor q vai pulando de linha em linha
                while ((linha = reader.readLine()) != null) {
                    linhaAtual++;
                    //indica se está lendo uma pergunta, uma alternativa ou a resposta
                    if (linhaAtual == linhaPergunta) {
                        pergunta = linha;
                    } else if (linhaAtual >= linhaPergunta + 1 && linhaAtual <= linhaPergunta + 4) {
                        alternativas[linhaAtual - linhaPergunta - 1] = linha;
                    } else if (linhaAtual == linhaPergunta + 5) {
                        respostaCorretaTexto = linha;
                        break;
                    }
                }

                // Verifica se todos os dados foram carregados e escreve na tela
                if (pergunta != null && alternativas[0] != null && respostaCorretaTexto != null) {

                    respostaCorretaIndice = switch (respostaCorretaTexto.trim().toUpperCase()) {
                        case "A" -> 0;
                        case "B" -> 1;
                        case "C" -> 2;
                        case "D" -> 3;
                        default -> -1;
                    };
                    //tratando excessões
                } else {
                    JOptionPane.showMessageDialog(frame, "Erro: Dados insuficientes no arquivo.");
                }
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Erro ao ler o arquivo: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Erro: Arquivo não encontrado.");
        }
    }

    public String getPergunta() {
        return pergunta;
    }
    public String[] getAlternativasVetor(){
        return alternativas;
    }
    public String getAlternativas(int i){
        return alternativas[i];
    }
    public int getRespostaCorretaIndice(){
        return respostaCorretaIndice;
    }
    public String getArquivo(){
        return arquivo;
    }
    public String getRespostaCorretaTexto(){
        return respostaCorretaTexto;
    }
}
